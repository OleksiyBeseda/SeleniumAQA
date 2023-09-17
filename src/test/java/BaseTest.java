import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static config.WebDriverInit.closeDriver;
import static config.WebDriverInit.getDriver;

public class BaseTest {

    WebDriver driver = null;

    @BeforeSuite
    public void setUP() {
        driver = getDriver();
    }

    @AfterSuite
    public void tearDown() {
    closeDriver();
    }
}
