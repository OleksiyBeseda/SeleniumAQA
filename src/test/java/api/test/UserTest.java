package api.test;

import api.dto.UserBuilder;
import api.steps.UserSteps;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.ValidatableResponse;
import static org.assertj.core.api.Assertions.assertThat;


public class UserTest {
    UserSteps userSteps = new UserSteps();

    private final UserBuilder user = UserBuilder.builder()
            .id(0)
            .userName("Nick")
            .build();

    //    @Test
//    void shouldBeCreateUser() {
//        userSteps.createUser(user);
//    }
    @Test
//    void shouldBeGetUser() {
//        var response = userSteps.createUser(user).extract().path("username");
//
//        assertThat(statusCode).as("The status code is not equal 200")
//                .isEqualTo(200);
//
//        System.out.println(response);
//        user.getUserName();
//    }
    void shouldCreateAndRetrieveUser() {
        UserBuilder user = UserBuilder.builder()
                .id(0)
                .userName("Nick")
                .build();

        int createStatusCode = userSteps.createUser(user);
        assertThat(createStatusCode).as("The create status code is not equal 200").isEqualTo(200);

        String username = user.getUserName();

        ValidatableResponse response = userSteps.getUserByUsername(username);

        String retrievedUsername = response.extract().path("username");

        assertThat(retrievedUsername).as("The retrieved username does not match the expected username")
                .isEqualTo(username);
    }
}
