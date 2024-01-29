package air;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static String createUser(String id, String firstName, String lastName, String subjectId) {
        return "{\n" +
                "    \"id\": " + id + ",\n" +
                "    \"firstName\": \"" + firstName + "\",\n" +
                "    \"lastName\": \"" + lastName + "\",\n" +
                "    \"subjectId\": \"" + subjectId + "\"\n" +
                "  }";
    }

    public static Map<String, String> createUserMap(String id, String firstName, String lastName, String subjectId) {
        Map<String,String> payload = new HashMap<>();
        payload.put("id",id);
        payload.put("firstName",firstName);
        payload.put("lastName",lastName);
        payload.put("subjectId",subjectId);
        return payload;
    }

}
