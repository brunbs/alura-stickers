import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonParser {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static List<Map<String, String>> parse(String json) throws Exception{
        JsonNode jsonNode = objectMapper.readTree(json);
        if (jsonNode.toString().contains("items")) {
            List<Map<String, String>> moviesList = getMoviesList(jsonNode);
            return moviesList;
        }
        return objectMapper.readValue(json, new TypeReference<List<Map<String, String>>>() {});
    }

    private static List<Map<String, String>> getMoviesList(JsonNode json) throws Exception{
        return objectMapper.readValue(json.get("items").toString(), new TypeReference<List<Map<String, String>>>() {});
    }

}
