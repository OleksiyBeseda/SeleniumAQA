package selenide.po;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.actions;

public class ActionsPage {

    private final SelenideElement doubleClickButton = $x("//button[@id='doubleClickBtn']");
    private final SelenideElement contextClickButton = $x("//button[@id='rightClickBtn']");
    private final SelenideElement dragArea = $x("//div[@id='draggable']");
    private final SelenideElement dropArea = $x("//div[@id='draggable']/following-sibling::div");

    public SelenideElement dropped() {
        return $x("//div[@id='draggable']/following-sibling::div/p");
    }
    public SelenideElement getDoubleClickText() {
        return $x("//p[@id='doubleClickMessage']");
    }
    public SelenideElement getContextClickButton() {
        return $x("//p[@id='rightClickMessage']");
    }
    public ActionsPage clickDoubleClick() {
        doubleClickButton.shouldBe(visible, enabled).doubleClick();
        return page(ActionsPage.class);
    }
    public ActionsPage clickContextClick() {
        contextClickButton.shouldBe(visible, enabled).contextClick();
        return page(ActionsPage.class);
    }
    public ActionsPage dragAndDropElement() {
        actions().dragAndDrop(dragArea.shouldBe(visible), dropArea.shouldBe(visible)).build().perform();
        return page(ActionsPage.class);
    }

}
