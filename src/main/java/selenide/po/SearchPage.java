package selenide.po;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static selenide.js.JSActions.click;


public class SearchPage {

    private final SelenideElement history = $x("//span[text()='Просмотры']/../following-sibling::div//li[3]");
    private final SelenideElement searchField = $x("//input[@name='search']");
    private final SelenideElement firstArticle = $x("//h1[@id='firstHeading']");
    private final SelenideElement headerArticle = $x("//a[@data-prefixedtext='Ubisoft Poland']");

    public SelenideElement getHeaderArticle() {
        return $x("//a[@data-prefixedtext='Ubisoft Poland']");
    }
    public SearchPage fillSearch(String text) {
       searchField.shouldBe(visible).sendKeys(text);
       return page(SearchPage.class);
    }
    public SearchPage clickEnter() {
        searchField.shouldBe(visible).sendKeys(Keys.ENTER);
        return page(SearchPage.class);
    }
    public SearchPage clickResultUbisoftArticle() {
        firstArticle.shouldBe(visible, enabled);
        click(firstArticle);
        return page(SearchPage.class);
    }
}
