package gdax.exchange;

import gdax.exchange.http.client.Client;
import gdax.exchange.json.Account;
import gdax.exchange.json.Order;
import gdax.exchange.json.OrderRequest;
import gdax.exchange.json.OrderRequest.OrderSide;
import gdax.exchange.json.Orderbook;
import gdax.exchange.json.Ticker;
import gdax.exchange.json.Time;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpMethod;

/**
 * Exchange API.
 */
public class Exchange {

   private final Client client;

   public Exchange(Client client) {
      this.client = client;
   }

   public void init() {
      Time time = getTime();
      client.setServerTime(time.getEpoch().longValue());
   }

   public Time getTime() {
      return client.http("/time", HttpMethod.GET, Time.class);
   }

   public List<Account> getAccounts() {
      return asList(client.http("/accounts", HttpMethod.GET, Account[].class));
   }

   public Order createOrder(OrderSide side, String productId, String size, String price) {
      OrderRequest order = new OrderRequest();
      order.setSide(side);
      order.setProductId(productId);
      order.setSize(size);
      order.setPrice(price);
      order.setType("limit");

      return createOrder(order);
   }

   public Order createOrder(OrderRequest order) {
      return client.http("/orders", HttpMethod.POST, order, Order.class);
   }

   public Order getOrder(String id) {
      return client.http("/orders/" + id, HttpMethod.GET, Order.class);
   }

   public void cancelOrder(String id) {
      client.http("/orders/" + id, HttpMethod.DELETE, String.class);
   }

   public List<Order> getOrders() {
      return asList(client.http("/orders?status=all", HttpMethod.GET, Order[].class));
   }

   public Orderbook getOrderbook(String productId) {
      return client.http("/products/" + productId + "/book?level=2", HttpMethod.GET, Orderbook.class);
   }

   public Ticker getTicker(String productId) {
      return client.http("/products/" + productId + "/ticker", HttpMethod.GET, Ticker.class);
   }

   private static <T> List<T> asList(T[] t) {
      if (t == null || t.length == 0) {
         return Collections.emptyList();
      }
      return Arrays.asList(t);
   }

}
