import java.util.Scanner;

public class Function {
    public static void main(String[] args) {
    average();
    }
    public static void average(){
        Scanner sc= new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        int c= sc.nextInt();

        float average = (a+b+c)/3;
        System.out.println(average);
    }
}
