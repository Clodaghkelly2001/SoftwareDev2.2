import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

public class Lab8_3 extends JFrame implements ActionListener {

    //creating panels
    private JPanel buttonPanel =  new JPanel();
    private CanvasPanel Canvas = new CanvasPanel();

    //creating buttons
    private JButton rectangle = new JButton("Rectangle");
    private JButton square = new JButton("Square");
    private JButton circle = new JButton("Circle");
    private JButton colorGreen = new JButton("Green");
    private JButton colorRed = new JButton("Red");
    private JButton colorBlue = new JButton("Blue");


    public Lab8_3()
    {
        //setting up the gui
        this.setTitle("Buttons to Draw Shape");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(600,600);

        //setting the colours of buttons and the background to make it look pretty
        colorRed.setBackground(Color.RED);
        colorBlue.setBackground(Color.CYAN);
        colorGreen.setBackground(Color.GREEN);
        rectangle.setBackground(Color.WHITE);
        circle.setBackground(Color.WHITE);
        square.setBackground(Color.WHITE);
        buttonPanel.setBackground(Color.DARK_GRAY);
        getContentPane().setBackground(Color.DARK_GRAY);

    }//end of lab8_3 method

    public void init()
    {
        //adding action listener to gui
        rectangle.addActionListener(new rectangleListener());
        square.addActionListener(this);
        circle.addActionListener(this);
        colorGreen.addActionListener(this);
        colorRed.addActionListener(this);
        colorBlue.addActionListener(this);

        //adding buttons to panel
       buttonPanel.add(rectangle);
        buttonPanel.add(square);
        buttonPanel.add(circle);
        buttonPanel.add(colorGreen);
        buttonPanel.add(colorRed);
        buttonPanel.add(colorBlue);

        //setting button panel visibility to true
        this.add(buttonPanel);

        this.add(Canvas);

        //setting canvas to true
        this.setVisible(true);

    }//end of init

    class rectangleListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            //return new Rectangle2D.Double(x, y, 50, 50);
        }
    }

    class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener
    {
        //setting up the canvas adding mouse listeners which will check for mouse press, mouse click, drag and release
        public CanvasPanel()
        {
            setPreferredSize(new Dimension(500,500));
            this.setBackground(Color.DARK_GRAY);
            this.addMouseMotionListener(this);
            this.addMouseListener(this);
        }

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
    }



    public static void main(String[] args) {
        new Lab8_3().init();
    }

    //method is called when an action is performed eg. if a button is clicked it is called here
    @Override
    public void actionPerformed(ActionEvent e) {
    }
}//end of lab8_3 class