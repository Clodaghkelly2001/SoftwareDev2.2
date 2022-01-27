public class Box{

    //declaring variables
    private String boxName;
    private int w,h,d;
    private boolean full = false;

    public Box() //this is the method for the box, it declares the box as a cardboard box and also declares the dimensions of said box.
    {
        boxName = "Cardboard";
        w = 1;
        h = 2;
        d = 3;
    }

    public Box(String boxName, int w, int h, int d, boolean full)
    {
        this.boxName = boxName;
        this.full = full;
        this.w = w;
        this.h = h;
        this.d = d;
    }

    public int getArea() { return w*h*d;} // this calculates the volume of the box from the values given below
    public String toString()
    {
        return "Box name = " + boxName + " Box area is " + this.getArea() +
                " Box Status " + full; // this is a combinations of all the methods created and is used to print out the final answer when the programme is running.
    }

    // main method prints out the type of box, the volume of the cube and the status of the box.
    public static void main(String[] args) {
        Box b = new Box("plastic", 10, 10, 10, false);
        System.out.println(b);
    }
}
