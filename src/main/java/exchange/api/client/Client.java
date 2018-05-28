package exchange.api.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {

    private final String accountId;
    private final String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper mapper = new ObjectMapper();

    public Client(String accountId, String baseUrl) {
        this.accountId = accountId;
        this.baseUrl = baseUrl;

        restTemplate.setErrorHandler(new HttpErrorHandler());
    }

    public <T> T http(String path, HttpMethod method, Object body, Class<T> responseClass) {
        try {
            return http(path, method, mapper.writeValueAsString(body), responseClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> T http(String path, HttpMethod method, Class<T> responseClass) {
        return http(path, method, "", responseClass);
    }

    private <T> T http(String path, HttpMethod method, String body, Class<T> responseClass) {
        HttpEntity<String> entity = createHttpEntity(body);

        String response = restTemplate.exchange(baseUrl + path, method, entity, String.class).getBody();
        if (response == null || response.isEmpty()) {
            return null;
        }

        try {
            return mapper.readValue(response, responseClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private HttpEntity<String> createHttpEntity(String requestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", "application/json");
        headers.add("content-type", "application/json");
        headers.add("X-PROFILE-ID", accountId);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        return entity;
    }

}
