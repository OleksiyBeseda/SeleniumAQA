
package selenide;

import com.codeborne.selenide.ElementsCollection;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import selenide.po.ActionsPage;
import java.util.stream.Collectors;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ActionsTest {

    @Test
    public void doubleClickAndContextClickCheck() {
        open("https://demoqa.com/buttons");
        getWebDriver().manage().window().setSize(new Dimension(1920, 1080));
        new ActionsPage()
                .clickDoubleClick()
                .clickContextClick();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(new ActionsPage().getDoubleClickText().shouldBe(visible).getText())
                .as("The text of clicked double click was not found")
                .isEqualTo("You have done a double click");

        softly.assertThat(new ActionsPage().getContextClickButton().shouldBe(visible).getText())
                .as("The text of clicked context click was not found")
                .isEqualTo("You have done a right click");
        softly.assertAll();
    }


    @Test
    public void dragAndDropElementTest () {
        open("https://demoqa.com/droppable");
        getWebDriver().manage().window().setSize(new Dimension(1920, 1080));

        new ActionsPage()
                .dragAndDropElement();

        assertThat(new ActionsPage().dropped().shouldBe(visible).getText())
                .as("The text was not visible")
                .isEqualTo("Dropped!");
    }

    @Test
    public void getTextFromElements() {
        open("https://demoqa.com/automation-practice-form");
        getWebDriver().manage().window().setSize(new Dimension(1920, 1080));

        ElementsCollection collection =$$x("//div[@class='custom-control custom-checkbox custom-control-inline']");

        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        System.out.println(collection.texts().stream().filter(t -> t.startsWith("S")).collect(Collectors.toList()));


    }
}
