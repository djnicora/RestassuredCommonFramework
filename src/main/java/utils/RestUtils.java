package utils;

import reporting.ExtentReportManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class RestUtils {

    private static RequestSpecification getRequestSpecification(String endpoint, Object requestPayload, Map<String, Object> headers) {
        baseURI = endpoint;
        return given().log().all()
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification){
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
       ExtentReportManager.logInfoDetails("Endpoint is: "+queryableRequestSpecification.getBaseUri());
       ExtentReportManager.logInfoDetails("Method is: "+queryableRequestSpecification.getMethod());
       ExtentReportManager.logInfoDetails("Request headers is: ");
       ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
       ExtentReportManager.logInfoDetails("Request body is");
       ExtentReportManager.logJson(queryableRequestSpecification.getBody());
    }

    private static void printResponseLogReport(Response response){
        ExtentReportManager.logInfoDetails("Response status is: "+response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response headers is");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response body is");
        ExtentReportManager.logJson(response.getBody().prettyPrint());

    }
    public static Response performPost(String endpoint, Map<String, Object> requestPayload, Map<String, Object> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, requestPayload, headers);
        Response response= requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogReport(response);
        return response;
    }

    public static Response performPost(String endpoint, String requestPayload, Map<String, Object> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, requestPayload, headers);
        Response response= requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogReport(response);
        return response;
    }


}
