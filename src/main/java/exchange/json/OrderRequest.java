package exchange.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OrderRequest {

    private OrderSide exchangeOrderType;
    private String baseCurrency;
    private String quoteCurrency;
    private String amount;
    private String rate;

    public enum OrderSide {
        BUY,
        SELL
    }

    public OrderSide getExchangeOrderType() {
        return exchangeOrderType;
    }

    public void setExchangeOrderType(OrderSide exchangeOrderType) {
        this.exchangeOrderType = exchangeOrderType;
    }

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

}
