import builder.LoginPageBuilder;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import po.LoginPage;

import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void open() {
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @Test
    void shouldBeVisibleResultSearch() {
        loginPage.clickLoginButton();
        loginPage.enterUsername("Beseda.test");
        loginPage.enterPassword("hillelaqa");
        loginPage.clickEnterButton();

        assertEquals("Beseda.test", loginPage.getActualNickname(), "The result is not the same");

    }

    @Test
    void shouldBeEnterToTheSystem() {
        new LoginPage()
                .clickLogin();
        LoginPage login = new LoginPageBuilder()
                .withUsername("Beseda.test")
                .withPassword("hillelaqa")
                .build();

             login.clickEnterButton();

    }

}
