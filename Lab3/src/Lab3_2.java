import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab3_2 {

    public static int countingWords(String words)
    {
        return words.split(" ").length;
    }

    public static int countVowels (String words)
    {
        int count = 0; // declaring the int count and setting it to 0

        words = words.toLowerCase(); // this allows to read the vowel whether its uppercase and lowercase.

        for (char c : words.toCharArray()) // this puts the word in an array??
        {
            if (c =='a' || c =='e' || c =='i' || c =='o' || c =='u') { //declaring the vowels
                count++; // count ++ means for any vowel count the vowel count will go up by one
            }
        }
        return count; //returns the count
    }

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File( "/Users/cloda/IdeaProjects/Lab3/src/text.txt"); //address for the file

        Scanner sc = new Scanner(f); // reads in the file
        String words = "";
        while (sc.hasNextLine())
        {
            words = words +sc.nextLine();
        }

        int wordCount = countingWords(words); //this is the word count method it counts the number of the words in the file
        int vowelCount = countVowels(words); //this is the vowel count method it counts the number of the vowels in the file

        System.out.println("vowel count is: " + vowelCount); //outputs the number of vowels
        System.out.println("vowels per word count is: " + (double)vowelCount/(double)wordCount); //outputs the average of vowels per word by diving number of vowels by the number of words

    }

}
