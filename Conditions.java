import java.util.Scanner;

public class Conditions {
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Number : ");
    int a = sc.nextInt();
    // if (a>0){
    //     System.out.println("positive ");
    // }
    // else{
    //     System.out.println("negative");
    // }
    switch (a){
        case 1 : System.out.println("Monday");
                    break ;
        case 2 : System.out.println("Tuesday");
                    break;
        case 3 : System.out.println("Wednesday");
                    break;
        case 4 : System.out.println("Thirsday");
                    break;
        case 5 : System.out.println("Friday");
                    break;
        case 6 : System.out.println("SundYay");
                    break;
        default : 
            System.out.println("invalid");

    }
 }   
}
