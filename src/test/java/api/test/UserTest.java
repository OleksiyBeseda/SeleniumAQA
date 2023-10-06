//package api.test;
//
//import api.dto.request.UserBuilder;
//import api.dto.response.ErrorResponseBuilder;
//import api.steps.UserSteps;
//import org.testng.annotations.Test;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//
//
//public class UserTest {
//    UserSteps userSteps = new UserSteps();
//
//    private final String changedName = "Alice";
//    private final String lastName = "Net";
//
//    @Test
//    void shouldBeCreateChangeAndDeleteUser() {
//        userSteps.createUser(UserBuilder.builder()
//                .id(0)
//                .userName("Nick")
//                .build());
//        userSteps.changeUser(UserBuilder.builder()
//                .id(0)
//                .userName(changedName)
//                .lastName(lastName)
//                .build());
//
//        userSteps.deleteUser(changedName);
//
//        ErrorResponseBuilder deletedUser = userSteps.getUser(deletedUser);
//        assertThat(deletedUser).isNull();
//
//
//    }
//
//}
