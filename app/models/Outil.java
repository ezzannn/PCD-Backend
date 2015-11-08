package models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

import java.util.Map;

public  class Outil {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String map(Map<String, String[]> map) {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = (entry.getValue())[0];
            str.append(key);
            str.append("=");
            str.append(value);
            str.append("&");
        }
        return str.toString();
    }
    public static JsonNode writeObject(Object... objets){
        JsonNode rootNode = mapper.createObjectNode();
        for ( int i = 0; i < objets.length; i++ ) {
            JsonNode json = Json.toJson(objets[i]);
            ((ObjectNode) rootNode).put("object"+i, json);
        }
        return rootNode;
    }
}