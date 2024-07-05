import java.util.*;
public class Tree_Operation1 {
    static class Node{
        Node left;
        Node right;
        int data;
        public Node(int data){
            this.data = data;
            this.left=left;
            this.right=right;
        
        }
    }

    public static void kthnode(Node root, int level , int k) {
        if(root == null){
            return ;
        }
        if(level == k){
            System.out.println(root.data);
        }

        kthnode(root.left, level + 1, k);
        kthnode(root.right, level + 1, k);
    }

    public static boolean getpath(Node root, int n1, ArrayList<Node> path) {
        if(root == null){
            return false ;
        }

        path.add(root);

        if(root.data == n1){
            return true;
        }

        boolean foundleft = getpath(root.left, n1, path);
        boolean foundright = getpath(root.right, n1, path);

        if(foundleft || foundright){
            return true;
        }

        path.remove(path.size()-1);
        return false;
       
    }

    public static Node lca( Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>(); 
        ArrayList<Node> path2 = new ArrayList<>(); 

        getpath(root,n1,path1);
        getpath(root,n2,path2);

        int i = 0;

        for (; i < path1.size() &&  i < path2.size(); i++) {
            if( path1.get(i) != path2.get(i)){
                break ;
            }
        }

        Node lca = path1.get(i-1);
        return lca;
    }

    public static Node lca2(Node root, int n1, int n2) {
        if(root == null){
            return null;
        }

        if(root.data == n1 || root.data == n2){
            return root ;
        }

        Node leftlca = lca2(root.left, n1, n2);
        Node rightlca = lca2(root.left, n1, n2);

        if(leftlca == null ){
            return rightlca;
        }

        if(rightlca == null){
            return leftlca;
        }

        return root;
    }

    public static int lcadistance( Node root , int n) {
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return 0;
        }

        int left = lcadistance(root.left, n);
        int right = lcadistance(root.right, n);

        if(left == -1 && right == -1){
            return -1;
        }else if(left == -1){
            return right + 1;
        }else{
            return left +1;
        }
    }

    public static int mindistance(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);

        int leftdistance = lcadistance(lca,n1);
        int rightdistance = lcadistance(lca,n2);

        return leftdistance + rightdistance ;

    }

    public static int kthancestor (Node root, int n, int k) {
        if(root == null){
            return -1;
        }

        if(root.data == n){
            return  0 ;
        }

        int left = kthancestor(root.left, n, k);
        int right = kthancestor(root.right, n, k);

        if(left == -1 && right == -1){
            return -1;
        }
        int max = Math.max(left, right);
        if(max + 1 == k){
            System.out.println(root.data);
        }

        return max + 1;
    }

    public static int transform(Node root) {
        if(root == null){
            return 0;
        }

        int leftside =  transform(root.left);
        int rightside =  transform(root.right);

        int data = root.data;

        int newleft = root.left == null ? 0 : root.left.data;
        int newright = root.right == null ? 0 : root.right.data;

        root.data =  leftside + newleft + rightside + newright;

        return data;
    }

    public static void preorder(Node root) {
        if(root == null){
            return ;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {

        Node newnode = new Node(10);
        newnode.left = new Node(20);
        newnode.right = new Node(30);
        newnode.left.left = new Node(40);
        newnode.left.right = new Node(50);
        newnode.right.right = new Node(70);
        newnode.right.left = new Node(60);
        preorder(newnode);
        transform(newnode);
        System.out.println();
        preorder(newnode);

        // kthnode(newnode, 1, 3);
        // System.out.println(lca2(newnode, 40, 30).data);
        // System.out.println(mindistance(newnode, 40, 30));
        // System.out.println(kthancestor(newnode, 40, 1));
        // kthancestor(newnode, 40, 2);
        
    }
}
