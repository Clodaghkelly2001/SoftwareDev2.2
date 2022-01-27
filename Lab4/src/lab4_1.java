import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class lab4_1 {
    public static void main(String[] args) throws FileNotFoundException {
//locating the file
        File f = new File("/Users/cloda/IdeaProjects/Lab4/src/test.txt");
        try {
//scanner for the file
            Scanner sc = new Scanner(f);

            String words ="";
//if it has more than one line
            while(sc.hasNextLine())
//print it
                words = words + sc.nextLine();

            String [] split = words.split(" ");
//set i to zero and sets the lenght of the run to the length of the string so if i is less than the length of the string it increments
//the sets i to print every fifth word (i+5)
            for(int i = 0; i < split.length; i = i + 5)
            {
                System.out.println(split[i]);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
