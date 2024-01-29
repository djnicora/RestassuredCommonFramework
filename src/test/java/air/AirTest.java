package air;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.JsonUtils;
import utils.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AirTest {

    @Test
    public void createUser() throws IOException {
        Map<String, String> data = JsonUtils.getJsonDataAsMap("AirAPIData.json");

        String endpoint = data.get("endpoint");
        Map<String,String> payload =  Payloads.createUserMap("25","niko","nikolov","5");

        Response response = RestUtils.performPost(endpoint, payload, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 201);
    }


}
