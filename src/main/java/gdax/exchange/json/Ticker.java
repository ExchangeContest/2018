package gdax.exchange.json;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ticker {

   @JsonProperty("trade_id")
   private Long tradeId;
   private String time;
   private BigDecimal price;
   private BigDecimal volume;
   private BigDecimal ask;
   private BigDecimal bid;
   private BigDecimal size;

   public Long getTradeId() {
      return tradeId;
   }

   public void setTradeId(Long tradeId) {
      this.tradeId = tradeId;
   }

   public String getTime() {
      return time;
   }

   public void setTime(String time) {
      this.time = time;
   }

   public BigDecimal getPrice() {
      return price;
   }

   public void setPrice(BigDecimal price) {
      this.price = price;
   }

   public BigDecimal getVolume() {
      return volume;
   }

   public void setVolume(BigDecimal volume) {
      this.volume = volume;
   }

   public BigDecimal getAsk() {
      return ask;
   }

   public void setAsk(BigDecimal ask) {
      this.ask = ask;
   }

   public BigDecimal getBid() {
      return bid;
   }

   public void setBid(BigDecimal bid) {
      this.bid = bid;
   }

   public BigDecimal getSize() {
      return size;
   }

   public void setSize(BigDecimal size) {
      this.size = size;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Ticker [tradeId=").append(tradeId).append(", time=").append(time).append(", price=")
            .append(price).append(", volume=").append(volume).append(", ask=").append(ask).append(", bid=").append(bid)
            .append(", size=").append(size).append("]");
      return builder.toString();
   }
}