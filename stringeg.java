public class stringeg {
    public static void main(String[] args) {
        String s = "ESSNWNSEW";
        String s1 = "ESSE";

        // pallindromecheck(s1);
        // shortestpath(s);
        String[] fruits = {"sushant","","aushanz","","a"};
        largeststring(fruits);
        
    }
    public static void pallindromecheck(String s ) {
        int n = s.length();
        boolean flag = true;
        for (int i = 0; i < n/2; i++) {
            if(s.charAt(i) != s.charAt(n-1-i)){
                flag = false;
            }
            
        }

        if(flag == true){
            System.out.println("String is Pallindrome");
        }
        else{
            System.out.println("String is not Pallindrome");
            
        }
    }
    public static void shortestpath(String s) {
        int x =0,y=0;

        for (int i = 0; i < s.length(); i++) {
            char dir = s.charAt(i);
            if (dir == 'E'){
                x++;
            }
            else if(dir == 'W'){
                x--;

            }
            else if(dir == 'N'){
                y++;

            }
            else{
                y--;
            }
        }
        int x1=x*x;
        int y1= y*y;
        float ans = (float)Math.sqrt(x1 + y1);
        System.out.println("Shortest Path is " + ans);
    }
    public static void largeststring(String[] s) {
        String largest = s[0];
        for (int i = 0; i < s.length; i++) {
            if (largest.compareToIgnoreCase(s[i]) < 0){
                largest = s[i]; 

            }

        }
        System.out.println("Largest is " + largest);
        
    }
}
