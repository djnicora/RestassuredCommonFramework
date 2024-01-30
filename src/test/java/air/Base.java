package air;

import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class Base {


    public static Map<String, Object> dataFromJsonFile;


    static {
        System.out.println(System.getProperty("env") + " - Environment value");
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        String jsonFilePath = System.getProperty("user.dir") + "/src/test/resources/"+env+"/" + "AirAPIData.json";
        try {
            dataFromJsonFile = JsonUtils.getJsonDataAsMap(jsonFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
