package gdax.client.main;

import gdax.exchange.Exchange;
import gdax.exchange.http.client.Client;
import gdax.exchange.json.Order;
import gdax.exchange.json.OrderRequest.OrderSide;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

   // Add your key, secret and passphrase
   private static final String API_KEY = "";
   private static final String SECRET = "";
   private static final String PASSPHRASE = "";

   private static final String BASE_URL = "https://api-public.sandbox.gdax.com";

   private static final Logger log = LoggerFactory.getLogger(Main.class);

   public static void main(String[] args) throws Exception {
      Client client = new Client(API_KEY, SECRET, PASSPHRASE, BASE_URL);
      Exchange exchange = new Exchange(client);
      exchange.init();

      exchange.getAccounts().stream().forEach(a -> log.info("Account: {}", a));

      String productId = "BTC-EUR";

      // Orderbook contains all currently open bid/ask orders
      log.info("Orderbook: " + exchange.getOrderbook(productId));

      // Ticker contains last trade information with best bid, ask at the time
      // of trade
      log.info("Ticker " + exchange.getTicker(productId));

      // createOrders(exchange, productId);
   }

   public static void createOrders(Exchange exchange, String productId) {
      // Create a buy order for 0.01 BTC with rate 7000 EUR/BTC
      Order buy = exchange.createOrder(OrderSide.buy, productId, "0.01", "7000");
      log.info("Created buy order: {}", buy);

      // Create a sell order for 0.01 BTC with rate 8500 EUR/BTC
      Order sell = exchange.createOrder(OrderSide.sell, productId, "0.01", "8500");
      log.info("Created sell order: {}", sell);

      // Get all orders for your account
      exchange.getOrders();

      // Check status on a order by id
      exchange.getOrder("");

      // Cancel a order which is pending
      exchange.cancelOrder("");
   }
}
