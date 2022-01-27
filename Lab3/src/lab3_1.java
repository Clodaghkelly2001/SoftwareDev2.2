import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class lab3_1 {

    public static int countWords(String words)
    {
        return words.split(" ").length;
    }

    public static void main(String[] args) throws FileNotFoundException { // this is the main method the throws file not found means that if the file isnt
                                                                          // located it will provide an error stating it

        File f = new File("/Users/cloda/IdeaProjects/Lab3/src/text.txt"); //this locates the file

        Scanner sc = new Scanner(f); //the scanner reads the file f
        String words = "";
        while (sc.hasNextLine())
        {
            words = words +sc.nextLine();// causes the scanner to read the next line??
        }

        int wordCount = countWords(words); //word count is the in that will count the nu,ber of words in the file.

        System.out.println("word count is: " + wordCount); //this prints out the word count using method used to count the number of words.


    }

}
