package vault;

import vault.pojos.CreatePermission;
import vault.pojos.CreateVault;
import io.restassured.response.Response;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class VaultAPIs {

    public Response createAirUser(Map<String, Object> createAirPayload) {
        String endpoint = (String) Base.dataFromJsonFile.get("createUserEndpoint");
        return RestUtils.performPost(endpoint, createAirPayload, new HashMap<>());
    }

    public static Response createVault(String endpoint,Map<String,String> header, Map<String, Object> createVaultPayload) {
        String baseUri = Base.dataFromJsonFile.get("vaultEndpoint") +endpoint;
        return RestUtils.performPost(baseUri, createVaultPayload, new HashMap<>(header));
    }

    public static Response createVault(String endpoint,Map<String,String> header, CreateVault createVaultPayload) {
        String baseUri =  Base.dataFromJsonFile.get("vaultEndpoint")+endpoint;
        return RestUtils.performPost(baseUri, createVaultPayload, new HashMap<>(header));
    }

    public static Response createPermission(String endpoint, Map<String,String> header, CreatePermission createPermissionPayload) {
        String baseUri =  Base.dataFromJsonFile.get("vaultEndpoint")+endpoint;
        return RestUtils.performPost(baseUri, createPermissionPayload, new HashMap<>(header));
    }
}
