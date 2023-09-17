package po;

import base.BaseMethod;
import org.openqa.selenium.By;

public class SearchPage extends BaseMethod {
    private final By history = By.xpath("//span[text()='Просмотры']/../following-sibling::div//li[3]");
    private final By search = By.xpath("//input[@name='search']");
    private final By result = By.xpath("//h1[@id='firstHeading']");
    private final By ubisoft = By.xpath("//a[@data-prefixedtext='Ubisoft Poland']");

    public void clickOnTabHistory() {
        click(history, 10);
    }
    public void fillText(String text) {
        send(search, text);
    }
    public void enterSearch() {
        clickEnter(search);
    }
    public String getTitle() {
        return getTextFromElement(result);
    }
    public void clickResultUbisoftArticle() {
        click(ubisoft, 20);
    }
}
