import java.util.Scanner;

public class StringDetails {
    public static void getVowels(String s)
    {
        int numVowels = 0;
        s= s.toLowerCase(); // this allows for the input of uppercase and lowercase letters without this uppercase letters would not be recognized
        for (char c : s.toCharArray())
        {
            if ( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            {
                numVowels++; // this if statemeants means if there is a letter of either a,e,i,o,u it prints out how many of them were inputted
            }
        }
        System.out.println("num vowels is " + numVowels);
    }
        // prints out the word, first letter, last letter, number of vowels and the length of the word entered.
    public static void getStringDetails(String s)
    {
        System.out.println("the word entered is " + s); //this prints out the word entered under the variable s

        System.out.println("the length is " + s.length()); // s.length reads how many letters are in the word being entered

        getVowels(s);

        System.out.println(" the first letter is " + s.charAt(0)); // the zero is s.charSt reads the first letter in the word as each letter in a word starts with zero

        System.out.println(" the last letter is " + s.charAt(s.length()-1));
    }

    public static void main(String[] args) {
        {
            System.out.println("Enter a word"); // this prompts the user to enter a word
        }
        Scanner sc = new Scanner(System.in); // this reads in what you input
        {
            getStringDetails(sc.next());
        }
    }
}
