//package api.steps;
//
//import api.config.BaseRequestSpecification;
//import api.config.BaseResponseSpecification;
//import api.config.Request;
//import api.dto.request.UserBuilder;
//import api.dto.response.ErrorResponseBuilder;
//import api.dto.response.GetUserResponseBuilder;
//import api.dto.response.UserCreateResponseBuilder;
//import api.dto.response.UserEditResponseBuilder;
//import api.endpoints.Endpoints;
//import api.endpoints.Schemas;
//import api.utils.Utils;
//import static api.endpoints.Endpoints.CREATE_USER;
//import static api.utils.Utils.toJson;
//
//public class UserSteps extends Request {
//
//    BaseRequestSpecification baseRequest = new BaseRequestSpecification();
//    BaseResponseSpecification baseResponse = new BaseResponseSpecification();
//
//    private final UserBuilder user = UserBuilder.builder()
//            .id(0)
//            .userName("Nick")
//            .build();
//
//    public UserCreateResponseBuilder createUser(UserBuilder user) {
//        var response = post(baseRequest.request(), toJson(user), CREATE_USER.getValue(), baseResponse.OK(),
//                Schemas.CREATE_USER_SCHEMA.getValue())
//                .extract()
//                .body()
//                .asString();
//
//        return Utils.fromJson(response, UserCreateResponseBuilder.class);
//    }
//
//    public GetUserResponseBuilder getUser(String username) {
//        var response = get(baseRequest.request(), Endpoints.USER_WITH_PARAM.getValue(), username, baseResponse.OK(),
//                Schemas.GET_USER_SCHEMA.getValue())
//                .extract()
//                .body()
//                .asString();
//        return Utils.fromJson(response, GetUserResponseBuilder.class);
//    }
//
//    public UserCreateResponseBuilder changeUser(UserBuilder user) {
//        var response = put(baseRequest.request(), toJson(user), Endpoints.USER_WITH_PARAM.getValue(), user.getUserName(),
//                baseResponse.OK())
//                .extract()
//                .body()
//                .asString();
//
//        return Utils.fromJson(response, UserCreateResponseBuilder.class);
//    }
//
//    public void deleteUser(String username) {
//        delete(Endpoints.DELETE_USER.getValue(), user.getUserName())
//                .then()
//                .statusCode(200);
//    }
//
//
//
//}
