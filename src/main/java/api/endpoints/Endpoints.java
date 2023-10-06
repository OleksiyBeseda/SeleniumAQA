package api.endpoints;

public enum Endpoints {

    CREATE_USER("/user"),
    USER_WITH_PARAM("/user/"),
    DELETE_USER("/user/{username}"),
    GET_TOKEN("/GenerateToken"),
    ADD_BOOK("/Books"),
    USER("/User/");




    private final String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getValue() {
        return endpoint;
    }
}
