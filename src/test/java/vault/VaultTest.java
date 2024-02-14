package vault;

import vault.pojos.CreatePermission;
import vault.pojos.CreateVault;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;


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
    public void createVaultFromPojo() {
//        Map<String, String> header = Payloads.randomUserIdHeaderMap();
        Map<String, String> header = Payloads.commonHeaderMap("zzzz");
//        CreateVault payload = Payloads.createVaultFromPojo();
//        CreateVault payload = new CreateVault().toBuilder().build();
        CreateVault payload = new CreateVault().toBuilder().name("second").securityLevel("medium").vaultType("personal").metadata(new CreateVault.Metadata().toBuilder().additionalProp2("nonDefault").build()).build();
        String endpoint = "/vaults";
        Response response = createVault(endpoint, header, payload);
        vaultData.vaultId = response.path("id");
        System.out.println(vaultData.vaultId);
        Assert.assertEquals(response.statusCode(), 201);
    }

    @Test
    public void createPermissionFromPojo() {
        Map<String, String> header = Payloads.commonHeaderMap("zzzz");
//        CreateVault payload = Payloads.createVaultFromPojo();
//        CreateVault payload = new CreateVault().toBuilder().build();
        CreatePermission payload = new CreatePermission().toBuilder().role("editor").toUserId("secondUser").dueDate("2025-12-30T15:20:00.5473").build();
        String endpoint = "/vaults/"+vaultData.vaultId+"/permissions";
        Response response = createPermission(endpoint, header, payload);
        Assert.assertEquals(response.statusCode(), 201);
    }
}
