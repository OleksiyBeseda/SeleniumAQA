package api.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class GetUserResponseBuilder {

    Long id;
    String username;
    String lastname;
    Integer userStatus;
}
