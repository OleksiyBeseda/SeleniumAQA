package api.test;

import api.steps.UserBookStoreSteps;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserBookTest {
    UserBookStoreSteps user = new UserBookStoreSteps();
    UserBookStoreSteps addBookSteps = new UserBookStoreSteps();
    @Test
    void getUserWithBook() {
        addBookSteps.AddBook();
        var response = user.getUser();

     assertThat(response.getBooks().get(0).getTitle()).as("The titles are not same")
             .isEqualTo("Eloquent JavaScript, Second Edition");
    }
}
