public class Doubly {
    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static int size;
    public static Node head;
    public static Node tail;

    public void addfirst(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;

    }

    public int deletefirst() {
        if (head == null) {
            System.out.println("linked list is empty");
            return Integer.MIN_VALUE;
        }
        if (size==1){
            int val = head.data;
            head=tail=null;
            size -- ;
            return val; 
        }
        
        int val = head.data;
        head = head.next;
        head.prev=null;
        size--;
        return val;

    }

    public static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");

    }

    public static void main(String[] args) {
        Doubly dl = new Doubly();
        dl.addfirst(10);
        dl.addfirst(20);
        dl.addfirst(30);
        dl.print();
        System.out.println(size);
        int a = dl.deletefirst();
        dl.print();
    System.out.println(a);    }
}
