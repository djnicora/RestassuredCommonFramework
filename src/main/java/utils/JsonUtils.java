package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();
    public static Map<String, String> getJsonDataAsMap(String jsonFileName) throws IOException {
        String env = System.getProperty("env")==null ? "qa" : System.getProperty("env");

        String jsonFilePath = System.getProperty("user.dir") + "/src/test/resources/"+env+"/" + jsonFileName;
        Map<String, String> data = objectMapper.readValue(new File(jsonFilePath), new TypeReference<>() {
        });

        return data;
    }

}