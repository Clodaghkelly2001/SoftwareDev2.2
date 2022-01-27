import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Lab6_3 extends JFrame implements ActionListener, WindowListener {

//creating the buttons
    private JButton house = new JButton("house");
    private JButton apartment = new JButton("apartment");
    private JButton office = new JButton("office");
    private JButton reset = new JButton("reset");
    private JButton Roof = new JButton("roof");
    private JButton Rooms = new JButton("rooms");
    private JButton Units = new JButton("units");
    private JButton Cubicles = new JButton("cubicles");
    private JButton apartRoof = new JButton("roof");
    private JButton offRoof = new JButton("roof");


//the panel for the buttons
    private JPanel buttonPanel =  new JPanel();
    private JPanel housePanel =  new JPanel();
    private JPanel apartmentPanel =  new JPanel();
    private JPanel officePanel =  new JPanel();
    private JPanel resetPanel =  new JPanel();
    private JPanel RoofPanel =  new JPanel();
    private JPanel RoomsPanel =  new JPanel();
    private JPanel UnitsPanel =  new JPanel();
    private JPanel CubiclesPanel =  new JPanel();
    private JPanel apartRoofPanel =  new JPanel();
    private JPanel offRoofPanel =  new JPanel();

//labels for the buttons so it will display the buttons
    private JLabel houseLabel = new JLabel("You built a house");
    private JLabel apartmentLabel = new JLabel("You built an apartment");
    private JLabel officeLabel = new JLabel("You built an office");
    private JLabel resetLabel = new JLabel(" ");
    private JLabel RoofLabel = new JLabel("You built a roof");
    private JLabel RoomsLabel = new JLabel("You added a room");
    private JLabel UnitsLabel = new JLabel("You added a unit");
    private JLabel CubiclesLabel = new JLabel("You added a cubicle");
    private JLabel apartRoofLabel = new JLabel("You built a roof");
    private JLabel offRoofLabel = new JLabel("You built a roof");


    public Lab6_3()
    {
//setting the layout for the gui
        this.setSize(400,400);
        this.setTitle("Building ");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
    }

    public void init()
    {
//intialising the gui
        house.addActionListener(this);
        apartment.addActionListener(this);
        office.addActionListener(this);
        reset.addActionListener(this);
        Roof.addActionListener(this);
        Rooms.addActionListener(this);
        Units.addActionListener(this);
        Cubicles.addActionListener(this);
        apartRoof.addActionListener(this);
        offRoof.addActionListener(this);


//adding the buttons
        buttonPanel.add(house);
        buttonPanel.add(apartment);
        buttonPanel.add(office);
        buttonPanel.add(reset);
        buttonPanel.add(Rooms);
        buttonPanel.add(Roof);
        buttonPanel.add(Units);
        buttonPanel.add(Cubicles);
        buttonPanel.add(apartRoof);
        buttonPanel.add(offRoof);



        this.add(buttonPanel);

        housePanel.add(houseLabel);
        apartmentPanel.add(apartmentLabel);
        officePanel.add(officeLabel);
        resetPanel.add(resetLabel);
        RoofPanel.add(RoofLabel);
        RoomsPanel.add(RoomsLabel);
        UnitsPanel.add(UnitsLabel);
        CubiclesPanel.add(CubiclesLabel);
        apartRoofPanel.add(apartRoofLabel);
        offRoofPanel.add(offRoofLabel);


        this.add(housePanel);
        this.add(officePanel);
        this.add(apartmentPanel);
        this.add(resetPanel);
        this.add(RoofPanel);
        this.add(RoomsPanel);
        this.add(UnitsPanel);
        this.add(CubiclesPanel);
        this.add(apartRoofPanel);
        this.add(offRoofPanel);



//setting the visibility so the text wont appear unless the button is clicked
        housePanel.setVisible(false);
        apartmentPanel.setVisible(false);
        officePanel.setVisible(false);
        resetPanel.setVisible(false);
        RoofPanel.setVisible(false);
        RoomsPanel.setVisible(false);
        UnitsPanel.setVisible(false);
        CubiclesPanel.setVisible(false);
        apartRoofPanel.setVisible(false);
        offRoofPanel.setVisible(false);
        Roof.setVisible(false);
        Rooms.setVisible(false);
        Units.setVisible(false);
        Cubicles.setVisible(false);
        apartRoof.setVisible(false);
        offRoof.setVisible(false);


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//basically an on click function if a certain event is performed it will display the events below
//all this is done through setting the visibility. if you set the panel visibility to true it will display te text
//and if you set just for example Rooms.setVisible(true); to true it display the button
        if (e.getSource() == house) {
//if house is clicked it will display the text set for house
            housePanel.setVisible(true);
            apartmentPanel.setVisible(false);
            officePanel.setVisible(false);
            resetPanel.setVisible(false);
            RoomsPanel.setVisible(false);
            UnitsPanel.setVisible(false);
            CubiclesPanel.setVisible(false);
            offRoofPanel.setVisible(false);
            apartRoofPanel.setVisible(false);
            RoofPanel.setVisible(false);
            Roof.setVisible(true);
            Rooms.setVisible(true);
            Cubicles.setVisible(false);
            Units.setVisible(false);
            apartRoof.setVisible(false);
            offRoof.setVisible(false);
        }
//if you click on roof it will display you built a roof
        else if (e.getSource() == Roof){
            Roof.setVisible(true);
            Rooms.setVisible(true);
            Units.setVisible(false);
            Cubicles.setVisible(false);
            apartRoof.setVisible(false);
            offRoof.setVisible(false);
            RoofPanel.setVisible(true);
            offRoofPanel.setVisible(false);
            apartRoofPanel.setVisible(false);
            RoomsPanel.setVisible(false);
            UnitsPanel.setVisible(false);
            CubiclesPanel.setVisible(false);
        }
//if you click on rooms it will display you built a room
        else if (e.getSource() == Rooms){
            Roof.setVisible(true);
            Rooms.setVisible(true);
            Units.setVisible(false);
            Cubicles.setVisible(false);
            apartRoof.setVisible(false);
            offRoof.setVisible(false);
            RoofPanel.setVisible(false);
            offRoofPanel.setVisible(false);
            apartRoofPanel.setVisible(false);
            RoomsPanel.setVisible(true);
            UnitsPanel.setVisible(false);
            CubiclesPanel.setVisible(false);
        }

        else if(e.getSource() == apartment)
        {
//if apartment is clicked it will display the text set for apartment
            housePanel.setVisible(false);
            apartmentPanel.setVisible(true);
            officePanel.setVisible(false);
            resetPanel.setVisible(false);
            RoomsPanel.setVisible(false);
            UnitsPanel.setVisible(false);
            CubiclesPanel.setVisible(false);
            offRoofPanel.setVisible(false);
            apartRoofPanel.setVisible(false);
            RoofPanel.setVisible(false);
            Roof.setVisible(false);
            Rooms.setVisible(false);
            Cubicles.setVisible(false);
            Units.setVisible(true);
            apartRoof.setVisible(true);
            offRoof.setVisible(false);
        }
//if you click on roof it will display you built a roof
     else if (e.getSource() == apartRoof){
            Roof.setVisible(false);
            Rooms.setVisible(false);
            Units.setVisible(true);
            Cubicles.setVisible(false);
            apartRoof.setVisible(true);
            offRoof.setVisible(false);
            RoofPanel.setVisible(false);
            offRoofPanel.setVisible(false);
            apartRoofPanel.setVisible(true);
            RoomsPanel.setVisible(false);
            UnitsPanel.setVisible(false);
            CubiclesPanel.setVisible(false);
        }
//if you click on unit it will display you built a unit
        else if (e.getSource() == Units){
            Roof.setVisible(false);
            Rooms.setVisible(false);
            Units.setVisible(true);
            Cubicles.setVisible(false);
            apartRoof.setVisible(true);
            offRoof.setVisible(false);
            RoofPanel.setVisible(false);
            offRoofPanel.setVisible(false);
            apartRoofPanel.setVisible(false);
            RoomsPanel.setVisible(false);
            UnitsPanel.setVisible(true);
            CubiclesPanel.setVisible(false);
        }


        else if(e.getSource() == office)
        {
//if office is clicked it will display the text set for office
            housePanel.setVisible(false);
            apartmentPanel.setVisible(false);
            officePanel.setVisible(true);
            resetPanel.setVisible(false);
            RoomsPanel.setVisible(false);
            UnitsPanel.setVisible(false);
            CubiclesPanel.setVisible(false);
            offRoofPanel.setVisible(false);
            apartRoofPanel.setVisible(false);
            RoofPanel.setVisible(false);
            Roof.setVisible(false);
            Rooms.setVisible(false);
            Cubicles.setVisible(true);
            Units.setVisible(false);
            apartRoof.setVisible(false);
            offRoof.setVisible(true);
        }
//if you click on roof it will display you built a roof
       else if (e.getSource() == offRoof){
            Roof.setVisible(false);
            Rooms.setVisible(false);
            Units.setVisible(false);
            Cubicles.setVisible(true);
            apartRoof.setVisible(false);
            offRoof.setVisible(true);
            RoofPanel.setVisible(false);
            offRoofPanel.setVisible(true);
            apartRoofPanel.setVisible(false);
            RoomsPanel.setVisible(false);
            UnitsPanel.setVisible(false);
            CubiclesPanel.setVisible(false);
    }
//if you click on cubicles it will display you built a cubicle
        else if (e.getSource() == Cubicles){
            Roof.setVisible(false);
            Rooms.setVisible(false);
            Units.setVisible(false);
            Cubicles.setVisible(true);
            apartRoof.setVisible(false);
            offRoof.setVisible(true);
            RoofPanel.setVisible(false);
            offRoofPanel.setVisible(false);
            apartRoofPanel.setVisible(false);
            RoomsPanel.setVisible(false);
            UnitsPanel.setVisible(false);
            CubiclesPanel.setVisible(true);
    }

        else
        {
//if reset is clicked it will remove all text
            housePanel.setVisible(false);
            apartmentPanel.setVisible(false);
            officePanel.setVisible(false);
            resetPanel.setVisible(true);
            Roof.setVisible(false);
            Rooms.setVisible(false);
            Cubicles.setVisible(false);
            Units.setVisible(false);
            RoofPanel.setVisible(false);
            RoomsPanel.setVisible(false);
            UnitsPanel.setVisible(false);
            CubiclesPanel.setVisible(false);
            apartRoof.setVisible(false);
            offRoof.setVisible(false);

        }

    }
    @Override
    public void windowOpened(WindowEvent e) {
//let us know the programme is ran
        System.out.println("Window starts");
    }

    @Override
    public void windowClosing(WindowEvent e) {
//closes the gui
        System.exit(0);
    }
    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
//calling the method
    public static void main(String[] args) {
        new Lab6_3().init();
    }


}