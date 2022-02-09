import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class Lab8_1 extends JFrame implements ActionListener {

    private DrawingPanel drawArea = new DrawingPanel();

    private JButton drawButton = new JButton("Draw");
    private JButton reset = new JButton("Reset");

    private boolean draw = false;

    public Lab8_1()
    {
        this.setTitle("Connect the dots");
        this.setSize(500,500);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void init()
    {
        drawButton.addActionListener(this);

        this.add(drawButton, BorderLayout.NORTH);
        this.add(reset, BorderLayout.SOUTH);
        this.add(drawArea);
        this.setVisible(true);
    }

    class DrawingPanel extends JPanel implements MouseListener
    {

        private ArrayList<Point> point = new ArrayList<>();

        public DrawingPanel()
        {
            addMouseListener(this);
            this.setBackground(Color.LIGHT_GRAY);
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            if(draw)
            {
                for(int i = 0; i < point.size() -1; i++)
                {
                    g.drawLine(point.get(i).x, point.get(i).y, point.get(i+1).x, point.get(i+1).y);
                }

                g.drawLine(point.get(0).x, point.get(0).y, point.get(point.size()-1).x, point.get(point.size()-1).y);
            }

            for(Point p : point)
            {
                g.setColor(Color.GREEN);
                g.fillOval(p.x -5, p.y - 5, 10,10);
            }
        }

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

    class Point
    {
        int x,y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
         new Lab8_1().init();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        draw = true;
        drawArea.drawCalled();
    }
}
