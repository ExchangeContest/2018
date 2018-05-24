package gdax.exchange.http.client;

import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

class SignatureUtil {

   private SignatureUtil() {
   }

   private static Mac MAC;

   static {
      try {
         MAC = Mac.getInstance("HmacSHA256");
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   public static String generate(String requestPath, String method, String body, String timestamp, String secretKey) {
      try {
         String prehash = timestamp + method.toUpperCase() + requestPath + body;
         byte[] secretDecoded = Base64.getDecoder().decode(secretKey);
         SecretKeySpec keyspec = new SecretKeySpec(secretDecoded, MAC.getAlgorithm());
         Mac sha256 = (Mac) MAC.clone();
         sha256.init(keyspec);
         return Base64.getEncoder().encodeToString(sha256.doFinal(prehash.getBytes()));
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

}
