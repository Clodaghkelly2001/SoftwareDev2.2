import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab3_3 {

    public static void jumbleLetters(String word)
    {
        char [] c = word.toCharArray(); //declaring charachter c

        for (int i = 1; i < c.length - 1; i++) // this says for everytime integer i is = 1 and is es that the length of c -1, i increases
        {
            if (c.length >= 3) { // this states that if the length of c is greater that 3 it will swap the charachters
                int random = (int)((Math.random()*(c.length-2))+1); // math.random is a formula that randomises the charachters
                swap(c, i, random);
            }
            else // this else statement belongs to the if statement if the criteria isnt met for the if statement the words arent randomised and are left alone hence its empty
            {

            }
        }

        for(char ch: c) //for everytime ch is c it will print ch out
        {
            System.out.print(ch);
        }
        System.out.print(" "); // this prints out the spaces between the words when the programme is ran
    }

    public static void swap(char [] c, int i, int j) // this method allows us to swap the charachters
    {
        char temp = c[i]; //this means if the temporary charachter is equal to c of i
        c[i] = c[j]; //if c of i is equal to j
        c[j] = temp; // therefore c[j] is temp
    }

    public static void main(String[] args) throws FileNotFoundException {
        File f = new File( "text.txt"); //searching for the file


        Scanner sc = new Scanner(f); //scanner reads in the file
        String word = "";
        while (sc.hasNext()) // sc has next reads it word by word allowing it to jumble the words not the entire file compared to  sc.hasnext
        {
            word = sc.next().replaceAll("[^a-zA-Z ]", ""); // this replaces special charachters with nothing to allow for the jumble to work correctly for example '!' would become ''
            jumbleLetters(word); //print out the jumbled file
        }


    }

}
