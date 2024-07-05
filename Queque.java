import java.util.*;
public class Queque {
    // class queueA{
    //     static int arr[];
    //     static int size;
    //     static int rear;
    //     queueA(int n){
    //         arr= new int[n];
    //         size = n;
    //         rear = -1;
    //     }
    //     public static boolean isEmpty(){
    //         return rear == -1;
    //     }
    //     public static void enque(int data) {
    //         if(rear == size-1){
    //             System.out.println("Queue is full");
    //             return;
    //         }
    //         rear=rear+1;
    //         arr[rear]=data;
    //     }
    //     public static int deque(){
    //         if(isEmpty()){
    //             System.out.println("queue is empty");
    //             return -1;
    //         }
    //         int front = arr[0];
    //         for (int i = 0; i < arr.length-1; i++) {
    //             arr[i]=arr[i+1];
    //         }
    //         rear=rear-1;
    //         return front;
    //     }
    //     public static int peek() {
    //         if(isEmpty()){
    //             System.out.println("Queue is empty");
    //             return -1;
    //         }
    //         return arr[0];
    //     }
    // }
        class queueB{
            static int arr[];
            static int size;
            static int front;
            static int rear;
            queueB(int n){
                arr= new int[n];
            size = n;
            rear = -1;
            front = -1;
            }

            public static boolean isEmpty() {
                return front==-1 && rear==-1;
            }

            public static boolean isfull(){
                return (rear +1)%size==front;
            }

            public static void enque(int data) {
                if(isfull()){
                    System.out.println("queue is full");
                    return;
                }

                if(front == -1){
                    front = 0;
                }
                rear=(rear +1)%size;
                arr[rear]=data;
            }

            public static int deque(){
                if(isEmpty()){
                    System.out.println("queue is empty");
                    return -1;
                }
            int temp = arr[front];
            if(front==rear){
                front=rear=-1;
            }else{
                front = (front + 1)%size; 
               }
               return temp;
          }

          public static int peek() {
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }
            return arr[front];
          }
        }
        

        static class Node{
            int data;
            Node next;
            public Node(int data){
                this.data=data;
                this.next = null;
            }
        }

         class QueueLL{
            static Node head;
            static Node tail;

            public static boolean isEmpty() {
                return head ==null;
            }
            public static void add(int data) {
                Node newnode = new Node(data);
                if(isEmpty()){
                    head=tail=newnode;
                }

                tail.next=newnode;
                tail=newnode;
                
            }

            public static int remove(){
                if(isEmpty()){
                    System.out.println("queue is empty");
                    return -1;
                }
                int front = head.data;
                if(head==tail){
                    head=tail=null;
                }else{
                    head=head.next;
                }
                return front;
            }
            
            public static int peek(){
                if(isEmpty()){
                    System.out.println("queue is empty");
                    return -1;
                }

                return head.data;
            }


            
        }
        
            

        

    
    public static void main(String[] args) {
        // Queque q = new Queque();
        // Queque.queueA q1 = q.new queueA(3);
        // Queque.queueB q2 = q.new queueB(3);
        // Queque.QueueLL q3 = q.new QueueLL();

        // System.out.println(q3.isEmpty());
        // q3.add(10);
        // q3.add(20);
        // q3.add(20);

        // while (!q3.isEmpty()) {
        //     System.out.println(q3.peek());
        //     q3.remove();
        // }

        
       
        // q1.enque(10);
        // q1.enque(30);
        // q1.enque(20);
        // // q1.enque(10);

        // while (!q1.isEmpty()) {
        //     System.out.println(q1.peek());
        //     q1.deque();
        // }

        // q2.enque(10);
        // q2.enque(20);
        // q2.enque(30);
        // System.out.println(q2.deque());
        // q2.enque(40);
        // System.out.println(q2.deque());
        // q2.enque(50);
        // //  q2.enque(30);

        // while (!q2.isEmpty()) {
        //     System.out.println(q2.peek());
        //     q2.deque();
        // }

        

        // java collection framework
        // In it Queue is interface so we cant create a object of it so we associate a Linkedlist & Arraydeque class
        // all operation time complexity is O(1);

        // Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println(q);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }
    }
}
