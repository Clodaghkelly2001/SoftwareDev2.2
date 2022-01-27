public class ApartmentBlock extends Building implements Units {

    //calls on Units and walls
    private int Units;
    private int Walls;

    //setting ApartmentBlock to the default number of units we set it to in the interface
    public ApartmentBlock() {
        Units = DEFAULT_NUM_UNITS;
        Walls = DEFAULT_NUM_WALLS;
    }

    //allows us to call on the sub-class from the parent class
    @Override
//gets units from the sub-class
    public int getUnits() {
        return this.Units;
    }

    @Override
//sets the units from the sub-class
    public void setUnits(int i) {
    }

    @Override
//calls walls from the class walls in through building and multiplying it with the number of units we set in the units interface to get the number of walls
    public int getWalls() {
        return (this.Walls *  this.Units);
    }

    @Override
//sets the walls from the Walls interface
    public void setWalls(int i) {}

    public static void main(String[] args) {
//creating new apartment
        ApartmentBlock apart = new ApartmentBlock();
//Printing out the number of units and walls
        System.out.println("This apartment has " + apart.getUnits() + " Units and " + apart.getWalls() + " Walls");
    }
}

