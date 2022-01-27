import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class CurrencyConverter  extends JFrame implements ActionListener, WindowListener, BaseCurrency {

    private int BaseCurrency;
    private Container contentPane = this.getContentPane();
    private JLabel cLabel = new JLabel("USD: "), fLabel = new JLabel("EUR: ");
    private JTextField cArea = new JTextField(10), fArea = new JTextField(10);
    private double cValue, fValue;

    public CurrencyConverter() {
        this.setSize(400, 100);
        this.setResizable(false);

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
        this.setTitle("Currency Converter");
    }

    public void init() {
        ;

        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.insets = new Insets(0, 1, 0, 1);

        gbc.gridx = 1;
        gbc.gridy = 1;

        contentPane.add(cLabel, gbc);

        gbc.gridx = 2;

        contentPane.add(fLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 1;
        gbc.gridy = 2;

        contentPane.add(cArea, gbc);

        gbc.gridx = 2;

        contentPane.add(fArea, gbc);

        cArea.addActionListener(this);

        fArea.addActionListener(this);

        this.setVisible(true);
    }

    public double CurrencyConverter(double d, char c ) {
        BaseCurrency = DEFAULT_CURRENCY;
        if( c == 'c')
        {
            double money = Math.abs(DEFAULT_CURRENCY/1.1336193);
            double round = Math.round(money*100.0)/100.0;
            return round;
        }
        else{
            double money = Math.abs(DEFAULT_CURRENCY/0.8823792);
            double roundusd = Math.round(money*100.0)/100.0;
            return roundusd;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == cArea)
        {
            cValue = Double.parseDouble(cArea.getText());
            fValue = CurrencyConverter(cValue, 'c');
        }
        else{
            fValue = Double.parseDouble(fArea.getText());
            cValue = CurrencyConverter(fValue, 'f');
        }

        cArea.setText(""+cValue);
        fArea.setText(""+fValue);

    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window starts");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // we can do something here


        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    public static void main(String[] args) {
        new CurrencyConverter().init();
    }

    @Override
    public int getCurrency() {
        return 0;
    }

    @Override
    public void setWCurrency(int i) {

    }
}