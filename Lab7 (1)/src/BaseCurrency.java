public interface BaseCurrency {

    double getUSD();
    void setUsd(double value);

    void euroToUSD(double value);
    double usdToEuro();
}
