import java.util.Scanner;

/**
 * Loop
 */
public class Loop {

    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     // System.out.println("Enter Number : " );
    //     // int n =sc.nextInt();
    //     // while ( !(n  % 10 == 0) ){
    //     //     System.out.println("Enter Number : " );
    //     //      n =sc.nextInt();

    //     System.out.println("Enter Number : " );
    //      int n =sc.nextInt();
    //      int cnt=0;
    //     do {

    //         System.out.println("Enter Number : " );
    //          int no =sc.nextInt();
    //          if (no % 10==0){
    //             continue;
    //          }
    //          System.out.println(no);
    //          cnt ++ ;
    //     } while(cnt <= n);

    //     }

    // public  void main(String args[]) {
    //     System.out.println(" Main Method");
    // }
    // public static void main(int[] args){
    //     System.out.println("Overloaded Integer array Main Method");
    // }
    // public static void main(char[] args){
    //     System.out.println("Overloaded Character array Main Method");
    // }
    // public static void main(double[] args){
    //     System.out.println("Overloaded Double array Main Method");
    // }
    // public static void main(float args){
    //     System.out.println("Overloaded float Main Method");
    // }


    public class First_C {  
        public void myMethod()   
      {  
      System.out.println("Method");  
      }  
        
      {  
      System.out.println(" Instance Block");  
      }  
            
      public void First_C()  
      {  
      System.out.println("Constructor ");  
      }  
      static {  
          System.out.println("static block");  
      }  
      public static void main(String[] args) {  
      First_C c = new First_C();  
      c.First_C();  
      c.myMethod();  
    }  
  }  
}
