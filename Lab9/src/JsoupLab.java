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

    private Container contentPane = this.getContentPane();

    //creating our labels
    private JLabel cLabel = new JLabel("USD: "), fLabel = new JLabel("EUR: "),
            gLabel = new JLabel("Yuan"), hLabel = new JLabel("GBP");

    //creating our text fields
    private JTextField cArea = new JTextField(10), fArea = new JTextField(10), gArea = new JTextField(10), hArea = new JTextField(10);
    private Double cValue, fValue, gValue, hValue;

    double USD = 0.0;
    double EUR = 0.0;
    double GBP = 0.0;
    double CNY = 0.0;

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
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == cArea)
        {
            cValue = Double.parseDouble(cArea.getText());
            USD = cValue;
            EUR = convert(cValue,"USD","EUR");
            CNY = convert(cValue,"USD","CNY");
            GBP = convert(cValue,"USD","GBP");
            cArea.setText(""+cValue);

        }

        else if(e.getSource() == fArea){
            fValue = Double.parseDouble(fArea.getText());
            EUR = fValue;
            GBP = convert(fValue,"EUR","GBP");
            CNY = convert(fValue,"EUR","CNY");
            USD = convert(fValue,"EUR","USD");
            fArea.setText(""+ fValue);
        }

        else if(e.getSource() == gArea){
            gValue = Double.parseDouble(gArea.getText());
            CNY = gValue;
            USD = convert(gValue,"CNY","USD");
            EUR = convert(gValue,"CNY","EUR");
            GBP = convert(gValue,"CNY","GBP");
            gArea.setText(""+gValue);
        }

        else if(e.getSource() == hArea){
            hValue = Double.parseDouble(hArea.getText());
            GBP = hValue;
            USD = convert(hValue,"GBP","USD");
            EUR =convert(hValue,"GBP","EUR");
            CNY = convert(hValue,"GBP","CNY");
            hArea.setText(""+ hValue);
        }

        cArea.setText(""+USD);
        fArea.setText(""+ EUR);
        gArea.setText(""+CNY);
        hArea.setText(""+ GBP);

    }

    public double convert(double amount, String originalCurrency, String newCurrency)
    {
        double returnValue = 00.0;
        try {

            Document doc = Jsoup.connect(String.format("https://www.xe.com/currencyconverter/convert/?Amount=%f&From=%s&To=%s", amount, originalCurrency, newCurrency)).get();

            Elements elements = doc.select("p");

            for (Element element : elements) {

                String classes = element.className();
                if(classes.contains("result__BigRate"))
                {
                    System.out.println(element.text());
                    returnValue = Double.parseDouble(element.text().substring(0, element.text().indexOf(".") + 3).replaceAll("," , ""));

                }
            }
        }


        catch(Exception e)
        {
            e.printStackTrace();
        }
        return returnValue;
    }

    //main method to initialize the gui
    public static void main(String[] args)
    {
        new JsoupLab().init();
    }

    @Override
    public void windowOpened(WindowEvent e)
    {
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
