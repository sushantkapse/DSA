import java.util.Stack;
public class StackOperation {

    public static void Pushatbottom(Stack<Integer> s, int data) {
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int topdata=s.pop();
        Pushatbottom(s, data);
        s.push(topdata);
    }
    /**
     * @param str
     */
    public static void ReverseString(String str) {
        Stack<Character> s1 = new Stack<>();
        int index = 0;
        while (index < str.length()) {
            s1.push(str.charAt(index));
            index++;
        }

        StringBuilder sb = new StringBuilder("");
       
        while (!s1.isEmpty()){
            char curr = s1.pop();
            sb.append(curr);

        }    
        str = sb.toString();
        System.out.println(str);

    }

    public static void reverse(Stack<Integer> s) {
        if(s.isEmpty()){
            return;
        }

        int val= s.pop();
        reverse(s);
        Pushatbottom(s, val);

    }
    public static void print(Stack<Integer> s) {
        while (!s.isEmpty()) {
            
            System.out.println(s.pop());
        }
    }
    
    // public static void print() {
    //         if(s.isempty()){
    //             System.out.println("Stack is empty");
    //         }
    //         Node current = s;
    //         while (current != null) {
    //             System.out.println(current.data);
    //             current=current.next;
    //         }
    //         System.out.println();
    //     }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(50);
        // Pushatbottom(s,1);
        // print(s);
        reverse(s);
        print(s);        



        // String s = "abc";
        // ReverseString(s);
        
    }
}
