package api.dto.response;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEditResponseBuilder {

    Integer code;
    String type;
    String message;
}
