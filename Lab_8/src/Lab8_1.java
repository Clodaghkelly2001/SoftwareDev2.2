import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class Lab8_1 extends JFrame implements ActionListener {

    //creating the drawing area
    private DrawingPanel drawArea = new DrawingPanel();

    //creating the draw button
    private JButton drawButton = new JButton("Draw");

    //draw boolean which is used to link the draw method to the draw button
    private boolean draw = false;

    public Lab8_1()
    {
        //setting up the gui
        this.setTitle("Connect the dots");
        this.setSize(500,500);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //the start method which is called when the programme is executed
    public void init()
    {
        //adding action listener to see if action is performed
        drawButton.addActionListener(this);

        //adding the buttons and the canvas to the gui and setting visibility to true
        this.add(drawButton, BorderLayout.NORTH);
        this.add(drawArea);
        this.setVisible(true);
    }

    //mouse listener registers mouse events aka clicking dragging releasing which is implemented in my drawing panel class
    class DrawingPanel extends JPanel implements MouseListener
    {

        //creating an array list to store the points
        private ArrayList<Point> point = new ArrayList<>();

        public DrawingPanel()
        {
            //adding the mouse listener to the canvas and setting the colour
            addMouseListener(this);
            this.setBackground(Color.LIGHT_GRAY);
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            //if draw is true
            if(draw)
            {
            //for loop to connect  the points
                for(int i = 0; i < point.size() -1; i++)
                {
                    g.drawLine(point.get(i).x, point.get(i).y, point.get(i+1).x, point.get(i+1).y);
                }

                g.drawLine(point.get(0).x, point.get(0).y, point.get(point.size()-1).x, point.get(point.size()-1).y);
            }
            //colour the points we place green
            for(Point p : point)
            {
                g.setColor(Color.GREEN);
                g.fillOval(p.x -5, p.y - 5, 10,10);
            }
        }
//when the draw button is clicked it connects the points to make a shape
        public void drawCalled()
        {
            repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        //on mouse release a point is added
        @Override
        public void mouseReleased(MouseEvent e)
        {
            point.add(new Point(e.getX(), e.getY()));
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    //class point to make the points which is called when mouse is released
    class Point
    {
        int x,y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    //to run the gui
    public static void main(String[] args) {
         new Lab8_1().init();
    }

    //calling the draw method through the drawing panel so when the draw button is pressed (action performed) draw is called and the
    //points are connected
    @Override
    public void actionPerformed(ActionEvent e)
    {
        draw = true;
        drawArea.drawCalled();
    }
}
