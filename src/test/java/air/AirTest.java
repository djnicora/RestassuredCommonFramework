package air;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;


public class AirTest extends AirAPIs{

    @Test
    public void createUser() {
        Map<String, Object> payload = Payloads.createUserPayloadMap("25", "niko", "nikolov", "5");
        Response response = createAirUser(payload);
        Assert.assertEquals(response.statusCode(), 201);
    }

    @Test
    public void createVault()  {
        Map<String, Object> payload = Payloads.createVaultPayloadMap("string", "string", "medium", "personal","string","string","string");
        Response response = createVault(payload);
        Assert.assertEquals(response.statusCode(), 201);
    }
}
