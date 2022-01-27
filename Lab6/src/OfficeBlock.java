public class OfficeBlock extends Building implements Cubicles{
    //calls on cubicles and walls
    private int Cubicles;
    private int Walls;

//settingOfficeBlock to the default number of Cubicles we set it to in the interface
    public OfficeBlock(){
        Cubicles = DEFAULT_NUM_CUBICLES;
        Walls = DEFAULT_NUM_WALLS;
    }

//allows us to call on the sub-class from the parent class
    @Override
//gets Cubicles from the sub-class
    public int getCubicles() {
        return this.Cubicles;}

    @Override
//sets the Cubicles from the sub-class
    public void setCubicles(int i) {}

    @Override
//calls walls from the class walls in through building and multiplying it with the number of cubicles we set in the cubicles interface to get the number of walls
    public int getWalls() {
        return (this.Walls * this.Cubicles);
    }

    @Override
//sets the walls from the Walls interface
    public void setWalls(int i) {}

    public static void main(String[] args) {
//creating new office
        OfficeBlock off = new OfficeBlock();
//printing out the cubicles and walls
        System.out.println("This office has " + off.getCubicles() + " Units and " + off.getWalls() + " Walls");
    }
}

