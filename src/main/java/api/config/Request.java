package api.config;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;


public class Request {


    public ValidatableResponse post(RequestSpecification request, String body, String endpoint, ResponseSpecification response) {
        return given()
                .spec(request)
                .body(body)
                .post(endpoint)
                .then()
                .statusCode(200);
    }
    public ValidatableResponse getUserByUsername(String username) {
        return RestAssured.given()
                .when()
                .get("/user/{username}", username)
                .then()
                .statusCode(200);
    }


//    public Response get(RequestSpecification request) {
//        return given()
//                .spec(request)
//                .get();
//    }
//    public Response put(RequestSpecification request, String body) {
//        return given()
//                .spec(request)
//                .body(body)
//                .put();
//    }
//    public Response delete(RequestSpecification request) {
//        return given()
//                .spec(request)
//                .delete();
//    }
}
