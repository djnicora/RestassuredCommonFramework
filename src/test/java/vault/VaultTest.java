package vault;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import vault.pojos.CreatePermission;
import vault.pojos.CreateVault;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import vault.pojos.UploadDocument;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;

public class VaultTest extends VaultAPIs {
    VaultData vaultData = new VaultData();
//    @Test
//    public void createUser() {
//        Map<String, Object> payload = Payloads.createUserPayloadMap("25", "niko", "nikolov", "5");
//        Response response = createAirUser(payload);
//        Assert.assertEquals(response.statusCode(), 201);
//    }

    @Test
    public void createVault() {
        Map<String, String> header = Payloads.commonHeaderMap("string");

        Map<String, Object> payload = Payloads.createVaultPayloadMap("string", "string", "medium", "personal", "string", "string", "string");
        String endpoint = "/vaults";
        Response response = createVault(endpoint, header, payload);
        Assert.assertEquals(response.statusCode(), 201);
    }

    @Test
    public void createVaultRandom() {
        Map<String, String> header = Payloads.randomUserIdHeaderMap();
        Map<String, Object> payload = Payloads.createVaultPayloadMap();
        String endpoint = "/vaults";
        Response response = createVault(endpoint, header, payload);
        Assert.assertEquals(response.statusCode(), 201);
    }

    @Test
    public void createVaultFromPojo() throws JsonProcessingException {
//        Map<String, String> header = Payloads.randomUserIdHeaderMap();
        Map<String, String> header = Payloads.commonHeaderMap("zzzz");
//        CreateVault payload = Payloads.createVaultFromPojo();
//        CreateVault payload = new CreateVault().toBuilder().build();
        CreateVault payload = new CreateVault().toBuilder().name("second").securityLevel("medium").vaultType("personal").metadata(new CreateVault.Metadata().toBuilder().additionalProp2("nonDefault").build()).build();
        String endpoint = "/vaults";
        Response response = createVault(endpoint, header, payload);
        vaultData.vaultId = response.path("id");

        ObjectMapper objectMapper = new ObjectMapper();
        CreateVault createVaultResponse = objectMapper.readValue(response.getBody().asString(), CreateVault.class);
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(createVaultResponse, payload);


    }

    @Test
    public void createPermissionFromPojo() {
        Map<String, String> header = Payloads.commonHeaderMap("zzzz");
//        CreateVault payload = Payloads.createVaultFromPojo();
//        CreateVault payload = new CreateVault().toBuilder().build();
        CreatePermission payload = new CreatePermission().toBuilder().role("editor").toUserId("secondUser").dueDate("2025-12-30T15:20:00.5473").build();
        String endpoint = "/vaults/" + vaultData.vaultId + "/permissions";
        Response response = createPermission(endpoint, header, payload);
        Assert.assertEquals(response.statusCode(), 201);
    }

    @Test
    public void createPermissionAndVerifyFromPojo() throws JsonProcessingException {
        Map<String, String> header = Payloads.commonHeaderMap("zzzz");
        CreatePermission payload = new CreatePermission().toBuilder().role("editor").toUserId("secondUser2").dueDate("2025-12-30T15:20:00.547300").build();
        String endpoint = "/vaults/" + vaultData.vaultId + "/permissions";
        Response response = createPermission(endpoint, header, payload);

        ObjectMapper objectMapper = new ObjectMapper();
        CreatePermission createPermissionResponse = objectMapper.readValue(response.getBody().asString(), CreatePermission.class);

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(createPermissionResponse, payload);
    }

    @Test
    public void uploadDocumentFromPojo() {
        Map<String, String> header = Payloads.commonHeaderMap("zzzz");
        UploadDocument payload = new UploadDocument().toBuilder().file(new File("src/test/resources/uploadFiles/CarteVitale2.jpg")).build();
//        baseURI = "https://document-routing.tinqin-dev.com";
        String endpoint = "/vaults/" + vaultData.vaultId + "/documents";
        File file = new File("src/test/resources/uploadFiles/CarteVitale2.jpg");
//        RestAssured.given().log().all()
//                .headers(header)
//                .multiPart("file", file)
////                .formParam("fileName", file.getName())
////                .formParam("fileType", "text/plain")
////                .formParam("description", "This is a sample file")
//                .contentType(ContentType.MULTIPART).post(endpoint);
        Response response = uploadDocument(endpoint, header, payload.getFile());

//        Assert.assertEquals(response.statusCode(), 201);
    }

}
