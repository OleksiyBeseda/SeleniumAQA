package selenium.listeners;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import selenium.po.ArticlePage;
import selenium.po.SearchPage;

import static org.testng.Assert.assertEquals;

public class SearchTest extends BaseTest{

    SearchPage search = new SearchPage();
    ArticlePage article = new ArticlePage();

    @BeforeMethod
    public void open() {
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @Test(groups = {"Regression"}, dataProvider = "data-test", retryAnalyzer = RetryAnalyzer.class)
    void shouldBeVisibleResultSearch(String result) {
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().setSize(new Dimension(1920, 1080));

        search.clickOnTabHistory();
        search.fillText(result);
        search.enterSearch();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(search.getTitle())
                .as("The result is appeared")
                .isEqualTo("Результаты поиска");


        softly.assertAll();
//        assertEquals("Результаты поиска",search.getTitle(), "The result in not the same");
//        assertNotEquals("Результаты не поиска",search.getTitle(), "The result in not the same");

    }

    @Test
    void shouldBeVisibleResultSearchUbisoft() {
        search.fillText("Ubisoft office");
        search.enterSearch();
        search.clickResultUbisoftArticle();


        assertEquals("Ubisoft Poland", article.getTitleArticle());
    }


    @DataProvider(name = "data-test")
    public Object[][] getResults() {
        return new Object[][] {
                {"Odesa"},
                {"Ubisoft"},
                {"Результаты поиска2"}
        };
    }



}
