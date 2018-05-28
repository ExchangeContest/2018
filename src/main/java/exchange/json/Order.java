package exchange.json;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    private String id;
    @JsonProperty("order")
    private Info info;
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Info {
        private String exchangeOrderType;
        private BigDecimal amount;
        private String baseCurrency;
        private String quoteCurrency;
        private BigDecimal rate;

        public String getExchangeOrderType() {
            return exchangeOrderType;
        }

        public void setExchangeOrderType(String exchangeOrderType) {
            this.exchangeOrderType = exchangeOrderType;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
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

        public BigDecimal getRate() {
            return rate;
        }

        public void setRate(BigDecimal rate) {
            this.rate = rate;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Order [exchangeOrderType=").append(exchangeOrderType).append(", amount=").append(amount)
                    .append(", baseCurrency=").append(baseCurrency).append(", quoteCurrency=").append(quoteCurrency)
                    .append(", rate=").append(rate).append("]");
            return builder.toString();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Order [id=").append(id).append(", info=").append(info)
                .append(", state=").append(state).append("]");
        return builder.toString();
    }

}
