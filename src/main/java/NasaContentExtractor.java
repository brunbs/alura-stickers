import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor{

    public List<Content> extractContent(String json) throws Exception {
        List<Map<String, String>> jsonAttributesList = JsonParser.parse(json);

        List<Content> contentList = new ArrayList<>();

        for (Map<String, String> attributes: jsonAttributesList) {
            String title = attributes.get("title");
            String urlImage = attributes.get("url");
            Content content = new Content(title, urlImage);
            contentList.add(content);
        }

        return contentList;

    }

}
