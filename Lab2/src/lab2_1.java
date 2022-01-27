public class lab2_1 {
    public static int findIndex(char [] a, char b) //method stating find index and declaring charachters named a and b

    {
        for (int i =0; i < a.length; i++) // this means for when (i) is equal to zero and (i) is less then the length of (a) (i) goes up

        {
            if(a[i] == b) // if ???

            {
                return i; // if the condition is correct return i
            }
        }

        return -1; // if not return -1
    }

    public static int[] findIndex(char [][] a, char b)

    {
        int [] returnInt = {-1,-1};

        for (int i = 0; i < a.length; i++) // this means for when (i) is equal to zero and (i) is less then the length of (a) (i) goes up

        {
            int rT = findIndex(a[i], b); //declaring rT and setting its value equal to findIndex of a(i) and 'b'

            if(rT != -1) // if the value of rT is not equal to one

            {
                returnInt[0] = i; // we return 'i', 'rT' and out integer returnInt
                returnInt[1] = rT;
                return returnInt;
            }

        }

        return returnInt; //otherwise just return returnInt
    }

    public static void main(String[] args) { // main method

        char [][] array = new char[5][0]; // creating the array with length 5

        array[0] = "lucky".toCharArray(); //inputting the word dog to our array


        int [] rT = findIndex(array, 'c'); // declaring int rT which will find the index of 'o' in our array dog starting at 0 and ending at 4


        System.out.println("the index of lucky is " + rT[0]+ ","+rT[1]); //prints out the location of 'o' in our array
    }
}


