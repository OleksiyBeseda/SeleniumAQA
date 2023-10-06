package api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserBookStoreResponseBuilder {
    public String userId;
    public String username;
    public ArrayList<AddBookRequestBuilder> books;
}
