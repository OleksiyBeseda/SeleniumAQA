package api.endpoints;

public enum Endpoints {

    CREATE_USER("/user"),
    USER_WITH_PARAM("/user/"),
    DELETE_USER("/user/{username}");




    private final String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getValue() {
        return endpoint;
    }
}
