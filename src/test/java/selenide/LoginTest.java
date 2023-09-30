package selenide;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenide.po.LoginPage;
import selenium.listeners.BaseTest;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void setUP() {
        Configuration.browser = "chrome";
    }

    @Test(alwaysRun = true)
    void shouldBeVisibleResultSearch() {
        open("https://ru.wikipedia.org/");
        getWebDriver().manage().window().setSize(new Dimension(1920, 1080));


        loginPage
                .clickLoginButton()
                .fillUsername("Beseda.test")
                .enterPassword("hillelaqa")
                .clickEnterButton();

        assertEquals("Beseda.test", loginPage.getActualNickname("Beseda.test"), "The result is not the same");


    }


    @Test(groups = {"Regression"}, dataProvider = "validationName-test")
    void shouldBeEnterToTheSystemWithUsername(String username) {
        open("https://ru.wikipedia.org/");
        getWebDriver().manage().window().setSize(new Dimension(1920, 1080));


        loginPage
                .clickLoginButton()
                .fillUsername(username)
                .enterPassword("validationPassword-test")
                .clickEnterButton();

        assertEquals("Beseda.test", loginPage.getActualNickname("Beseda.test"), "The result is not the same");

    }


    @DataProvider(name = "validationName-test")
    public Object[][] getInvalidUsernames() {
        return new Object[][] {
                {""},
                {"Beseda12%"}
        };
    }
}



