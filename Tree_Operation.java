import java.util.*;

public class Tree_Operation {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left=left;
            this.right=right;
        }

    }
    public static int height(Node root) {
        if(root == null){
            return 0 ;
        }

        int left_height = height(root.left);
        int right_height = height(root.right);
        int ht = Math.max(left_height, right_height) + 1;
        return ht ;
    }

    public static int diameter(Node root) {
        if(root == null){
            return 0;
        }
        int left_height = height(root.left);
        int diameter_left= diameter(root.left);
        int right_height = height(root.right);
        int right_diameter = diameter(root.right);

        int diam = Math.max(Math.max(diameter_left, right_diameter),left_height + right_height + 1);
        return diam;
    }

    static class Info {
        int height;
        int diameter;
        Info(int height,int diameter){
            this.height=height;
            this.diameter=diameter;
        }   
    }

    public static Info diameter2(Node root) {
        if(root == null){
            return  new Info(0,0);
        }

        Info left =  diameter2(root.left);
        Info right =  diameter2(root.right);
        int selfdiam = left.height + right.height + 1;
        int diam = Math.max(selfdiam, Math.max(left.diameter, right.diameter));
        int height =  Math.max(left.height, right.height) + 1;

        return new Info(height,diam);
        
    }

    public static boolean isIdentical(Node root, Node subroot) {
        if(root == null && subroot == null){
            return true;
        }
        else if (root == null || subroot == null || root.data != subroot.data){
            return false;
        }

        if(!isIdentical(root.left, subroot.left)){
            return false;
        }
        if(!isIdentical(root.right, subroot.right)){
            return false;
        }

        return true;
    }

    public static boolean isSubtree(Node root, Node subroot) {
     if(root == null){
        return false;
     }  
     if(root.data == subroot.data){

         if(isIdentical(root,subroot)){
            return true;
         }
     } 

     return isSubtree(root.left, subroot) || isSubtree(root.right, subroot);
    }

    static class Info1{
        Node node;
        int hd;
        Info1(Node node,int hd){
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topview(Node root) {
        Queue<Info1> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        
        int min= 0, max = 0;

        q.add(new Info1(root, 0));
        q.add(null);


        while (!q.isEmpty()) {
            Info1 curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break ; 
                }
                else{
                    q.add(null);
                }
            }
            else{ 
                // if(!map.containsKey(curr.hd)){
                //     map.put(curr.hd, curr.node);
                // }

                // if(curr.node.left != null){
                //     q.add(new Info1(curr.node.left, curr.hd-1));
                //     min = Math.min(min, curr.hd-1);
                // }

                // if( curr.node.right != null){
                //     q.add(new Info1(curr.node.right, curr.hd+1));
                //     max = Math.max(max, curr.hd+1);
                // }

                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }

                if(curr.node.left != null){
                    q.add(new Info1(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                    // System.out.println(min);
                }

                if(curr.node.right != null){
                    q.add(new Info1(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd + 1);
                    // System.out.println(max);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            // System.out.println(map.get(i).data + " ");
            System.out.println(map.get(i).data);
        }

        // for (int i = mi; i < array.length; i++) {
            
        // }

        // System.out.println("hello");
        // System.out.println(min);
        // System.out.println(max);

    }

    
    public static void main(String[] args) {
        Node newnode = new Node(10);
        newnode.left=new Node(20);
        newnode.right=new Node(30);
        newnode.left.left=new Node(40);
        newnode.left.right=new Node(50);
        newnode.right.left=new Node(60);
        newnode.right.right=new Node(70);
        // newnode.right.right.right=new Node(60);
        // newnode.right.right.right.right=new Node(60);
        
        // Node subroot = new Node(60);
        // // subroot.left=new Node(20);
        // // subroot.left=new Node(40);
        // subroot.right=new Node(60);
        // subroot.right.right=new Node(60);

        // System.out.println(height(newnode));
        // System.out.println(diameter(newnode));
        // System.out.println(diameter2(newnode).diameter);
        // System.out.println(isSubtree(newnode, subroot));
        // isSubtree(newnode, subroot);

        topview(newnode);
    }
}
