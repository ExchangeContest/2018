package exchange.api;

public enum Product {

    BITCOIN("BTC", "EUR"),
    LITECOIN("LTC", "EUR"),
    ETHERIUM("ETH", "EUR"),
    BITCOINCASH("BCH", "EUR");

    private final String baseCurrency;
    private final String quoteCurrency;

    private Product(String baseCurrency, String quoteCurrency) {
        this.baseCurrency = baseCurrency;
        this.quoteCurrency = quoteCurrency;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public String getQuoteCurrency() {
        return quoteCurrency;
    }

}
