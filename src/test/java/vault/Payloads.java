package vault;

import vault.pojos.CreateVault;
import vault.pojos.CreateVault.Metadata;

import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import utils.RandomDataGenerator;
import utils.RandomDataTypes;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static Map<String, String> commonHeaderMap(String userId) {
        Map<String, String> payload = new HashMap<>();
        payload.put("userId", userId);
        return payload;
    }

    public static Map<String, String> randomUserIdHeaderMap() {
        Map<String, String> payload = new HashMap<>();
        payload.put("userId", RandomStringUtils.randomAlphanumeric(10));
        return payload;
    }

    public static String createUser(String id, String firstName, String lastName, String subjectId) {
        return "{\n" +
                "    \"id\": " + id + ",\n" +
                "    \"firstName\": \"" + firstName + "\",\n" +
                "    \"lastName\": \"" + lastName + "\",\n" +
                "    \"subjectId\": \"" + subjectId + "\"\n" +
                "  }";
    }

    public static Map<String, Object> createUserPayloadMap(String id, String firstName, String lastName, String subjectId) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", id);
        payload.put("firstName", firstName);
        payload.put("lastName", lastName);
        payload.put("subjectId", subjectId);
        return payload;
    }

    public static Map<String, Object> createVaultPayloadMap(String name, String description, String securityLevel, String vaultType, String additionalProp1, String additionalProp2, String additionalProp3) {
        Map<String, Object> payload = new HashMap<>();
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

    public static Map<String, Object> createVaultPayloadMap() {
        Map<String, Object> payload = new HashMap<>();
        Faker faker = new Faker();
        payload.put("name", RandomDataGenerator.getRandomDataFor(RandomDataTypes.FULLNAME));
        payload.put("description", faker.famousLastWords().lastWords());
        payload.put("securityLevel", "medium");
        payload.put("vaultType", "personal");

        Map<String, Object> metadata = new HashMap<>();
        metadata.put("additionalProp1", faker.animal().species());
        metadata.put("additionalProp2", faker.animal().genus());
        metadata.put("additionalProp3", faker.animal().name());

        payload.put("metadata", metadata);
        return payload;
    }

    public static CreateVault createVaultFromPojo() {
        return CreateVault.builder()
                .name("string")
                .description("string")
                .securityLevel("medium")
                .vaultType("personal")
                .metadata(
                        Metadata.builder()
                                .additionalProp1("personal")
                                .additionalProp2("string")
                                .additionalProp3("string")
                                .build()
                )
                .build();

    }

}
