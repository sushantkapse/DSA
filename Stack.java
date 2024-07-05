import java.util.ArrayList;

public class Stack {
    static class Stackb {

        
        // creating array list
         static ArrayList<Integer> list = new ArrayList<>();

         // check array list is empty or not
         public static boolean isempty() {
            return list.size()==0;
         }
         // insert push condition in stack 
        public static  void push(int data) {
            list.add(data);
        }

        // pop data 
        public static  int pop() {
            if (isempty()){
                System.out.println("stack is empty");
            }
            
            int val = list.get(list.size()-1);
            list.remove(list.size()-1);
            return val;
        }

        // peek data 

        public static int peek(){
            return list.get(list.size()-1);
        }


    }

    static class Node{
        int data ;
        Node next;
         Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    

        static class Stackl{
            static Node top = null;
            

            public static boolean isempty() {
                return top==null;
            }

            public static void push(int data) {
                Node newnode = new Node(data);
                // size ++;
                
                if (isempty()){
                    top=newnode;
                    return;

                }
                newnode.next=top;
                top=newnode;
                
            }

            public static int pop(){
                if(isempty()){
                    return -1;
                }

                int val = top.data;
                top=top.next;
                // size--;
                return val;

                
            }
            public static int peek(){
                if(isempty()){
                    return -1;
                }
                return top.data;
            }

            // public static void print() {
            //     if(isempty()){
            //         System.out.println("Stack is empty");
            //     }
            //     Node current = top;
            //     while (current != null) {
            //         System.out.println(current.data);
            //         current=current.next;
            //     }
            //     System.out.println();
            // }
        }

    
        
    

    public static void main(String[] args) {
        // Stackb s = new Stackb();
        // s.push(10);
        // s.push(20);
        // s.push(30);

        // int a = s.pop();
        // System.out.println(a);
 
        // int b = s.peek();
        // System.out.println(b);
        
        Stackl s = new Stackl();
        s.push(10);
        s.push(20);
        s.push(30);

        while (!s.isempty()) {
            System.out.println(s.peek());
            s.pop();
        }
        // s.print();
        // System.out.println(s.pop());
        // System.out.println(s.pop());


        
    }
}
