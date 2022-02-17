import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Lab8_2 extends JFrame implements ActionListener {
//creating our drawing panel
    private CanvasPanel canvas = new CanvasPanel();

//setting up our gui aka what happens when you hit close and the size of the window
    public Lab8_2()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,400);
    }


    //called when the programme is executed
    public void init()
    {
        //adding the canvas
        this.add(canvas);
        //setting visibility to true
        this.setVisible(true);
    }

    //canvas class where we will make the shape and colours
    class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener
    {

        //get the x and y axis of the shape
        Shape s = getRandomShape(getX(),getY());
        //mouseclick boolean
        private boolean onPress1;

        //array to do random colours
        private Color [] colors = {Color.BLUE, Color.RED, Color.GREEN , Color.BLACK, Color.CYAN};
        //color tracker which will be used later in the loop for the colours where each integer value is assigned to a specific colour
        private int colorTracker = 0;

        //creating the canvas panel
        public CanvasPanel()
        {
        //adding a mouse and a mouse motion listener to the panel
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }

        //method to get the shape
        private Shape getRandomShape(int x, int y)
        {
        //int random is what we used to make the shapes if it was one it was a rectangle, if its 2 its a square and if its 3 its a circle
            int random = (int)(Math.random()*3);
            System.out.println(random);
            if(random == 0) {
                return new Rectangle2D.Double(x, y, 50, 50);
            }
            else if (random == 1)
            {
                return new Rectangle2D.Double(x, y, 100, 50);
            }
            else
                return new Ellipse2D.Double(x, y, 50, 50);
        }

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            //making a graphics with name g2d
            Graphics2D g2d = (Graphics2D) g;

            //setting the colour of the shapes using the colour tracker as mentioned above
            g2d.setColor(colors[colorTracker]);

            //if shape s(random shape we generated) is not null we will the colour with the colour currently assigned to the colour tracker
            if(s != null)
            g2d.fill(s);

        }

        //to draw the shape and change its color
        @Override
        public void mouseClicked(MouseEvent e) {
            if (s.contains(e.getPoint())==false) {
                s = getRandomShape(e.getX(), e.getY());
                colorTracker = (colorTracker + 1) % colors.length;
                repaint();

            }

        }

        //to draw the shape and change its color
        @Override
        public void mousePressed(MouseEvent e) {
            if (s.contains(e.getPoint())) {
                //when the mouse is pressed the boolean we declared above is set to true
                onPress1 = true;
                //setting the colours
                colorTracker = (colorTracker + 1) % colors.length;
            }
            repaint();
        }

        //once the mouse is released the boolean we declared above is set to false
        @Override
        public void mouseReleased(MouseEvent e) {
            onPress1 = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mouseDragged(MouseEvent e) {

        //when on press is called we set the width, height, x and y is set relative to the shape being called
            if(onPress1 ) {

                double w = s.getBounds().getWidth();
                double h = s.getBounds().getHeight();
                double x = e.getX() - (w / 2);
                double y = e.getY() - (h / 2);
            }
                repaint();
            }

        @Override
        public void mouseMoved(MouseEvent e) {}
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    //run the gui
    public static void main(String[] args) {
        new Lab8_2().init();
    }

}
