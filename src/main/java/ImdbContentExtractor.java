import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImdbContentExtractor implements ContentExtractor{

    public List<Content> extractContent(String json) throws Exception{
        List<Map<String, String>> jsonAttributesList = JsonParser.parse(json);

        List<Content> contentList = new ArrayList<>();

        for (Map<String, String> attributes: jsonAttributesList) {
            Content content = new Movie(attributes);
            contentList.add(content);
        }

        return contentList;
    }

}
