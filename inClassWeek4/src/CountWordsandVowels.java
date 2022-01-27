import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountWordsandVowels {

    public static int countWords(String words)
    {
        return words.split(" ").length;
    }

    public static int countVowels(String words) {

        int count = 0;

        words = words.toLowerCase();

        for (char c : words.toCharArray())
        {
            if (c =='a' || c =='e' || c =='i' || c =='o' || c =='u')
            {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("/Users/cloda/IdeaProjects/inClassWeek4/src/text.txt");

        Scanner sc = new Scanner(f);
        String words = "";
        while (sc.hasNextLine())
        {
            words = words +sc.nextLine();
        }

        int wordCount = countWords(words);
        int vowelCount = countVowels(words);

        System.out.println("word count is: " + wordCount);
        System.out.println("vowel count is: " + vowelCount);
        System.out.println("vowels per word count is: " + (double)vowelCount/(double)wordCount);

    }
}