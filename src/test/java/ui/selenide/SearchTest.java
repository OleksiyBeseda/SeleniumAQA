package ui.selenide;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.selenide.po.SearchPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTest {

    @BeforeMethod
    public void setUP() {
        Configuration.browser = "chrome";
    }

    @Test
    void shouldBeVisibleArticleUbisoft() {
        open("https://ru.wikipedia.org/");
        getWebDriver().manage().window().setSize(new Dimension(1920, 1080));
        new SearchPage().fillSearch("Ubisoft office")
                .clickEnter()
                .clickResultUbisoftArticle();
        assertThat(new SearchPage().getHeaderArticle().shouldBe(visible).getText())
                .as("The header of Ubisoft article was not found")
                .isEqualTo("Ubisoft Poland");

    }
}
