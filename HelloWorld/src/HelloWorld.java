import java.util.Scanner;

public class HelloWorld {

    public static void main(String[] args) {
        stringDetails();

    }
    public static void stringDetails()
    {

        System.out.println("Please Enter your name");

        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()){
            String yourName = sc.next();
            System.out.println(" your name is " + yourName);
            System.out.println(" the length of your name is " + yourName.length());
            System.out.println(" your name starts with " + yourName.charAt(0));
            System.out.println(" your name ends with " + yourName.charAt(yourName.length()-1));
            System.out.println("Your name ends with " + yourName.substring(1, yourName.length()-1));
        }
        else{
            System.out.println("you did not enter a name");
        }

    }
}
