package api.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class UserBuilder {

        Integer id;
        String userName;
        String firstName;
        String lastName;
        String email;
        String password;
        String phone;
        String userStatus;
    }


