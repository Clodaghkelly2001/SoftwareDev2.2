import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Lab8_3 extends JFrame implements ActionListener {

    private CanvasPanel newCanvas = new CanvasPanel();
    private JButton rectangle = new JButton("Rectangle");
    private JButton square = new JButton("Sqaure");
    private JButton circle = new JButton("Circle");
    private JButton colorGreen = new JButton("Green");
    private JButton colorRed = new JButton("Red");
    private JButton colorBlue = new JButton("Blue");


    public Lab8_3()
    {
        this.setTitle("Draw Shape");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.LINE_AXIS));
        this.setSize(450,500);
    }//end of lab8_3 method

    public void init()
    {
        this.add(newCanvas);
        this.add(rectangle);
        this.add(square);
        this.add(circle);
        this.add(colorRed);
        this.add(colorBlue);
        this.add(colorGreen);
        this.setVisible(true);
    }//end of init

    class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener
    {
        Shape newShapes = null;
        private boolean onPress;
        private Color [] colors = {Color.BLUE, Color.RED, Color.GREEN , Color.BLACK, Color.CYAN};
        private int colorTracker = 0;

        public CanvasPanel()
        {
            newShapes = getRandomShape();
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }//end of canvas panel

        private Shape getRandomShape()
        {
            int random = (int)(Math.random()*3);
            System.out.println(random);
            if(random == 0) {
                return new Rectangle2D.Double(10, 10, 50, 50);
            }
            else if (random == 1)
            {
                return new Rectangle2D.Double(10, 10, 100, 50);
            }
            else
                return new Ellipse2D.Double(10, 10, 50, 50);
        }//end of getRandomShape

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(colors[colorTracker]);

            g2d.fill(newShapes);

        }//end of paint component


        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mouseDragged(MouseEvent e) {}

        @Override
        public void mouseMoved(MouseEvent e) {}

    }//end of canvasPanel

    @Override
    public void actionPerformed(ActionEvent e) {
    }//end of action event e

    public static void main(String[] args) {
        new Lab8_3().init();
    }

}//end of lab8_3 class