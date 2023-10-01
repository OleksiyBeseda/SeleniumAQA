package api.steps;

import api.config.BaseRequestSpecification;
import api.config.BaseResponseSpecification;
import api.config.Request;
import api.dto.UserBuilder;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
import io.restassured.response.ValidatableResponse;

import static api.endpoints.Endpoints.CREATE_USER;
import static api.utils.Utils.toJson;

public class UserSteps extends Request {

    BaseRequestSpecification baseRequest = new BaseRequestSpecification();
    BaseResponseSpecification baseResponse = new BaseResponseSpecification();

    private final UserBuilder user = UserBuilder.builder()
            .id(0)
            .userName("Nick")
            .build();


    public int createUser(UserBuilder user) {
        ValidatableResponse response = given()
                .spec(baseRequest.request())
                .body(toJson(user))
                .post(CREATE_USER.getValue())
                .then()
                .statusCode(200);
        return response.extract().statusCode();
    }

//    public ValidatableResponse createUser(UserBuilder user) {
//        return post(baseRequest.request(), toJson(user), CREATE_USER.getValue(), baseResponse.OK());
//    }
}
