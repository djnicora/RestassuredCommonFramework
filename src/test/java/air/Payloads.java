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

    public static Map<String, Object> createUserPayloadMap(String id, String firstName, String lastName, String subjectId) {
        Map<String,Object> payload = new HashMap<>();
        payload.put("id",id);
        payload.put("firstName",firstName);
        payload.put("lastName",lastName);
        payload.put("subjectId",subjectId);
        return payload;
    }

    public static Map<String, Object> createVaultPayloadMap(String name, String description, String securityLevel, String vaultType, String additionalProp1, String additionalProp2, String additionalProp3) {
        Map<String,Object> payload = new HashMap<>();
        payload.put("name", name);
        payload.put("description", description);
        payload.put("securityLevel", securityLevel);
        payload.put("vaultType", vaultType);

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("additionalProp1", additionalProp1);
        metadata.put("additionalProp2", additionalProp2);
        metadata.put("additionalProp3", additionalProp3);

        payload.put("metadata", metadata);
        return payload;
    }

}
