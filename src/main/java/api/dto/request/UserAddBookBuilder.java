package api.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddBookBuilder {
    public String userId;
    public ArrayList<CollectionOfIsbn> collectionOfIsbns;
}
