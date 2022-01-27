import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class lab4_2 {
    public static void Words(String input, int numFiles)throws IOException
    {
        String [] words = input.split( " ");
//creating the files
        File [] files = new File [numFiles];
        String [] fileContent = new String[numFiles];
//runs as long as its less than the length of the string
        for (int i =0; i< files.length; i++)
        {
//creates the files it will be saved into
            files[i] = new File ("TextFiles/" + "text" + i + ".txt");
            fileContent[i] = "";
        }
        for (int i = 0; i < words.length; i++)
        {
//divides the file into the number of files aka 5
            int mod = i % numFiles;
            fileContent[mod] = fileContent[mod] + " " + words[i];
        }
        for(int i = 0; i < files.length; i++)
        {
//writing them into the files
            System.out.println("Files Successfuly Split into 5 different files!");
            PrintWriter temp = new PrintWriter(files[i]);
            temp.print(fileContent[i]);
            temp.close();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
//locating the file
        File f = new File("/Users/cloda/IdeaProjects/Lab4/src/test.txt");
//reading the file
        try{
            Scanner sc = new Scanner(f);
            String words = "";
            while(sc.hasNextLine())
                words = words + sc.nextLine();
            Words(words, 5);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
