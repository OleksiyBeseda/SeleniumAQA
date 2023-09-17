import org.openqa.selenium.Dimension;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import po.ArticlePage;
import po.SearchPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class SearchTest extends BaseTest{

    SearchPage search = new SearchPage();
    ArticlePage article = new ArticlePage();

    @BeforeMethod
    public void open() {
        driver.get("https://ru.wikipedia.org/");
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @Test
    void shouldBeVisibleResultSearch() {

        search.clickOnTabHistory();
        search.fillText("Odesa");
        search.enterSearch();

        assertEquals("Результаты поиска",search.getTitle(), "The result in not the same");
        assertNotEquals("Результаты не поиска",search.getTitle(), "The result in not the same");

    }

    @Test
    void shouldBeVisibleResultSearchUbisoft() {
        search.fillText("Ubisoft office");
        search.enterSearch();
        search.clickResultUbisoftArticle();


        assertEquals("Ubisoft Poland", article.getTitleArticle());

    }

}
