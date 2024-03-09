package ApiBase;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestApi {

    private static RequestSpecification request;
    private static Response response;
    private static String RequestUrl;
    private static Map<String, String> sessionHeaders;
    private static String bodyRequest;
    private static Map<String, String> queryParams;
    private static Map<String, String> formParams;
    private static File multiPartRequest ;



    public static Response apiRequest(String requestType, ContentType contentType) {

        request = given();

        if (sessionHeaders != null) {request.headers(sessionHeaders);}

        if (contentType != null) {request.contentType(contentType);}

        if (formParams != null) {request.formParams(formParams);}

        if (queryParams != null) {request.queryParams(queryParams);}

        if (bodyRequest != null) {request.body(bodyRequest);}

        if (multiPartRequest != null) {request.multiPart("file", multiPartRequest);}

        sendRequest(RequestType.valueOf(requestType));

        return response;
    }

    private static void sendRequest(RequestType requestType) {

        switch (requestType) {

            case POST -> response = request.when().post(RequestUrl).andReturn();
            case PATCH -> response = request.when().patch(RequestUrl).andReturn();
            case PUT -> response = request.when().put(RequestUrl).andReturn();
            case GET -> response = request.when().get(RequestUrl).andReturn();
            case DELETE -> response = request.when().delete(RequestUrl).andReturn();
            default -> {}
        }
    }

    public enum RequestType{
        POST, GET, PUT, DELETE, PATCH
    }

    public static void setRequestURL(String url){RequestUrl = url;}
    public static void setQueryParams(Map<String, String> queryParams) {RequestApi.queryParams = queryParams;}
    public void setFormParams(Map<String, String> formParams) {
        RequestApi.formParams = formParams;
    }
    public void setRequest(RequestSpecification request) {RequestApi.request = request;}
    public static void setSessionHeaders(Map<String, String> sessionHeaders) {RequestApi.sessionHeaders = sessionHeaders;}
    public static void setBodyRequest(String bodyRequest) {RequestApi.bodyRequest = bodyRequest;}
    public static void setMultiPartRequest(File file) {RequestApi.multiPartRequest = file;}

}
