package exchange.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import exchange.api.Exchange;
import exchange.api.Product;
import exchange.api.client.Client;
import exchange.json.Order;
import exchange.json.OrderRequest.OrderSide;

public class Main {

    // Add your account ID
    private static final String PROFILE_ID = "";

    private static final String BASE_URL = "http://crypto-exchange-service-710742e151290ccd.elb.us-east-1.amazonaws.com/";

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        Client client = new Client(PROFILE_ID, BASE_URL);
        Exchange exchange = new Exchange(client);

        exchange.getAccounts().stream().forEach(a -> log.info("Account: {}", a));
        log.info("Rates: {}", exchange.getRates());

        createOrders(exchange);
    }

    public static void createOrders(Exchange exchange) {
        // Create a buy order for 0.01 BTC with rate 7000 EUR/BTC
        Order buy = exchange.createOrder(OrderSide.BUY, Product.BITCOIN, "0.01", "7000");
        log.info("Created buy order: {}", buy);

        // Create a sell order for 0.01 BTC with rate 8500 EUR/BTC
        Order sell = exchange.createOrder(OrderSide.SELL, Product.BITCOIN, "0.1", "8500");
        log.info("Created sell order: {}", sell);

        // Check status on a order by id
        log.info("Get status on order: {}", exchange.getOrder(sell.getId()));
    }
}
