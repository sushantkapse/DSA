public class rev1 {
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
      rev1 c = new rev1();  
      c.First_C();  
      c.myMethod();  
    }  
}
