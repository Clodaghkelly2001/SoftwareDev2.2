import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Lab5_1
{
//reads in the file and converts into an array

    public static String [] toArray(String text) throws FileNotFoundException
    {
        File f = new File("/Users/cloda/IdeaProjects/Lab4/src/test.txt");
        Scanner sc = new Scanner(f);
        String str = "";

        while(sc.hasNextLine())
        {
            str += sc.nextLine();
        }

        return str.split(" ");
    }
//method to sort the words

    public static void sortArrayLetterSize(String [] str) throws FileNotFoundException
    {
        int words = words();

        for (int i = 1; i < words; i++)
        {
            String temp = str[i];
            int j = i-1;
            while(j >= 0 && temp.length() < str[j].length())
            {
                str[j+1] = str[j];
                j--;
            }
            str[j+1]= temp;
        }
    }

//this method puts it in order from first to last

    public static void sortArrayFOD(String [] s) throws FileNotFoundException
    {
        Arrays.sort(s);
    }

//this method calculates the word count

    public static int words() throws FileNotFoundException
    {
        File f = new File("/Users/cloda/IdeaProjects/Lab4/src/test.txt");
        Scanner sc = new Scanner(f);
        String str = "";

        while(sc.hasNextLine())
        {
            str += sc.nextLine();
        }

        String list[] = str.split(" ");
        int words = list.length;

        return words;

    }

    public static void main(String[] args) throws FileNotFoundException
    {
        String[] text;
        text = Lab5_1.toArray("text.txt");

//calls on the wordCount method to calculate the word count

        int Count = Lab5_1.words();

//calls on sorting method to sort in oder of size from smallest to largest

        Lab5_1.sortArrayLetterSize(text);

        for (int i = 0; i < Count; i++) {
            System.out.println(text[i]);
        }
        System.out.println("The word count is " + Count);
    }
}