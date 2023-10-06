package api.config;

import api.dto.request.UserRequestBuilder;
import api.endpoints.Endpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.bouncycastle.cert.ocsp.Req;

import static api.utils.Utils.getPropertyFromFile;
import static api.utils.Utils.toJson;


public class BaseRequestSpecification {

    private final String APPLICATION_JSON = "application/json";
    private final String CONTENT_TYPE = "Content-type";
    private final String url = (String) getPropertyFromFile("url");
    private final String url_book_store = (String) getPropertyFromFile("url_book_store");
    private final String url_book_collection = (String) getPropertyFromFile("url_book_collection");
    private final String ACCOUNT = "Account/";
    private final String BOOK_STORE = "Book_Store/";
    private final Request request = new Request();
    private final BaseResponseSpecification response = new BaseResponseSpecification();
    public String getToken() {
        return request.post(requestBook(), toJson(new UserRequestBuilder("Beseda", "Beseda123!")), Endpoints.GET_TOKEN.getValue(),
                response.OK()).extract().body().path("token");
    }


    public RequestSpecification addBook() {
        return new RequestSpecBuilder()
                .setBaseUri(url_book_collection)
                .setBasePath("v1")
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .addHeader("Authorization", "Bearer " + getToken())
                .build();
    }
    public RequestSpecification requestBook() {
        return new RequestSpecBuilder()
                .setBaseUri(url_book_store)
                .setBasePath("v1")
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();
    }

    public RequestSpecification requestWithToken() {
        return new RequestSpecBuilder()
                .setBaseUri(url_book_store)
                .setBasePath("v1")
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .addHeader("Authorization", "Bearer " + getToken())
                .build();
    }


}
