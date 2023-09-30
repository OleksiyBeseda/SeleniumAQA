package selenium.listeners;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.po.ActionsPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ActionsTest extends BaseTest {

@Test
    public void checkDoubleAndContextClick() {
    driver.get("https://demoqa.com/buttons");
    driver.manage().window().setSize(new Dimension(1920, 1080));
    new ActionsPage()
            .clickDoubleClick()
            .clickRightClick();

    SoftAssertions softly = new SoftAssertions();

    softly.assertThat(new ActionsPage().getDoubleText())
            .as("The text is not visible")
            .isEqualTo("You have done a double click");

    softly.assertThat(new ActionsPage().getRightText())
            .as("The text is not visible")
            .isEqualTo("You have done a right click");
    softly.assertAll();
}

@Test
public void dragAndDropElement() {
    driver.get("https://demoqa.com/droppable");
    driver.manage().window().setSize(new Dimension(1920, 1080));
    new ActionsPage()
            .dragAndDropEelment();

    assertThat(new ActionsPage().getDropped())
            .as("The element is not dropped")
            .isEqualTo("Dropped!");
}

    @Test
    public void acceptlAlert() {
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().setSize(new Dimension(1920, 1080));
        new ActionsPage().promptAlert();

        driver.switchTo().alert().sendKeys("Prompt");
        driver.switchTo().alert().accept();
    }

    @Test
    public void getTextFromNestedFrame() {
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().window().setSize(new Dimension(1920, 1080));

        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(frame1);

        WebElement frame2 = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(frame2);

        WebElement framesParagraph = driver.findElement(By.xpath("/html/body/p"));

         assertThat(new ActionsPage().getTextNestedFrame())
                .as("Selenium located into frame")
                .isEqualTo("Child Iframe");

        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();
    }


    @Test
    public void uploadFileTest() {
        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().setSize(new Dimension(1920, 1080));

    new ActionsPage()
            .uploadFile("C:\\Users\\besed\\IdeaProjects\\SeleniumAQA\\text.txt");
    }

    @Test
    public void getTextFromTable() {
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().setSize(new Dimension(1920, 1080));

        assertThat(new ActionsPage().getTextFromTable(2,2))
                .as("Selenium located not into frame")
                .isEqualTo("Cantrell");

    }


}
