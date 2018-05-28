package exchange.json;

import java.math.BigDecimal;

public class Rate {

    private String baseCurrency;
    private String quoteCurrency;
    private BigDecimal buyRate;
    private BigDecimal sellRate;

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getQuoteCurrency() {
        return quoteCurrency;
    }

    public void setQuoteCurrency(String quoteCurrency) {
        this.quoteCurrency = quoteCurrency;
    }

    public BigDecimal getBuyRate() {
        return buyRate;
    }

    public void setBuyRate(BigDecimal buyRate) {
        this.buyRate = buyRate;
    }

    public BigDecimal getSellRate() {
        return sellRate;
    }

    public void setSellRate(BigDecimal sellRate) {
        this.sellRate = sellRate;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Rate [baseCurrency=").append(baseCurrency).append(", quoteCurrency=").append(quoteCurrency)
                .append(", buyRate=").append(buyRate).append(", sellRate=").append(sellRate).append("]");
        return builder.toString();
    }

}
