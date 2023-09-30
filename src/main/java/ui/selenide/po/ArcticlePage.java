package ui.selenide.po;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import ui.selenium.base.BaseMethod;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ArcticlePage {


    public class ArticlePage extends BaseMethod {

        private final SelenideElement title = $x("//h1[@id='firstHeading']/span");


        public SearchPage getTitleArticle() {
            title.shouldBe(visible).sendKeys(Keys.ENTER);
            return Selenide.page(SearchPage.class);
        }
    }
}

