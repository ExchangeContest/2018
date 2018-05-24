package gdax.exchange.json;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

   private String id;
   private String currency;
   private BigDecimal balance;
   private BigDecimal available;
   private BigDecimal hold;
   @JsonProperty("profile_id")
   private String profileId;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public BigDecimal getBalance() {
      return balance;
   }

   public void setBalance(BigDecimal balance) {
      this.balance = balance;
   }

   public BigDecimal getHold() {
      return hold;
   }

   public void setHold(BigDecimal hold) {
      this.hold = hold;
   }

   public BigDecimal getAvailable() {
      return available;
   }

   public void setAvailable(BigDecimal available) {
      this.available = available;
   }

   public String getCurrency() {
      return currency;
   }

   public void setCurrency(String currency) {
      this.currency = currency;
   }

   public String getProfileId() {
      return profileId;
   }

   public void setProfileId(String profileId) {
      this.profileId = profileId;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Account [id=").append(id).append(", currency=").append(currency).append(", balance=")
            .append(balance).append(", available=").append(available).append(", hold=").append(hold)
            .append(", profile_id=").append(profileId).append("]");
      return builder.toString();
   }

}