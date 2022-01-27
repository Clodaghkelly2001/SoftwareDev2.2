public class Lab2_2 {

    public static int findIndex2d(char [] a, char b) { //method to find index of a 2d array
        for (int i = 0; i < a.length; i++) {

            if (a[i] == b) // if the value of a(i) is equal to b
            {
                return i; // it returns i
            }
        }
            for (int j = 0; j < a.length; j++) { // this means for when (j) is equal to zero and (j) is less then the length of (a) (j) goes up

                if (a[j] == b) // if the value of a(j) is equal to b
                {
                    return j ; // it returns j
                }
            }

        return -1;
    }

    public static int[] findIndex2d(char [][] a, char b)

    {
        int [] returnInt = {-1,-1};

        for (int i = 0; i < a.length; i++) { // this means for when (i) is equal to zero and (i) is less then the length of (a) (i) goes up

            int rT = findIndex2d(a[i], b);  //declaring rT and setting its value equal to findIndex of a(i) and 'b'

            if (rT != -1) {  // if the value of rT is not equal to one
                returnInt[0] = i;
                returnInt[1] = rT;
                return returnInt;  // we return 'i', 'rT' and out integer returnInt
            }
        }

            for (int j = 0; j < a.length; j++) { // this means for when (j) is equal to zero and (j) is less then the length of (a) (j) goes up

                int rD = findIndex2d(a[j], b);  //declaring rD and setting its value equal to findIndex of a(j) and 'b'

                if ( rD != -1) { // if the value of rD is not equal to one
                    returnInt[1] = j;
                    returnInt[0] = rD;
                    return returnInt;  // we return 'j', 'rD' and out integer returnInt
                }
            }

        return returnInt;
    }

    public static void main(String[] args) {

        char [][] array2d = new char[5][5]; //creating a 2d array with 5 rows and 5 columns

        array2d[2] = "dog".toCharArray(); //inputting the word dog into row 2 of the array
        array2d[3] = "cat".toCharArray(); //inputting the word cat into row 3 of the array


        int [] rT = findIndex2d(array2d, 'd'); //find the index of 'o' in dog
        int [] rD = findIndex2d(array2d, 't'); //find the index of 'a' in cat


        System.out.println("the index of dog is " + rT[0]+ ","+rT[1]); //prints out the position
        System.out.println("the index of cat is " + rD[0]+ ","+rD[1]);
    }

}



