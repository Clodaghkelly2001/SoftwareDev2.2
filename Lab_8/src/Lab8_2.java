import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Lab8_2 extends JFrame implements ActionListener {

    private CanvasPanel canvas = new CanvasPanel();

    public Lab8_2()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400,400);
    }

    public void init()
    {
        this.add(canvas);
        this.setVisible(true);
    }


    class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener
    {

        Shape s = null;
        private boolean onPress1;
        private boolean onPress2;

        private Color [] colors = {Color.BLUE, Color.RED, Color.GREEN , Color.BLACK, Color.CYAN};
        private int colorTracker = 0;

        public CanvasPanel()
        {
            s = getRandomShape();
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }

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
        }

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(colors[colorTracker]);

            g2d.fill(s);

        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if(s.contains(e.getPoint())) {
                colorTracker = (colorTracker + 1) % colors.length;
                repaint();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
           s = getRandomShape(/*e.getX(), e.getY()*/);
            onPress1 = true;
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            onPress1 = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(onPress1 ) {

                double w = s.getBounds().getWidth();
                double h = s.getBounds().getHeight();
                double x = e.getX() - (w / 2);
                double y = e.getY() - (h / 2);
                //s = new Rectangle2D.Double(x, y, w, h);
                s = getRandomShape();

            }
                repaint();
            }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
    public static void main(String[] args) {
        new Lab8_2().init();
    }

}
