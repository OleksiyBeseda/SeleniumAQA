import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewMainTest {
    public static void  main(String[] args) {

        By search = By.xpath("//*[@id=\"searchInput\"]");
        By result = By.xpath("//*[@id=\"firstHeading\"]");
        By subresult = By.xpath("//*[@id=\"firstHeading\"]/span");

        //Установка последнего chromedriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //переход на url
        driver.get("https://ru.wikipedia.org/");
        //раскрытие экрана до размера 1920 на 1080 пикслей
        driver.manage().window().setSize(new Dimension(1920, 1080)); // указал такой размер так как у меня 2 экрана
        //находим элемент и печатаем в нём текст
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(search)).sendKeys("Killerbees");
        wait.until(d -> d.findElement(search)).sendKeys(Keys.ENTER);

        //поиск текста на странице
        assert "Killerbees".equals(getTextFromElement(driver, result));
        driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[4]/div[3]/div/ul/li[1]/div[1]/a/span")).click();
        assert "Killerbee 106.3".equals(getTextFromElement(driver, subresult));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //закрытие страницы и очистка памяти
        driver.quit();
    }
    static String getTextFromElement(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        return wait.until(d ->d.findElement(locator)).getText();
    }
}
