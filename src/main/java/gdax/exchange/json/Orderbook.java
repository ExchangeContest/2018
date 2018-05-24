package gdax.exchange.json;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Orderbook {

   private BigDecimal sequence;
   private List<Entry> bids;
   private List<Entry> asks;

   public BigDecimal getSequence() {
      return sequence;
   }

   public void setSequence(BigDecimal sequence) {
      this.sequence = sequence;
   }

   public List<Entry> getBids() {
      return bids;
   }

   public void setBids(List<Entry> bids) {
      this.bids = bids;
   }

   public List<Entry> getAsks() {
      return asks;
   }

   public void setAsks(List<Entry> asks) {
      this.asks = asks;
   }

   @JsonIgnoreProperties(ignoreUnknown = true)
   @JsonFormat(shape = JsonFormat.Shape.ARRAY)
   @JsonPropertyOrder(value = { "price", "size", "numOrders" })
   public static class Entry {

      private String price;
      private String size;
      private String numOrders;

      public String getPrice() {
         return price;
      }

      public void setPrice(String price) {
         this.price = price;
      }

      public String getSize() {
         return size;
      }

      public void setSize(String size) {
         this.size = size;
      }

      public String getNumOrders() {
         return numOrders;
      }

      public void setNumOrders(String numOrders) {
         this.numOrders = numOrders;
      }

      @Override
      public String toString() {
         StringBuilder builder = new StringBuilder();
         builder.append("Entry [price=").append(price).append(", size=").append(size).append(", numOrders=")
               .append(numOrders).append("]");
         return builder.toString();
      }

   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Orderbook [sequence=").append(sequence).append(", bids=").append(bids).append(", asks=")
            .append(asks).append("]");
      return builder.toString();
   }

}
