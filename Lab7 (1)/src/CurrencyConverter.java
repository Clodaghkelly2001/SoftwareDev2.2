import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CurrencyConverter  extends JFrame implements ActionListener, WindowListener, Currencies {

    //creating our double value
    private double usd = 0.0;
    private Container contentPane = this.getContentPane();

    //creating our labels
    private JLabel cLabel = new JLabel("USD: "), fLabel = new JLabel("EUR: "),
            gLabel = new JLabel("Yuan"), hLabel = new JLabel("GBP");

    //creating our text fields
    private JTextField cArea = new JTextField(10), fArea = new JTextField(10), gArea = new JTextField(10), hArea = new JTextField(10);
    private double cValue, fValue, gValue, hValue;

    //setting up the gui
    public CurrencyConverter() {
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

//the conversions we will be using
    @Override
    //this print out just the usd value
    public double getUSD()
    {
        return usd;
    }

    @Override
    //this sets our value to usd dollars as USD is our base Currency
    public void setUSD(double value)
    {
        usd = value;
    }

    @Override
    //this is our first conversion so if a euro value is entered it will convert it into dollars
    public void euroToUSD(double value)
    {
        usd = (double)Math.round((value * 1.12)*100)/100;
    }

    @Override
    //this will convert dollars to euro
    public double usdToEuro()
    {
        return (double) Math.round((usd / 1.12)*100)/100;
    }

    @Override
    //this will convert usd pounds into dollars
    public void gbpToUSD(double value)
    {
        usd = (double)Math.round((value * 1.34)*100)/100;
    }

    @Override
    //this will convert usd to pounds
    public double usdToGBP()
    {
        return (double) Math.round((usd / 1.34)*100)/100;
    }


    @Override
    //this converts yuan to dollars
    public void yuanToUSD(double value)
    {
        //double to set two decimal places and math.round rounds it to the nearest decimal
        usd = (double)Math.round((value * 0.15)*100)/100;
    }

    @Override
    //this converts dollars to yuan
    public double usdToYuan()
    {
        return (double)Math.round((usd / 0.15)*100)/100;
    }



    //when a value is entered into the text box....
    @Override
    public void actionPerformed(ActionEvent e) {

        //this is if a value is entered in dollars
        if (e.getSource() ==  cArea)
        {
            //calls on the currency converter to set the usd and convert it into euro,yuan, and GBP
            cValue = Double.parseDouble(cArea.getText());
            setUSD(cValue);
        }

        //if a value is entered in euro
       else if (e.getSource() ==  fArea)
        {
            //parse means get value
            //calls on the currency converter method euro to usd and converts it into dollars which converts it into yuan and gbp
            fValue = Double.parseDouble(fArea.getText());
            euroToUSD(fValue);
        }

        //if a value is entered in yuan
        else if (e.getSource() ==  gArea)
        {
            //calls on the currency converter method yuan to usd and converts it into dollars which converts it into euro and gbp
            gValue = Double.parseDouble(gArea.getText());
            yuanToUSD(gValue);
        }

        //if a value is entered in GBP
        else if (e.getSource() ==  hArea)
        {
            //calls on the currency converter method gbp to usd and converts it into dollars which converts it into euro and yuan
            hValue = Double.parseDouble(hArea.getText());
            gbpToUSD(hValue);
        }
        //setting the values to the different methods we called upon above so that when the programme is ran they are linked and the conversions happen
       cValue = getUSD();
       fValue = usdToEuro();
       gValue = usdToYuan();
       hValue = usdToGBP();

       //printing out the answer
       cArea.setText(""+ cValue);
       fArea.setText(""+ fValue);
       gArea.setText(""+ gValue);
       hArea.setText(""+ hValue);

    }

//main method to call upon the initiliase
    public static void main(String[] args) {
        new CurrencyConverter().init();
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
