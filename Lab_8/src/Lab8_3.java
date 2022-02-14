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
    private CanvasPanel newCanvas = new CanvasPanel();

    //creating buttons
    private JButton rectangle = new JButton("Rectangle");
    private JButton square = new JButton("Sqaure");
    private JButton circle = new JButton("Circle");
    private JButton colorGreen = new JButton("Green");
    private JButton colorRed = new JButton("Red");
    private JButton colorBlue = new JButton("Blue");


    public Lab8_3()
    {
        this.setTitle("Buttons to Draw Shape");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(450,500);
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
        rectangle.addActionListener(this);
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
        //setting canvas to true
        this.setVisible(true);
    }//end of init

    class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener
    {
        public CanvasPanel()
        {
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }

        private ArrayList<Shape> shapes = new ArrayList<>();

        @Override
        public void mouseClicked(MouseEvent e) {}

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == rectangle)
        {

        }

        if(e.getSource() == circle)
        {

        }

        if(e.getSource() == square)
        {

        }

        if(e.getSource() == colorRed)
        {

        }

        if(e.getSource() == colorBlue)
        {

        }

        if(e.getSource() == colorGreen)
        {

        }

    }
}//end of lab8_3 class