import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static config.WebDriverInit.closeDriver;
import static config.WebDriverInit.getDriver;

public class BaseTest {

    WebDriver driver = null;

    @BeforeSuite(groups = {"All", "Smoke", "Regression"})
    public void setUP() {
        driver = getDriver();
    }

    @AfterSuite(groups = {"All", "Smoke", "Regression"})
    public void tearDown() {
    closeDriver();
    }
}
