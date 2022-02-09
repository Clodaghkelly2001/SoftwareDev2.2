import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Lab8_2 extends JFrame implements ActionListener {

    private CanvasPanel canvas = new CanvasPanel();

    public Lab8_2()
    {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
    }

    public void init()
    {
        this.add(canvas);
        this.setVisible(true);
    }

    class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener
    {
        private boolean onPress = false;

        private Rectangle2D rect = new Rectangle2D.Double(10, 10, 50, 50);

        private Rectangle2D rectangle = new Rectangle2D.Double(10, 10, 100, 50);

        private Ellipse2D circle = new Ellipse2D.Double(10, 10, 50, 50);

        private Color [] colors = {Color.BLUE, Color.RED, Color.GREEN};

        private int trackColors = 0;

        Shape shapes = null;

        public CanvasPanel()
        {
            shapes = getRandomShape();
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
        }

        private Shape getRandomShape()
        {
            int random = (int)(Math.random()*3);
            System.out.println(random);

            if(random == 0) {
                return rect;
            }
            else if (random == 1)
            {
                return rectangle;
            }
            else
                return circle;
        }

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            Graphics2D graphic = (Graphics2D) g;

            graphic.setColor(colors[trackColors]);

            graphic.fill(shapes);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

            if(shapes.contains(e.getPoint())) {
                trackColors = (trackColors + 1) % colors.length;
                repaint();
            }

        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            shapes = getRandomShape();
            repaint();
            if(shapes.contains(e.getPoint()))
            {
                onPress = true;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            onPress = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e)
        {
            if(onPress) {
                double w = rect.getWidth();
                double h = rect.getHeight();
                double x = e.getX() - (w / 2);
                double y = e.getY() - (h / 2);

                rect = new Rectangle2D.Double(x, y, w, h);

                repaint();
            }
           else if(onPress) {
                double w = rectangle.getWidth();
                double h = rectangle.getHeight();
                double x = e.getX() - (w / 2);
                double y = e.getY() - (h / 2);

                rectangle = new Rectangle2D.Double(x, y, w, h);

                repaint();
            }
            else {
                double w = circle.getWidth();
                double h = circle.getHeight();
                double x = e.getX() - (w / 2);
                double y = e.getY() - (h / 2);

                circle = new Ellipse2D.Double(x, y, w, h);

                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    public static void main(String[] args) {
        new Lab8_2().init();
    }
}
