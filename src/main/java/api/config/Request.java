package api.config;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class Request {

    public ValidatableResponse post(RequestSpecification request, String body, String endpoint) {
        return given()
                .spec(request)
                .body(body)
                .post(endpoint)
                .then()
                .log().all();
    }

    public ValidatableResponse post(RequestSpecification request, String body, String endpoint, ResponseSpecification response) {
        return given()
                .spec(request)
                .body(body)
                .post(endpoint)
                .then()
                .spec(response);
    }

    public ValidatableResponse post(RequestSpecification request, String body, String endpoint, ResponseSpecification response,
                                    String path) {
        return given()
                .spec(request)
                .body(body)
                .post(endpoint)
                .then()
                .spec(response)
                .body(matchesJsonSchemaInClasspath(path));
    }

    public ValidatableResponse get(RequestSpecification request, String endpoint, String params, ResponseSpecification response) {
        return given()
                .spec(request)
                .get(endpoint + params)
                .then()
                .spec(response);
    }

    public ValidatableResponse get(RequestSpecification request, String endpoint, String username, ResponseSpecification response,
                                   String path) {
        return given()
                .spec(request)
                .get(endpoint + username)
                .then()
                .spec(response)
                .body(matchesJsonSchemaInClasspath(path));
    }

    public ValidatableResponse put(RequestSpecification request, String body, String endpoint, String param,
                        ResponseSpecification response) {
        return given()
                .spec(request)
                .body(body)
                .put(endpoint + param)
                .then()
                .spec(response);
    }

    public Response delete(RequestSpecification request, String endpoint, String param,
                                      ResponseSpecification response) {
        return given()
                .spec(request)
                .delete(param);
    }
}
