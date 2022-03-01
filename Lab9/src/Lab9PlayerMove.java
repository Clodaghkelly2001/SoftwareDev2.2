import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Lab9PlayerMove extends JFrame implements KeyListener
{
    private CanvasPanel movementPlane = new CanvasPanel();
    private JLabel Instructions = new JLabel("Press 'W' to move up \n Press 'S' to move down \n Press 'A' to move left \n Press 'D' to move right");

    public Lab9PlayerMove()
    {
        setSize(750, 750);
        setTitle("W,A,S,D To Move");
        addKeyListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void init()
    {
        this.add(Instructions);
        this.add(movementPlane);
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
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == 68 ){
            movementPlane.moveRight();
        }
        else if(e.getKeyCode() == 65 )
        {
            movementPlane.moveLeft();
        }
        else if (e.getKeyCode() == 83)
        {
            //down
            movementPlane.moveDown();
        }
        else if(e.getKeyCode() == 87)
        {
            // up
            movementPlane.moveUp();

        }

        System.out.println(e.getKeyCode());
    }

    class CanvasPanel extends JPanel{

        private int xPos, yPos, xStep, yStep;


        public CanvasPanel()
        {
            xPos = 30;
            yPos = 20;
            xStep = 50;
            yStep = 25;

        }

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            drawShapes(g);
        }

        public void drawShapes(Graphics g)
        {
            Graphics2D g2d = (Graphics2D) g;

            g2d.setPaint(Color.red);

            RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

            g2d.setRenderingHints(rh);

            g2d.fillOval(xPos,yPos,50,50);

        }

        public void moveUp()
        {
            yPos = yPos - yStep;
            repaint();
        }

        public void moveDown()
        {
            yPos = yPos + yStep;
            repaint();
        }

        public void moveLeft()
        {
            xPos =  xPos - xStep;

            repaint();
        }

        public void moveRight()
        {
            xPos =  xPos + xStep;

            repaint();
        }


    }

    public static void main(String[] args) {
        new Lab9PlayerMove().init();
    }
}
