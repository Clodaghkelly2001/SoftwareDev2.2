public class House  extends Building implements Rooms {

    //calls on rooms and walls
    private int Rooms;
    private int Walls;

    //setting house to the default number of rooms we set it to in the interface
    public House() {
        Rooms = DEFAULT_NUM_ROOMS;
        Walls = DEFAULT_NUM_WALLS;
    }

    //allows us to call on the sub-class from the parent class
    @Override
//gets rooms from the sub-class
    public int getRooms() {return this.Rooms;}

    @Override
//sets the rooms from the sub-class
    public void setRooms(int i) {
    }

    @Override
//sets the walls from the Walls interface
    public void setWalls(int i) {}

    @Override
//calls walls from the class walls in through building and multiplying it with the number of rooms we set in the room interface to get the number of walls
    public int getWalls() {
        return (this.Walls * this.Rooms);
    }


    public static void main(String[] args) {
    //creating the house
        House h = new House();
//printing out how many walls there are
        System.out.println("This building has " + h.getWalls() + " walls" + "\n" + "and " + h.getRooms() + " rooms");
    }
}


