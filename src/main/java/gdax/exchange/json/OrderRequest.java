package gdax.exchange.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class OrderRequest {

   private String type;

   private OrderSide side;

   @JsonProperty("product_id")
   private String productId;

   private String price;

   private String size;

   public enum OrderSide {
      buy,
      sell
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public OrderSide getSide() {
      return side;
   }

   public void setSide(OrderSide side) {
      this.side = side;
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

}
