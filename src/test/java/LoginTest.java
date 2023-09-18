import builder.LoginPageBuilder;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import po.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;


public class LoginTest extends BaseTest{

    LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void open() {
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @Test(alwaysRun = true)
    void shouldBeVisibleResultSearch() {
        loginPage.clickLoginButton();
        loginPage.enterUsername("Beseda.test");
        loginPage.enterPassword("hillelaqa");
        loginPage.clickEnterButton();

        assertEquals("Beseda.test", loginPage.getActualNickname(), "The result is not the same");

    }






    @Test(groups = {"Regression"}, dataProvider = "validationName-test")
    void shouldBeEnterToTheSystemWithUsername(String username) {
        new LoginPage()
                .clickLogin();
        LoginPage login = new LoginPageBuilder()
                .withUsername("validationName-test")
                .withPassword("validationPassword-test")
                .build();

        login.clickEnterButton();

        assertNotEquals("Beseda.test", loginPage.getActualNickname(), "The result is not the same");
    }
    @DataProvider(name = "validationName-test")
    public Object[][] getInvalidUsernames() {
        return new Object[][] {
                {""},
                {"Beseda12%"}
        };
    }

    @Test(groups = {"Regression"}, dataProvider = "validationPassword-test")
    void shouldBeEnterToTheSystemWithPassword(String password) {
        new LoginPage()
                .clickLogin();
        LoginPage login = new LoginPageBuilder()
                .withUsername("Beseda123")
                .withPassword("validationPassword-test")
                .build();

        login.clickEnterButton();

        assertNotEquals("Beseda.test", loginPage.getActualNickname(), "The result is not the same");
    }
    @DataProvider(name = "validationPassword-test")
    public Object[][] getInvalidPasswords() {
        return new Object[][] {
                {""},
                {"hillelaqaaaa"}
        };







    }

}
