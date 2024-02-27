package base;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	public static List<String> parseTasks(String json, String key) {
        List<String> values = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(json);

            for (JsonNode node : rootNode) {
                JsonNode valueNode = node.get(key);
                if (valueNode != null) {
                    values.add(valueNode.asText());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return values;
    }

	public static boolean isTaskPresent(String json, String key, String value) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(json);

            for (JsonNode node : rootNode) {
                JsonNode valueNode = node.get(key);
                if (valueNode != null && valueNode.asText().equals(value)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	
	public static String getIdByContent(String json, String contentValue) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(json);
			
			for (JsonNode node : rootNode) {
				JsonNode contentNode = node.get("content");
				if(contentNode != null && contentNode.asText().equals(contentValue)) {
					return node.get("id").asText();
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
    
}