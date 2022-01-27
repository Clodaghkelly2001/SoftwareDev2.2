import java.util.Scanner;
public class Book{
    //declaring the variables
    private String title, publisher, author;
    private int price;

// Constructor with a parameter
    public  Book(String title, String publisher, String author, int price )
    {
        this.title = (String)validate(title); // invoking the method??
        this.publisher = (String)validate(publisher);
        this.author = (String)validate(author);
        this.price = (int)validate(price);

    }

    public Object validate(Object o) // validate class
    {
// checks to see if there is a value in Price
        if(o.getClass() == Integer.class){
            if((int) o< 1){
                throw new IllegalArgumentException("Cannot Be Less than 1"); // this prints out if the int variable is empty
            }
        }
// checks to see if there is a value in the Strings AKA Title, Publisher, Author
        if (o.getClass() == String.class)
        {
            String s = (String)o;
            if(s.length() == 0)
                throw new IllegalArgumentException("String Cannot be Null"); // this prints out if the string is empty
        }
        return o;
    }
// this override function allows us to be able to print the name of the book
// without this function it just prints the memory address
    @Override

//converts it into a string
    public String toString()
    {
//prints book class and also uses \n to move onto the next line
        return
                "Title: " + this.title + "\n"+
                "Publisher: " + this.publisher + "\n" +
                "Author: " + this.author+ "\n" +
                "Price: " + this.price;
    }

    public static void main(String[] args) {
        Book v = new Book("The Maze Runner", "Chicken Mouse","James Dashner", 12);

        //prints the book
        System.out.println(v.toString());
    }

}
