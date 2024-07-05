import java.util.Stack;
public class Stockspan {

    public static void calculatespan(int Stock[],int span[]) {

        // stack for only element index
        Stack<Integer> s = new Stack<>();

        // first push index of first item
        s.push(0);

        // span of zero always one
        span[0]=1;
        // loop for ckeking element and put its index in stack and fill the span array 
        for (int i = 1; i < Stock.length; i++) {
            int currentPrize = Stock[i];
            while (!s.isEmpty() && currentPrize > Stock[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }else{
                int prevHigh= s.peek();
                span[i]=i-prevHigh;
            }

            s.push(i);
        }
    }
    // 1)we crete stack for adding index of element in it
    // 2)we want next greater in it so we iterate from last 
    // 3)now checking (stack is empty or not) and (ith element of array is greter than the arrayth stack top index) and pop till it
    // 4) if empty do -1;
    // 5) else next greater element is  arrayth stack top index
    // 6) push element in stack
    public static void nextGreater() {
        int arr[]={2,5,7,34,1,9};
        Stack<Integer> s1= new Stack<>();
        int nxtgret[]= new int[arr.length];

        for (int i = arr.length-1; i >= 0 ; i--) {
            while (!s1.isEmpty() && arr[i] >= arr[s1.peek()] ) {
                s1.pop();
            }
            if(s1.isEmpty()){
                nxtgret[i]=-1;
            }else{
                nxtgret[i]=arr[s1.peek()];
            }
            s1.push(i);

        }

        for (int i = 0; i < nxtgret.length; i++) {
            System.out.println(nxtgret[i]+ "");
        }
    }

    public static boolean validparenthesis(String str) {
        Stack<Character> s2 = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                s2.push(ch);
            }else{
                if(s2.isEmpty()){
                    return false;
                }

                if((s2.peek()=='{' && ch =='}') || (s2.peek()=='[' && ch == ']') || (s2.peek()=='('&& ch == ')')){
                    s2.pop();
                }else{
                    return false;
                }
            }


        }


        if(s2.isEmpty()){
            return true;
        }else{
            return false;
        }
    }


    // 1)first we push character in stack if " ) " till this is not come
    // 2)" ) " if this come initialize count = 0 after ,we pop element till we dont get " ( "
    // 3) if count < 1 return true;
    // 4) return false if condition is true;
    public static boolean ISduplicate(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);

            if(ch==')'){
                int count = 0;
                while ( s.pop() !='(') {
                    count++;
                }
                if(count<1){
                    return true;
                }
            }
            else{
                s.push(ch);
            }
        }
        return false;
    }

    // 1) 1st find next right smaller
    // 2) find left smaller
    // 3) height = ith index element
    // 4) width = right smaller index - left smaller index-1
    // 5) area = jeight * width
    // 6) maxarea then
    public static void maxarea(int[] arr) {
        int maxarea = 0;
        Stack<Integer> s= new Stack<>();
        int[] Rsmall= new int[arr.length];
        int[] Lsmall= new int[arr.length];

        // right small;
        for (int i = arr.length-1; i >= 0; i--) {
            int currentsmall = arr[i];
            while (!s.isEmpty() && currentsmall <= arr[s.peek()]) {
                s.pop();
            }

            if( s.isEmpty()){
                Rsmall[i]=arr.length;
            }else{
                Rsmall[i]=s.peek();
            }
            s.push(i);
        }

        //left small
        s= new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int currentsmall = arr[i];
            while (!s.isEmpty() && currentsmall <= arr[s.peek()]) {
                s.pop();
            }

            if( s.isEmpty()){
                Lsmall[i]=-1;
            }else{
                Lsmall[i]=s.peek();
            }
            s.push(i);
        }

        for (int i = 0; i < arr.length; i++) {
            int height = arr[i];
            int width=Rsmall[i]-Lsmall[i]-1;
            int area = height * width;
            maxarea=Math.max(area, maxarea);
        }
        System.out.println(maxarea);

    }
    public static void main(String[] args) {
        int Stock[]={100,80,60,70,60,85,100};
        int arr[]={2,1,5,6,2,3};
        int arr2[]={6,2,5,4,5,1,6};
        int arr1[]={2,4};
        // int span[]= new int[Stock.length];
        // calculatespan(Stock,span);

        // for (int i = 0; i < span.length; i++) {
        //     System.out.println(span[i] + "");
        // }
        // nextGreater();

        // String str = "(1221)";
        // System.out.println(validparenthesis(str));
        // System.out.println(ISduplicate(str));
        maxarea(arr2);

    }
}
