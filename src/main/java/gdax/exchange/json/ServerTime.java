package gdax.exchange.json;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerTime {

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
      return "ServerTime [iso=" + iso + ", epoch=" + epoch + "]";
   }

}
