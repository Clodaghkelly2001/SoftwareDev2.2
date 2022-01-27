public class SortBook implements Comparable<SortBook>{
//declaring the variables
    private String bookTitle, bookPublisher, bookAuthor;
    private int bookPrice;

    public static int comparableSort = 1;

// Constructor with a parameter
    public SortBook(String bookTitle, String bookPublisher, String bookAuthor, int bookPrice )
    {
//invoking the method
        this.bookTitle = bookTitle;
        this.bookPublisher = bookPublisher;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
    }
//converting into a string
    public String toString()
    {
//printing out the values into a string
      return "Title: " + bookTitle + ", Publisher: " + bookPublisher + ", Author: " + bookAuthor+ ", Price: " +bookPrice+ "\n";
    }

    public void setSort(int i)
    {
        comparableSort = i;
    }
//this is the sort method
    public int compareTo(SortBook o) {
        if (comparableSort ==1)
        {
//calls on the book title and compares it to the string bookTitle to see if they are the same
// if they are they return it
            if (this.bookTitle.compareTo(o.bookTitle) < 0)
            {
                return 1;
            }
        }
//same as book title but this time compares the publisher
        else if (comparableSort == 2)
        {
            if (this.bookPublisher.compareTo(o.bookPublisher) < 0)
            {
                return 1;
            }
        }
//same as book title but this time compares the author
        else if (comparableSort == 3)
        {
            if (this.bookAuthor.compareTo(o.bookAuthor) < 0)
            {
                return 1;
            }
        }
        else
//same as book title but this time compares the price
        {
            if (this.bookPrice < o.bookPrice)
            {
                return 1;
            }
        }

        return 0;
    }
//swap method basically if i is equal to temp and j is equal to i then j is equal to temp
    public static void swap(SortBook [] a, int i, int j)
    {
        SortBook temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
//
    public static void sortingBook(SortBook [] input)
    {
//we set i to zero (i=0) then we set it that as long as it is less that the length of the array (i< input.length)  it will run (i++)
        for(int i = 0; i < input.length - 1; i++)
        {
            int Index = i;
//do the same for j
            for(int j = i+1; j < input.length; j++)
            {
                if(input[j].compareTo(input[Index]) == 1)
                {
                    Index = j;
                }
            }
//we then check if index is equal to i and if it isnt we swap it
            if (Index != i) {
                swap(input, i, Index);
            }
        }
//printing SortBook
        for(SortBook i : input)
        {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
//creating and filling in the values for books
        SortBook v = new SortBook("The Maze Runner", "Chicken Mouse","James Dashner", 12);
        SortBook b = new SortBook("Divergent", "Harper Collins","Veronica Roth", 13);
        SortBook d = new SortBook("Percy Jackson", "Penguin","Rick Riordan", 15);
        SortBook s = new SortBook("The Princess Diaries", "Macmillan","Meg Cabot", 8);
        SortBook e = new SortBook("Harry Potter", "Bloomsbury","J.K. Rowling", 20);

//calling the array
        SortBook [] pa = {v,b,d,s,e};
//setting the sort??
        v.setSort(2);
        b.setSort(2);
        d.setSort(2);
        s.setSort(2);
        e.setSort(2);
//calling the sort book method for pa
        sortingBook(pa);
    }
}

