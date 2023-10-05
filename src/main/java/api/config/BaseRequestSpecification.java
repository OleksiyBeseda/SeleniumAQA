package api.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import static api.utils.Utils.getPropertyFromFile;


public class BaseRequestSpecification {

    private final String APPLICATION_JSON = "application/json";
    private final String CONTENT_TYPE = "Content-type";
    private final String url = (String) getPropertyFromFile("url");




    public RequestSpecification request() {
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setBasePath("v2")
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();
    }
//    public RequestSpecification requestAuth() {
//        return new RequestSpecBuilder()
//                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
//                .addHeader("Authorization", "Bearer " + getToken())
//                .addHeader(ACCEPT, APPLICATION_JSON)
//                .addHeader(X_REQUEST, XMLHttpRequest)
//                .build();
//    }

//    private String getToken() {
//        return "your-auth-token";
//    }


}
