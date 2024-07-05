public class Bit_Manipulation {
    public static void main(String[] args) {
        int n = 16;
        // System.out.println((char)(ch| ' ') );
    //   oddeven(5);
    //   getithbit(5, 0);
    // setith(n, 0);
    // clearith(n, 1);
    // clearibits(n, 2);
    // clearrange(n, 2, 4);
    // check2power(n, 4);
    // countsetbit(n);
    // check2power(n);
    // System.out.println(1<<0);
    // countsetbit(n);
    cnt(n);
    }
    public static void swap(int a,int b) {
        a=(a&b)|b;
        b=(a&b)|a;
    }
    public static void oddeven(int n) {
        if((n & 1) == 0){
            System.out.println("Even Number");
        }

        else{
            System.out.println("Odd Number");
        }
        
    }

    public static void getithbit(int n,int i) {
        int bitmsk= (1<<i);
       if ((n&bitmsk)==0) {
        System.out.println("Element is : 0");
       }
       else{
        System.out.println("Element is : 1");
       }

    }
    public static void setith(int n , int i) {
       System.out.println(n | (1 << i)); 
    }
    public static void clearith(int n, int i) {
       int bitmask = ~(1<<i);
       System.out.println("Value After clearing ith is : " + (n & bitmask)); 
    }
    public static void clearibits(int n, int i) {
        int bitmask = (~0)<<i;
        System.out.println("After Clearing " + i + " bits : " + (n & bitmask));
    }
    public static void clearrange(int n, int i, int j) {
        int a = (~0)<< (j+1);
        int b = (1<<i)-1;
        int bitmask = a | b;
        System.out.println("After clearing from "+ i +" to "+ j +" we get : "+ (n & bitmask));
    }
    public static void calculatepower(int n, int p) {
        // System.out.println(n);
        int ans = 1;
        while (p > 0) {
            
            if((p & 1)!=0){
                 ans = n * ans;
            }   
            n = n*n;
            p=(p>>1);
        }

        System.out.println(ans);
    }
    public static void countsetbit(int n) {
        int count=0;
        while (n>0) {
            
            if((n & 1)!=0){
                count ++;
            }
            n=n>>1;
        }
        System.out.println("count is : " +count);
    }
    public static void check2power(int n) {
        if((n & (n-1))==0){
            System.out.println(n + "is 2 power");
        }
        else{
            System.out.println("no 2 power");
        }
    }
    public static void swap_without_thirdvariable(int x, int y) {
        System.out.println("before swapping");
        System.out.println("x : " + x);
        System.out.println("y : " + y);
        x = x^y;
        y = x^y;
        x = x^y;
        System.out.println("after swapping");
        System.out.println("x : " + x);
        System.out.println("y : " + y);
       
        
    }
    public static void cnt(int n){
        int a;
        int ct = 0,i=0;
        while(n>0){
            a= n &(i<<i);
            if(a==1){
                ct ++;
            }
            i++;
        }
        System.out.println(ct);
    }
}
