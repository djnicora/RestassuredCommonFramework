package utils;

import freemarker.core.InvalidReferenceException;
import reporting.ExtentReportManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import java.io.File;
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

    private static RequestSpecification getRequestSpecification(String endpoint, Map<String, Object> headers, File file) {
        baseURI = endpoint;
        return given().log().all()
                .headers(headers)
                .multiPart("file", file)
//                .formParam("internalMetadata", "{\"field\": \"example\",\"secondField\": \"internalMetadata\"}")
//
                .contentType(ContentType.MULTIPART);

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

    public static Response performPost(String endpoint, Object requestPayloadAsPojo, Map<String, Object> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, requestPayloadAsPojo, headers);
        Response response= requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogReport(response);
        return response;
    }

    public static Response performPostUpload(String endpoint,  Map<String, Object> headers,File file) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, headers,file);
        Response response= requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogReport(response);
        return response;
    }


}
