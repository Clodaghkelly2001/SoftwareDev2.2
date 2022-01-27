import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Q1
{

    public static void main(String[] args)throws FileNotFoundException
    {
        File f = new File("/Users/cloda/IdeaProjects/LabExam/src/dlr_tennis_clubs");

        Scanner sc = new Scanner(f);

        String words = "";

        while (sc.hasNextLine())
        {
            System.out.println(sc.nextLine());
        }

    }
}
