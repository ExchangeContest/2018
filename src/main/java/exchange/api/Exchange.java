package exchange.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpMethod;

import exchange.api.client.Client;
import exchange.json.Account;
import exchange.json.Order;
import exchange.json.OrderRequest;
import exchange.json.OrderRequest.OrderSide;
import exchange.json.Rate;

/**
 * Exchange API.
 */
public class Exchange {

    private final Client client;

    public Exchange(Client client) {
        this.client = client;
    }

    public List<Account> getAccounts() {
        return asList(client.http("/api/v1/accounts", HttpMethod.GET, Account[].class));
    }

    public Order createOrder(OrderSide side, Product product, String amount, String rate) {
        OrderRequest order = new OrderRequest();
        order.setBaseCurrency(product.getBaseCurrency());
        order.setQuoteCurrency(product.getQuoteCurrency());
        order.setExchangeOrderType(side);
        order.setAmount(amount);
        order.setRate(rate);

        return createOrder(order);
    }

    public Order createOrder(OrderRequest order) {
        return client.http("/api/v1/orders", HttpMethod.POST, order, Order.class);
    }

    public Order getOrder(String id) {
        return client.http("/api/v1/orders/" + id, HttpMethod.GET, Order.class);
    }

    public List<Rate> getRates() {
        return asList(client.http("/api/v1/rates", HttpMethod.GET, Rate[].class));
    }

    private static <T> List<T> asList(T[] t) {
        if (t == null || t.length == 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(t);
    }

}
