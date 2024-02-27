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
	
    public static void main(String[] args) {
        String json = "[{\"id\":\"7733323852\",\"assigner_id\":null,\"assignee_id\":null,\"project_id\":\"2328947371\",\"section_id\":null,\"parent_id\":null,\"order\":1,\"content\":\"Create Project\",\"description\":\"\",\"is_completed\":false,\"labels\":[],\"priority\":1,\"comment_count\":0,\"creator_id\":\"48273109\",\"created_at\":\"2024-02-26T13:07:18.256886Z\",\"due\":null,\"url\":\"https://todoist.com/showTask?id=7733323852\",\"duration\":null},{\"id\":\"7734159693\",\"assigner_id\":null,\"assignee_id\":null,\"project_id\":\"2329294504\",\"section_id\":null,\"parent_id\":null,\"order\":1,\"content\":\"Created Task\",\"description\":\"\",\"is_completed\":false,\"labels\":[],\"priority\":1,\"comment_count\":0,\"creator_id\":\"48273109\",\"created_at\":\"2024-02-26T16:32:15.556146Z\",\"due\":null,\"url\":\"https://todoist.com/showTask?id=7734159693\",\"duration\":null}]";
        String key = "content";
         System.out.println(isTaskPresent(json, "content", "Created Task"));
        
    }
}