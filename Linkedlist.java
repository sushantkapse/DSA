public class Linkedlist {
    /**
     * Node
     */
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addfirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    public void addlast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        Node temp = head;
        if (head == null) {
            System.out.println("Linked List is empty ");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removefirst() {

        if (head == null) {
            System.out.println("List is empty");
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        return val;
    }

    public int removelast() {
        Node prev = head;
        if (head == null) {
            System.out.println("List is empty");
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;

    }

    public void size() {
        int i = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            i++;
        }
        System.out.println("Size is : " + i);
    }

    public void middle(int pos, int data) {
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < pos - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int isearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }

            temp = temp.next;
            i++;

        }

        return -1;
    }

    public void reverse() {
        Node prev = null;
        Node current = tail = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int rsearch(int key) {
        return helper(head, key);
    }

    public Node midNode(Node head){

        Node slow=head;
        Node fast=head;

        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public boolean pallindrome(){
        Node mid = midNode(head);

        Node prev = null;
        Node current = mid;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        Node right = prev;
        Node left=head;
        while (right != null) {
            if(left.data != right.data){
                return false;
            }
                left=left.next;
                right=right.next;
            
            }
            return true;


    }
    public void deletenthfromEnd(int pos){
        int size=0;
        Node temp=head;
        while (temp != null) {
            temp=temp.next;
            size++;
        }

        if (pos==size){
            head=head.next;
            return;
        }
        int i = 1;
        Node prev =head;
        while (i< size -i) {
            prev = prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
        
    }
    public static void checkcycle() {
        Node slow=head;
        Node fast=head;
        while (fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                System.out.println("cycle is present");
                return;
            }
        }
        System.out.println("cycle not present");
    }
    public static void removecycle(){
        Node slow=head;
        Node fast=head;
        int sl=0,fs=0;
        while (fast != null && fast.next != null){
            slow=slow.next;
            sl++;
            fast=fast.next.next;
            
            if(fs<sl){

            }
        }
        
    }

    public static Node getmid(Node head) {
        Node slow= head;
        Node fast= head.next;

        while(fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;

    }

    public static Node merge(Node head1, Node head2) {
        Node mergelist = new Node(-1);
        Node temp = mergelist;

        while (head1 !=null && head2 != null ) {
            if(head1.data <= head2.data){
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else{
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
        }
        
        while (head1 != null) {
            temp.next=head1;
            head1=head1.next;
            temp=temp.next;
            
        }
        
        while (head2 != null) {
            temp.next=head2;
            head2=head2.next;
            temp=temp.next;
            
        }

        return mergelist.next;
        
    }
    public static Node mergesort(Node head) {

        if(head == null || head.next == null){
            return head;
        }

        // get mid node 
        Node mid = getmid(head);

        //divide linked list(operation of merge sort)
        Node righthead=mid.next;
        mid.next=null;
        Node newleft = mergesort(head);
        Node newright = mergesort(righthead);

        //merging divided linked list
        
        return merge(newleft,newright);

    }
    public static void zigzag() {
        // find mid 

        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast=fast.next.next;

        }
        Node mid = slow;

        // make two list
        Node curr = mid.next;
        mid.next=null;
        
        // reverse second half

        Node prev = null;
        Node next;


        while (curr != null) {
            next = curr.next;
            curr.next =prev;
            prev=curr;
            curr =next;
        }

        // alternate zigzag
        Node left = head;
        Node right = prev ;
        Node nextl,nextr;
        
        while (left != null && right != null) {
            nextl = left.next;
            left.next=right;
            nextr=right.next;
            right.next=nextl;
            right=nextr;
            left=nextl;       }


    }

    public static void main(String[] args) {
        Linkedlist l = new Linkedlist();
        l.addfirst(10);
        l.addfirst(20);
        l.addlast(30);
        l.addlast(40);
        l.addlast(50);
        l.addlast(60);
        // tail.next=head;
        
        // l.print();
        // l.size();
        // l.removefirst();
        // l.removefirst();
        // l.print();
        // l.addfirst(10);
        // l.print();
        // l.removelast();
        // l.print();
        // l.middle(2, 60);
        // l.print();
        // System.out.println(l.isearch(40));
        // System.out.println(l.rsearch(60));
        // l.print();
        // l.reverse();
        // l.print();
        // l.reverse();
        // l.print();
        // System.out.println("--------------");
        // l.deletenthfromEnd(2);
        // l.removelast();
        // l.removelast();
        // l.addlast(10);
        // l.addlast(20);
        l.print();
        // l.checkcycle();
        // if(l.pallindrome()==true){
        //     System.out.println("Pallindrome");
        // }
        // else{
        //     System.out.println("No Pallindrome");
        // }

        l.head = l.mergesort(l.head);
        l.print();

        l.zigzag();
        l.print();
    }
}
