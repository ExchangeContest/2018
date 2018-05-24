package gdax.exchange.http.client;

import java.text.SimpleDateFormat;
import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {

   private static final Logger log = LoggerFactory.getLogger(Client.class);

   private final String apiKey;
   private final String secret;
   private final String passphrase;
   private final String baseUrl;

   private final RestTemplate restTemplate = new RestTemplate();
   private final ObjectMapper mapper = new ObjectMapper();
   private long timeAdjustment = 0L;

   public Client(String apiKey, String secret, String passphrase, String baseUrl) {
      this.apiKey = apiKey;
      this.secret = secret;
      this.passphrase = passphrase;
      this.baseUrl = baseUrl;

      restTemplate.setErrorHandler(new HttpErrorHandler());
      // "2015-11-14T20:46:03.511254Z"
      mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS"));
   }

   public void setServerTime(long gdaxServerTime) {
      long currentTime = Instant.now().getEpochSecond();
      timeAdjustment = gdaxServerTime - currentTime;

      log.info("Server time: " + gdaxServerTime);
      log.info("Current system time: " + currentTime + ", going to apply adjustment of " + timeAdjustment
            + " seconds for timestamp headers.");
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
      HttpEntity<String> entity = createHttpEntity(method, path, body);

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

   private HttpEntity<String> createHttpEntity(HttpMethod method, String requestPath, String requestBody) {
      HttpHeaders headers = new HttpHeaders();
      headers.add("accept", "application/json");
      headers.add("content-type", "application/json");
      String timestamp = getTimestamp();
      String sig = Signature.generate(requestPath, method.name(), requestBody, timestamp, secret);
      headers.add("CB-ACCESS-KEY", apiKey);
      headers.add("CB-ACCESS-SIGN", sig);
      headers.add("CB-ACCESS-TIMESTAMP", timestamp);
      headers.add("CB-ACCESS-PASSPHRASE", passphrase);

      HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
      return entity;
   }

   private String getTimestamp() {
      Instant now = Instant.now();
      return String.valueOf(now.getEpochSecond() + timeAdjustment);
   }

}
