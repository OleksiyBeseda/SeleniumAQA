package api.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class UserBuilder {

        private Integer id;
        private String userName;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String phone;
        private String userStatus;
    }

//                "id": 0,
//                "username": "string",
//                "firstName": "string",
//                "lastName": "string",
//                "email": "string",
//                "password": "string",
//                "phone": "string",
//                "userStatus": 0
//}
