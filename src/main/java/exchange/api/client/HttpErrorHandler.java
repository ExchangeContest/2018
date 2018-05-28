package exchange.api.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

class HttpErrorHandler implements ResponseErrorHandler {

    private static final Logger log = LoggerFactory.getLogger(HttpErrorHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().value() >= 400;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        String result = new BufferedReader(new InputStreamReader(response.getBody())).lines()
                .parallel().collect(Collectors.joining("\n"));
        log.error("Error response: {}", result);
    }

}
