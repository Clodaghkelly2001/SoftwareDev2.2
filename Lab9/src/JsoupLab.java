import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupLab extends JFrame implements ActionListener, WindowListener {

    //creating our double value
    private double usd = 0.0;
    private Container contentPane = this.getContentPane();

    //creating our labels
    private JLabel cLabel = new JLabel("USD: "), fLabel = new JLabel("EUR: "),
            gLabel = new JLabel("Yuan"), hLabel = new JLabel("GBP");

    //creating our text fields
    private JTextField cArea = new JTextField(10), fArea = new JTextField(10), gArea = new JTextField(10), hArea = new JTextField(10);
    private Double cValue, fValue, gValue, hValue;

    //setting up the gui
    public JsoupLab() {
        this.setSize(500, 100);
        this.setResizable(false);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addWindowListener(this);
        this.setTitle("Currency Converter");
    }

    //when the gui is started
    public void init() {

        //more setting up of the gui aka layouts
        contentPane.setLayout(new GridBagLayout());

        //we use a gridbag layout
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.insets = new Insets(0, 1, 0, 1);

        gbc.gridx = 1;
        gbc.gridy = 1;

        //setting up the labels so setting the x values in increments of one so they appear side by side
        contentPane.add(cLabel, gbc);

        gbc.gridx = 2;

        contentPane.add(fLabel, gbc);

        gbc.gridx = 3;

        contentPane.add(gLabel, gbc);

        gbc.gridx = 4;

        contentPane.add(hLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 1;
        gbc.gridy = 2;

        //setting up the text boxes so setting the x values in increments of one so they appear side by side
        contentPane.add(cArea, gbc);

        gbc.gridx = 2;

        contentPane.add(fArea, gbc);
        gbc.gridx = 3;

        contentPane.add(gArea, gbc);
        gbc.gridx = 4;

        contentPane.add(hArea, gbc);

        //to recieve any inputs in the text field
        cArea.addActionListener(this);

        fArea.addActionListener(this);

        gArea.addActionListener(this);

        hArea.addActionListener(this);

        //setting the text boxes and labels to be visible
        this.setVisible(true);
    }

    //when a value is entered into the text box....
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    //main method to call upon the initiliase
    public static void main(String[] args) {
        new JsoupLab().init();
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window Opens");
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}
