// links to the interface Roof and Walls
public class Building  implements Roof, Walls{

//calls on walls
    private int walls;

//setting walls to the default number of walls we set it to in the interface
    public Building(){
        walls = DEFAULT_NUM_WALLS;
    }

//allows us to call on the sub-class from the parent class
    @Override
//gets roof from the sub-class
    public int getRoof() {
        return 0;
    }

    @Override
//sets the roof from the sub-class
    public void setRoof(int i) {}

    @Override
//gets roof from the sub-class
    public int getWalls() {
        return this.walls;
    }

    @Override
//sets walls from the sub-class
    public void setWalls(int i) {}

    public static void main(String[] args) {
//creating the building
        Building b = new Building();
//printing out how many walls there are
        System.out.println("This building has " + b.getWalls() + " walls");
    }
}
