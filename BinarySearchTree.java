import java.util.*;
public class BinarySearchTree {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }

    public static Node buildBST(Node root, int val) {
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            root.left = buildBST(root.left, val);
        }else{
            root.right = buildBST(root.right, val);
        }

        return root;
        
    }
    public static boolean search(Node root, int val) {
        if(root == null){
            return false;
        }
        if(root.data == val){
            return true;
        }

        if(root.data > val){
            return search(root.left, val);
        } else{
            return search(root.right, val);
        }

        // return false;
    
    }

    public static void printinOrder(Node root, int k1, int k2) {

        if(root == null){
            return ;
        }
        if(root.data >= k1 && root.data <= k2){
            printinOrder(root.left, k1, k2);
            System.out.print(root.data + " ");
            printinOrder(root.right, k1, k2);
        }

        else if(root.data > k2){
            printinOrder(root.left, k1, k2);
        } else{
            printinOrder(root.right, k1, k2);
        }
    }

    public static void inorder(Node root) {

        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+  " ");
        inorder(root.right);
    }

    public static void printpath(AbstractList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.print("null");
        System.out.println();
    }

    public static void root_to_leaf(Node root, ArrayList<Integer> path) {
        if(root == null){
            return ;
        }
        path.add(root.data);

        if (root.left == null && root.right== null) {
            printpath(path);
        }
        root_to_leaf(root.left,path);
        root_to_leaf(root.right,path);
        path.remove(path.size()-1);

        

    }

    public static boolean validate(Node root, Node min, Node max) {
       if (root == null) {
        return true;
       }

       if(min != null && root.data <= min.data){
        return false;
       }else if(max != null && root.data >= max.data){
        return false;
       }

       return validate(root.left, min, max) && validate(root.right, min, max);
    }

    public static Node mirror(Node root) {
        if(root == null){
            return null;
        }

        Node lefts = mirror(root.left); 
        Node rights = mirror(root.right);
        
        root.left = rights;
        root.right = lefts;

        return root;
    }

    public static Node deletenode(Node root, int val) {
        // System.out.println(root.data);
        if(root.data < val){
            root.right = deletenode(root.right, val);
        }
        else if(root.data > val){
            root.left = deletenode(root.left, val);
        }else {
            if(root.left == null && root.right == null){
                return null;
            }
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            Node IS = findInordersuccesor(root.right);
            root.data = IS.data;
            root.right = deletenode(root.right, IS.data);
        }

        return root;

    }

    public static Node findInordersuccesor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    
    public static void main(String[] args) {
        int arr[] = { 8,5,3,1,4,6,10,11,14};
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = buildBST(root, arr[i]);
        }
        inorder(root);
        System.out.println();
        // System.out.println();
        // System.out.println(root.left.data);
        Node root1 = deletenode(root, 8);
        inorder(root1);

        // if(search(root, 6)){
        //     System.out.println("found");
        // }else{
        //     System.out.println("Not Found");
        // }

        // printinOrder(root, 1, 6);
        // ArrayList<Integer> path = null;
        // root_to_leaf(root, new ArrayList<>());
        // System.out.println(validate(root,null ,null));
        // inorder(root);

        // Node mir = mirror(root);

        // inorder(mir);

        

    }
}
