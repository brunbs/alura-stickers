import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientHanlder {

    public static String getResponseBody(String url) {

        try {
            HttpClient client = HttpClient.newHttpClient();
            URI address = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder(address).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }


    }

}
