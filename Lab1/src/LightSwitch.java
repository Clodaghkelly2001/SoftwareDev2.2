import java.util.Scanner;

public class LightSwitch {
    static boolean working = true;
    static boolean status = false;

    // this method is used to check whether a + or a - was entered.
    public static void checkInput(String input)
    {
        if(status && input.equals("-")){
            status = false;
            System.out.println("The light is off"); // this piece means that if - was inputted the boolean is set to false therefore it prints that the light is off
        }
        else if(!status && input.equals("+")){
            status = true;
            System.out.println("The light is on"); // this piece means that if - was inputted the boolean is set to true therefore it prints that the light is on

            int random = (int) (Math.random() * 20);
           // System.out.println(random);
            if (random > 10)
            {
                working = false;
            }
        }
    }

    // this is the main method where the programme takes in what the user has inpiuitted
    public static void main(String[] args) {
        int i = 0;
        System.out.println("Please enter a valid input of + or -"); // this asks the user to enter either + or _
        while (working)
        {
            Scanner sc = new Scanner(System.in); // this reads in the inputted value
            if(sc.hasNext())
            {
                String input = sc.next();
                if (input.equals("+") || input.equals("-")) // this if statement checks to see if + was inputted or _ from there it uses the code from above to print the appropriate response
                {
                    checkInput(input);
                }
                else
                {
                    System.out.println("please enter a valid input"); // this option is only printed out if a valid input was not entered
                }
            }
        }
        System.out.println("the bulb has blown");
    }
}
