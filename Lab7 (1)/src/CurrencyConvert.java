public class CurrencyConvert  implements BaseCurrency{

    // creating the double variable USD
    private double usd = 0.0;

    // Getter and Setter Function    @Override
    public double getUSD() {
        //this print out just the usd value
        return usd;
    }

    @Override
    public void setUsd(double value) {
        //this sets our value to usd dollars as USD is our base Currency
        usd = value;
    }

    @Override
    public void euroToUSD(double value) {
        //formula to convert euro to USD called upon in the main method
        usd = (double)Math.round((value * 1.14)*100)/100;
    }

    @Override
    public double usdToEuro() {
        //Formula to convert USD into Euro called upon in the main method
        return (double)Math.round((usd / 1.14)*100)/100;
    }

    //Main Method
    public static void main(String[] args) {
        CurrencyConvert money = new CurrencyConvert();

        //Setting the Euro value to one to convert into USD
        money.euroToUSD(1);

        System.out.println("The value in USD is: " + money.getUSD());

        //Setting the USD value to one to convert into euro
        money.setUsd(1);

        System.out.println("The value in Euro is: " + money.usdToEuro());

    }
}
