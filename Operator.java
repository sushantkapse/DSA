/**
 * Operator
 */
public class Operator {

    public static void main(String[] args) {
        int x = 2, y = 5;
        int exp1 = (x * y / x);
        int exp2 = (x * (y / x));
        System.out.print(exp1 + ",");
        System.out.println(exp2);
        System.out.println(y/x);
    }
}