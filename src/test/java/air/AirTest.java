package air;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;


public class AirTest extends AirAPIs{

    @Test
    public void createUser()  {
        Map<String, Object> payload = Payloads.createUserPayloadMap("25", "niko", "nikolov", "5");
        Response response = createAirUser(payload);
        Assert.assertEquals(response.statusCode(), 201);
    }


}
