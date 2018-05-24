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

      log.info("" + exchange.getOrders().size());

      log.info("Orderbook: " + exchange.getOrderbook(productId));
      log.info("Ticker " + exchange.getTicker(productId));

      //createOrders(exchange, productId);
   }

   public static void createOrders(Exchange exchange, String productId) {
      Order buy = exchange.createOrder(OrderSide.buy, productId, "0.0001", "7000");
      log.info("Created buy order: {}", buy);

      Order sell = exchange.createOrder(OrderSide.sell, productId, "0.0001", "8500");
      log.info("Created sell order: {}", sell);

      // Get all orders you submitted
      exchange.getOrders();

      // Check status on a order by id
      exchange.getOrder("");

      // Cancel a order which is pending
      exchange.cancelOrder("");
   }
}
