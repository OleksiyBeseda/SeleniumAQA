package selenium.po;

import selenium.base.BaseMethod;
import selenium.base.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.po.util.JSActions;

public class ActionsPage extends BaseMethod {

    private final By doubleClick = By.xpath("//button[@id='doubleClickBtn']");
    private final By contextClick = By.xpath("//button[@id='rightClickBtn']");
    private final By getDoubleClickText = By.xpath("//p[@id='doubleClickMessage']");
    private final By getContextClickText = By.xpath("//p[@id='rightClickMessage']");
    private final By drag = By.xpath("//div[@id='draggable']");
    private final By drop = By.xpath("//div[@id='draggable']/following-sibling::div");
    private final By result = By.xpath("//div[@id='draggable']/following-sibling::div/p");
    private final By callAlert = By.xpath("//button[@id='alertButton']");
    private final By confirm = By.xpath("//button[@id='confirmButton']");
    private final By prompt = By.xpath("//button[@id='promtButton']");
    private final By textFromFrame = By.xpath("/html/body/p");
    private final By framesHeader = By.xpath("//iframe[@id='frame1']");
    private final By paragraph = By.xpath("//iframe[@id='frame1']//p");
    private final By upload = By.xpath("//input[@id='uploadFile']");
    private final By table = By.xpath("//div[@class='rt-tbody']");

    public String framesParagraph() {
        return getTextFromElement(paragraph);
    }
    public String getTextFromTable(int row, int column) {
        WebElement tableTap = getWait().until(d -> d.findElement(table));
        Table table1 = new Table(tableTap);
        return table1.getValue(row -1, column);
    }
    public ActionsPage uploadFile(String path) {
        send(upload, path);
        return this;
    }

    public String framesHeader() {
        return getTextFromElement(framesHeader);
    }
    public String getTextNestedFrame() {
        return getTextFromElement(textFromFrame);
    }

    public ActionsPage promptAlert() {
        WebElement element = getWait().until(d -> d.findElement(prompt));
        JSActions.jsClick(element);
        return this;
    }
    public ActionsPage callConfirmAlert() {
        click(confirm, 10);
        return this;
    }
    public ActionsPage callAlert() {
        click(callAlert, 10);
        return this;
    }
    public ActionsPage dragAndDropEelment() {
        dragAndDrop(drag, drop);
        return this;
    }
    public String getDropped() {
        return getTextFromElement(result);
    }
    public ActionsPage clickDoubleClick() {
        doubleClick(doubleClick);
        return this;
    }
    public ActionsPage clickRightClick() {
        contextClick(contextClick);
        return this;
    }
    public String getDoubleText() {
        return getTextFromElement(getDoubleClickText);
    }
    public String getRightText() {
        return getTextFromElement(getContextClickText);
    }

}
