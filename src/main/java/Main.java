import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes

        //String url = "https://api.mocki.io/v2/549a5d8b";
        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        String body = HttpClientHanlder.getResponseBody(url);

        // exibir e manipular os dados
        //ContentExtractor extractor = new ImdbContentExtractor();
        ContentExtractor extractor = new NasaContentExtractor();
        List<Content> contents = extractor.extractContent(body);

        contents.forEach(content -> {
            Content contentObject = new Content(content.getTitle(), content.getImageUrl());
            System.out.println(contentObject.getTitle());
            try {
                InputStream inputStream = new URL(contentObject.getImageUrl()).openStream();
                String fileName = contentObject.getTitle() + ".png";
                StickerFactory.generate(inputStream, fileName);
            } catch (Exception e) {
                System.out.println("Error while creating the Sticker");
            }

        });
    }



}
