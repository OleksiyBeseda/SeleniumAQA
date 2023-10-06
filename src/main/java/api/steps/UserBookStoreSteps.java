package api.steps;

import api.config.BaseRequestSpecification;
import api.config.BaseResponseSpecification;
import api.config.Request;
import api.dto.response.AddBookRequestBuilder;
import api.dto.response.UserBookStoreResponseBuilder;
import api.endpoints.Endpoints;

import static api.utils.Utils.fromJson;

public class UserBookStoreSteps extends Request {
    BaseRequestSpecification baseRequest = new BaseRequestSpecification();
    BaseResponseSpecification baseResponse = new BaseResponseSpecification();

    public AddBookRequestBuilder  AddBook () {
        var bodyRequest = "    { \"userId\": \"d175aea1-26b6-49ec-b451-813d3642633f\", \"collectionOfIsbns\": [ { \"isbn\": \"9781593275846\" } ] }";
        var response = post(baseRequest.addBook(), bodyRequest, Endpoints.ADD_BOOK.getValue(),baseResponse.AddedBook())
                .extract().body().asString();
//        System.out.println(response);

        return fromJson(response, AddBookRequestBuilder.class);
    }

//    { "userId": "d175aea1-26b6-49ec-b451-813d3642633f", "collectionOfIsbns": [ { "isbn": "9781449325862" } ] }

    public UserBookStoreResponseBuilder getUser() {
        var response = get(baseRequest.requestWithToken(), Endpoints.USER_WITH_PARAM.getValue(), "d175aea1-26b6-49ec-b451-813d3642633f",
                baseResponse.OK()).extract().body().asString();
        return fromJson(response, UserBookStoreResponseBuilder.class);
    }




}
