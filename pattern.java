public class pattern {
    public static void main(String[] args) {
    //    halfpyramid(5);
    // character(5);
    // hollow_rect(5, 4);
    // inverted_pyramid(5, 5);
    // floyyds_triangle(5);
    // zero_one(5);
    // butterfly(5);
    // rhombus(10);
    // hollow_rhombus(5);
    // diamond(5);
    // pattern_pyramid(5);
    // pyramid_sk(5);
    pallindrome_puramid(5);
    }



    public static void pyramid_sk(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n-i ; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }
    public static void halfpyramid(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
                System.out.println();
            }
        }
    }
    public static void pattern_pyramid(int n) {
       
        int rowCount = 1;
        for (int i = n; i > 0; i--) {
            // Printing i spaces at the beginning of each row
            for (int j = 1; j <= i; j++) {
		    System.out.print(" ");
            }

            // Printing 'rowCount' value 'rowCount' times at the end of each row
            for (int j = 1; j <= rowCount; j++) {
	        	System.out.print(rowCount + " " );
            }
            System.out.println();

            // Incrementing the rowCount
            rowCount++;
        }
        
    }

    public static void pallindrome_puramid(int n) {
        for (int i=1; i<=n; i++){//outer forloop
            for (int j=1; j<=(n-i)*2; j++){
            System.out.print(" ");//create initial space for pyramid shape
            }
          for (int k=i; k>=1; k--){//inner for loops
            System.out.print(" "+k);//create left half            
          }                                        
          for (int l=2; l<=i; l++){
            System.out.print(" "+l);    //create right half
          }//end outer for loop                            
          System.out.println();
          }      
    }

    public static void character(int n){
        char ch= 'A';
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }
    public static void hollow_rect(int row,int column){
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if( i == 1 || i == row || j == column || j == 1){
                    System.out.print("*");
                }
                else{
                     System.out.print(" "); 
                }
                
            }
            System.out.println(); 
        }
    } 

    public static void inverted_pyramid( int row,int column){
       for (int i = 0; i < row; i++) {
            for (int j = 1; j <= row-i; j++) {
                System.out.print(j);
                
                
            }
            System.out.println();
       }
    }
    public static void floyyds_triangle(int n){
        int no=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(no+"  ");
                no ++;
            }
            System.out.println();
        }
}
public static void zero_one( int n){
    for (int i = 1; i <=n; i++) {
        for (int j = 1; j <=i; j++) {
            if((i+j)%2==0){
                System.out.print(1);
            }
            else{
                System.out.print(0);
            }
        }
        System.out.println();
        
    }
}
public static void butterfly( int n){
    for (int i = 1; i <=n; i++) {
        for (int j = 1; j <=i; j++) {

        System.out.print("*");    
        }
        for (int j = 1; j <=2*(n-i); j++) {
            System.out.print(" ");
        }
        for (int j = 1; j <=i ; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
    for (int i = n; i >= 1; i--) {
        for (int j = 1; j <=i; j++) {

            System.out.print("*");    
            }
            for (int j = 1; j <=2*(n-i); j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=i ; j++) {
                System.out.print("*");
            }
            System.out.println();
    }
}

public static void rhombus(int n){
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n-i; j++) {
            System.out.print(" ");
        }
        for (int j = n; j>= 1; j--) {
            System.out.print("*");
        }
        System.out.println();
    }
}
public static void hollow_rhombus(int n){
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n-i; j++) {
            System.out.print(" ");
        }
        for (int j = 1; j <=n; j++) {
            if (i == 1 || i == n || j ==1 || j==n)
            System.out.print("*");
            else{
                System.out.print(" ");
            }
        }
        System.out.println();
    }
    
}
public static void diamond(int n){
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n-i; j++) {
            System.out.print(" ");
        }
        for (int j = 1; j <= (2*i)-1; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
    for(int i = n;i >= 1;i--){
        for (int j = 1; j <= n-i; j++) {
            System.out.print(" ");
        }
        for (int j = 1; j <= (2*i)-1; j++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
}