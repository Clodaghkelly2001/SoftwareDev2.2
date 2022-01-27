public interface BaseCurrency {

    double getUSD();
    void setUSD(double value);

    void euroToUSD(double value);
    double usdToEuro();
}
