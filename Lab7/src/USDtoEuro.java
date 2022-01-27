public class USDtoEuro implements BaseCurrency
{
    private double usd = 0.0;
    @Override
    public double getUSD() {
        return usd;
    }

    @Override
    public void setUSD(double value) {
        usd = value;
    }

    @Override
    public void euroToUSD(double value) {
        usd = (double) Math.round((value * 1.12853)*100)/100;
    }

    @Override
    public double usdToEuro() {
        return (double)Math.round((usd / 1.12853)*100)/100;
    }

    public static void main(String[] args) {
        USDtoEuro c = new USDtoEuro();

        c.euroToUSD(50);
        System.out.println("The value in USD is: $ " + c.getUSD());
        c.setUSD(1000);
        System.out.println("The value in Euro is: € " + c.usdToEuro());

    }
}
