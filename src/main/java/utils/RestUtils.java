package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RestUtils {

    public static Response performPost(String endpoint, Map<String,String> requestPayload, Map<String, String> headers) {
        baseURI = endpoint;
        Response response = given().log().all()
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post()
                .then()
                .log().all().extract().response();

        return response;
    }

    public static Response performPost(String endpoint, String requestPayload, Map<String, String> headers) {
        baseURI = endpoint;
        Response response = given().log().all()
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload)
                .post()
                .then()
                .log().all().extract().response();

        return response;
    }


}
