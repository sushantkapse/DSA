/**
 * Bi_to_dec
 */
public class Bi_to_dec {

    public static void dec(int n){
        int power = 0;
        int decimal = 0;
        while (n > 0) {
            int rem = n % 10;
            n = n/10;
            decimal = decimal + (rem * (int)Math.pow(2, power));
            power ++ ;
        }
        System.out.println(decimal);
    }

    public static void xy(int n){
        int pow = 0;
        int binNum = 0; 
        while (n>0) {
            int rem = n % 2;
            binNum = binNum + (rem * (int)Math.pow(10, pow));
            pow ++ ;
            n = n/2;
        }
        System.out.println(binNum);
    }
    
    
    public static void Binary(int n){
        // int MyNum = n;
        int pow = 0;
        int binNum = 0;
        while (n>0) {
            int rem = n % 2;
            binNum = binNum + (rem * (int)Math.pow(10, pow));
            pow ++;
            n = n/2;
        }
        System.out.println(binNum);
    }
    public static void main(String[] args) {
        
        // Binary(15);
        // xy(15);
        dec(1111);
    }
}