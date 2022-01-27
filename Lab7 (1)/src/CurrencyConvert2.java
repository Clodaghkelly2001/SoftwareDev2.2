public class CurrencyConvert2 implements Currencies{
    //creating the variable usd
    private double usd = 0.0;

    //getter and setter functions
    @Override
    public double getUSD() {
        //this print out just the usd value
        return usd;
    }

    @Override

    public void setUSD(double value) {
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

    @Override
    public void gbpToUSD(double value) {
        //Formula to convert GBP into USD called upon in the main method
        usd = (double)Math.round((value * 1.36)*100)/100;
    }

    @Override
    public double usdToGBP() {
        //Formula to convert USD into GBP called upon in the main method
        return (double)Math.round((usd / 1.36)*100)/100;
    }


    @Override
    public void yuanToUSD(double value) {
        //Formula to convert yuan into USD called upon in the main method
        usd = (double)Math.round((value * 0.15)*100)/100;
    }

    @Override
    public double usdToYuan() {
        //Formula to convert USD into GBP called upon in the main method
        return (double)Math.round((usd / 0.15)*100)/100;
    }


    public static void main(String[] args) {
        CurrencyConvert2 m = new CurrencyConvert2();

        //Setting the Euro value to one to convert into USD
        m.euroToUSD(1);
        System.out.println("The value in USD is: " + m.getUSD());

        //Setting the GBP and Yuan value to one to convert into euro
        m.gbpToUSD(1);
        m.yuanToUSD(1);

        //setting usd to one so it will convert into yuan and gbp
        m.setUSD(1);

        System.out.println("The value in Euro is: " + m.usdToEuro());
        System.out.println("The value in Pounds is: " + m.usdToGBP());
        System.out.println("The value in Yuan is: " + m.usdToYuan());

    }
}
