package gdax.exchange.json;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Time {

   private String iso;
   private BigDecimal epoch;

   public String getIso() {
      return iso;
   }

   public void setIso(String iso) {
      this.iso = iso;
   }

   public BigDecimal getEpoch() {
      return epoch;
   }

   public void setEpoch(BigDecimal epoch) {
      this.epoch = epoch;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Time [iso=").append(iso).append(", epoch=").append(epoch).append("]");
      return builder.toString();
   }

}
