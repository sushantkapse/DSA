import java.util.*;

import org.w3c.dom.Node;
public class BinarySearchTree1 {

    static class  Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
        
    }

    public static Node createBST(int si, int ei,int arr[]) {
        if(si > ei){
            return null;
        }
        int mid = (si+ei)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST( si, mid - 1, arr);
        root.right = createBST( mid + 1, ei, arr);

        return root ; 
    }

    public static void inorder(Node root) {
        if(root == null){
            return ;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void inorder_path(Node root, ArrayList<Integer> path) {
         if(root == null){
            return ;
        }
        inorder_path(root.left, path);
        path.add(root.data);
        // inorder(root.right);
        inorder_path(root.right, path);
    }

    public static Node BST_2_balanceBST(Node root) {
        

        ArrayList<Integer> inorder = new ArrayList<>();
        inorder_path(root, inorder);

        root = createBST1(inorder, 0,inorder.size() -1 );

        return root ; 
        }

    public static Node createBST1(ArrayList<Integer> inorder , int si , int ei) {
        if(si > ei){
            return null;
        }
        int mid = (si+ei)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST1(inorder, si, mid -1);
        root.right = createBST1(inorder, mid + 1, ei);

        return root ; 
    }

     public static void preorder(Node root) {
        if(root == null){
            return ;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static class Info {
        boolean isBst;
        int size;
        int min;
        int max;
        Info(boolean isBst,int size,int min, int max){
            this.isBst = isBst;
            this.size =size;
            this.min = min;
            this.max = max;
        }
        
    }

    static int maxsize = 0;

    public static Info largeBStsize(Node root) {

        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftinfo = largeBStsize(root.left);
        Info rightinfo = largeBStsize(root.right);
        int size =  leftinfo.size + rightinfo.size + 1;
        int min = Math.min(root.data, Math.min(leftinfo.min, rightinfo.min));
        int max =  Math.max(root.data, Math.max(leftinfo.max, rightinfo.max));

        if(root.data <= leftinfo.max || root.data >= rightinfo.min){
            return new Info(false, size, min, max);

        }

        if(leftinfo.isBst && rightinfo.isBst){
            maxsize = Math.max(size, maxsize);
            return new Info(true, maxsize, min, max);

        }

        return new Info(false, size, min, max);
    }


    public static Node merge_tree(Node root1, Node root2) {
        ArrayList<Integer> path1 = new ArrayList<>();
        inorder_path(root1, path1);
        
        ArrayList<Integer> path2 = new ArrayList<>();
        inorder_path(root2, path2);
        
        ArrayList<Integer> merge_path = new ArrayList<>();

        int i = 0,  j = 0;
        while (i< path1.size() && j < path2.size()) {
            if(path1.get(i) < path2.get(j)){

                merge_path.add(path1.get(i));
                i ++ ;
            }else{
                merge_path.add(path2.get(j));
                j ++ ;
            }
        }

        while (i < path1.size()) {
            merge_path.add(path1.get(i));
            i++;
        }
        while (j < path2.size()) {
            merge_path.add(path2.get(j));
            j++;
        }

        System.out.println(path1);
        System.out.println(path2);

        return createBST1(merge_path, 0, merge_path.size()-1);
        

         
    }



    public static void main(String[] args) {
        // int arr[] = {3,5,6,8,10,11,12};
        // Node root = null;
        // Node root = createBST(0, arr.length - 1, arr);
        // inorder(root);
        // preorder(root);

        // Node root = new Node(50);
        // root.left = new Node(30);
        // root.left.left = new Node(5);
        // root.left.right = new Node(20);
        
        // // root.left.left.left = new Node(3);
        
        // root.right = new Node(60);
        // root.right.left = new Node(45);
        // root.right.right = new Node(70);
        // root.right.right.left = new Node(65);
        // root.right.right.right = new Node(80);
        // preorder(root);
        // System.out.println();

        // // ArrayList<Integer> path = inorder_path(root, new ArrayList<>());
        // // root = BST_2_balanceBST(0, path.size()-1, path);
        // // preorder(root);
        // // inorder(root);
        
        // root = BST_2_balanceBST(root);
        // inorder(root);
        // preorder(root);
        
        // System.out.println(largeBStsize(root).);

        // Info info = largeBStsize(root);
        // System.out.println(maxsize);
        
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(4);
        
        Node root1 = new Node(9);
        root1.left = new Node(3);
        root1.right = new Node(12);

        root = merge_tree(root, root1);
        inorder(root);
        
    }
}
