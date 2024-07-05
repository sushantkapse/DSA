import java.util.*;

public class Binarytree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }


    static class BinarytreeB{
        static int idx = -1;
        public static Node builtTree(int node[]) {
          idx ++;
          if(node[idx]==-1){
            return null ;
          }
          Node newNode =  new Node(node[idx]);
          // System.out.println(newNode.data);
          newNode.left=builtTree(node);
          newNode.right=builtTree(node);

          return newNode;
        }


        public static void preorder(Node node) {
          if(node == null){
            return ;
          }
          System.out.println(node.data);
          preorder(node.left);
          preorder(node.right);

        }

        public static void inorder(Node node) {
          if(node == null){
            return ;
          }
          preorder(node.left);
          System.out.println(node.data);
          preorder(node.right);

        }

        public static void postorder(Node node) {
          if(node == null){
            return ;
          }
          preorder(node.left);
          preorder(node.right);
          System.out.println(node.data);

        }

        public static void levelOrder(Node root) {
          if(root == null){
            return ;
          }

          Queue<Node> q = new LinkedList<>();
          q.add(root);
          q.add(null);

          while (!q.isEmpty()) {
              Node currNode = q.remove();
              if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                  break;
                }else{
                  q.add(null);
                }
              }

              else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                  q.add(currNode.left);
                }
                if(currNode.right != null){
                  q.add(currNode.right);
                }
              }
          }
          


      
        }

        public static int height(Node root) {
          
          if(root == null){
            return 0 ;
          }

          int left_height = height(root.left);
          int right_height = height(root.right);
          int ht = Math.max(left_height, right_height) + 1;
          // System.out.println(ht);
          return ht;
        }

         public static int count(Node root) {
          
          if(root == null){
            return 0 ;
          }

          int left_count = count(root.left);
          int right_count = count(root.right);
          int ct =  left_count + 1 + right_count;
          // System.out.println(ht);
          return ct;
        }


        public static int sum(Node root) {
          
          if(root == null){
            return 0 ;
          }

          int left_sum = sum(root.left);
          int right_sum = sum(root.right);
          int cm =  left_sum + root.data + right_sum;
          // System.out.println(ht);
          return cm;
        }


    }


    public static void main(String[] args) {
        // System.out.println("hello");

        int node[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1,-1};

        BinarytreeB tree = new BinarytreeB();
        Node root =tree.builtTree(node);
        // System.out.println(root.data);
        // tree.preorder(root);
        // tree.inorder(root);
        // tree.postorder(root);
        // tree.levelOrder(root);
        // System.out.println(tree.height(root));
        // System.out.println(tree.count(root));
        // System.out.println(tree.sum(root));

    }
}
