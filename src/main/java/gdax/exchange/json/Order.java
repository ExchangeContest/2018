package gdax.exchange.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

   private String id;
   @JsonProperty("product_id")
   private String productId;
   private String price;
   private String size;
   private String type;
   private String status;
   private String created_at;

   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   public String getProductId() {
      return productId;
   }

   public void setProductId(String productId) {
      this.productId = productId;
   }

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

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public String getCreated_at() {
      return created_at;
   }

   public void setCreated_at(String created_at) {
      this.created_at = created_at;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("Order [id=").append(id).append(", productId=").append(productId).append(", price=")
            .append(price).append(", size=").append(size).append(", type=").append(type).append(", status=")
            .append(status).append(", created_at=").append(created_at).append("]");
      return builder.toString();
   }

}
