import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes

        String url = "https://api.mocki.io/v2/549a5d8b";
        HttpClient client = HttpClient.newHttpClient();
        URI address = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        // extrair só os dados que interessam(título, poster, classificação)
        List<Map<String, String>> moviesList = JsonParser.parse(body);

        // exibir e manipular os dados

        moviesList.forEach(movie -> {
            Movie movie2 = new Movie(movie);
            movie2.printMovie();
        });


    }

}
