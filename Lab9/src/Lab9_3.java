import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Lab9_3 extends JFrame implements KeyListener {
    //creating canvas for the shapes
    private CanvasPanel playerPanel = new CanvasPanel();

    public Lab9_3()
    {
        //setting up the gui
        setSize(750, 750);
        setTitle("W,A,S,D To Move");
        addKeyListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //called when programme is ran
    public void init()
    {
        this.add(playerPanel);
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("key Pressed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("key Pressed");
    }

    @Override
    public void keyReleased(KeyEvent e)
    {}

    class CanvasPanel extends JPanel implements KeyListener{

        //canvas panel class
        private int xPos, yPos, xStep, yStep;
        //the shape of the player
        private Shape clodaghsFavouriteShape = new Ellipse2D.Double(xPos, yPos, 75,75);
        //creating shape arrayList
        private ArrayList<Shape> Shape = new ArrayList(5);
        private int currentShape = -1;

        public CanvasPanel()
        {
            xPos = 30;
            yPos = 20;
            xStep = 50;
            yStep = 25;
            addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
            //creating the shapes
            Shape.add(new Rectangle2D.Double(100,50,100,100));
            Shape.add(new Ellipse2D.Double(500,50,100,100));
            Shape.add(new Rectangle2D.Double( 300,300,100,100));
            Shape.add(new Ellipse2D.Double(100,550,100,100));
            Shape.add(new Rectangle2D.Double(500,550,100,100));

        }

        public boolean collision1()
        {
            //checking for the collision
            for(int i = 0; i < Shape.size(); i++)
            {
                if(clodaghsFavouriteShape.intersects(Shape.get(i).getBounds()))
                {
                    currentShape = i;
                    return clodaghsFavouriteShape.intersects(Shape.get(currentShape).getBounds());
                }
            }
            return false;
        }

        @Override
        public void paintComponent(Graphics g)
        {
            //setting the colour of the shape
            Graphics2D g2d = (Graphics2D) g;
            super.paintComponent(g);
            drawShapes(g);
            g2d.setColor(Color.cyan);
            for(int i =0; i < Shape.size(); i++)
            {
                g2d.fill(Shape.get(i));
            }

            //setting the colour of the player shape
            g2d.setColor(Color.GREEN);
            g2d.fill(clodaghsFavouriteShape);
            clodaghsFavouriteShape = new Ellipse2D.Double(xPos, yPos, 75,75);
        }

        //draws the shape
        public void drawShapes(Graphics g)
        {
            Graphics2D g2d = (Graphics2D) g;

            RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            g2d.setRenderingHints(rh);


        }

        //movement methods
        public void moveUp()
        {
            //move up
            yPos = yPos - yStep;
            repaint();
        }

        public void moveDown()
        {
            //move down
            yPos = yPos + yStep;
            repaint();
        }

        public void moveLeft()
        {

            //move left
            xPos =  xPos - xStep;

            repaint();
        }

        public void moveRight()
        {
            //move right
            xPos =  xPos + xStep;

            repaint();
        }

        public void RemoveShape()
        {
            Shape.remove(currentShape);
            if(Shape.size()==0)
            {
                System.exit(0);
            }
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        //to press the keys to move the shape
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == 68 ){
                //right
                playerPanel.moveRight();
            }
            else if(e.getKeyCode() == 65 )
            {
                //left
                playerPanel.moveLeft();
            }
            else if (e.getKeyCode() == 83)
            {
                //down
                playerPanel.moveDown();
            }
            else if(e.getKeyCode() == 87)
            {
                // up
                playerPanel.moveUp();

            }

            if(e.getKeyCode() == 32 && collision1())
            {
                RemoveShape();
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {


        }
    }

    //calling the gui
    public static void main(String[] args) {
        new Lab9_3().init();
    }
}


