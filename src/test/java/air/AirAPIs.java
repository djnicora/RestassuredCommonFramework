package air;

import io.restassured.response.Response;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirAPIs {

    public Response createAirUser(Map<String, Object> createAirPayload) {
        String endpoint = (String) Base.dataFromJsonFile.get("createUserEndpoint");
        return RestUtils.performPost(endpoint, createAirPayload, new HashMap<>());
    }

    public Response createVault(Map<String, Object> createVaultPayload) {
        String endpoint = (String) Base.dataFromJsonFile.get("createUserEndpoint");
        return RestUtils.performPost(endpoint, createVaultPayload, new HashMap<>());
    }

}
