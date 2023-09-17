package po;

import base.BaseMethod;
import org.openqa.selenium.By;

public class LoginPage extends BaseMethod  {

    private final By loginButton = By.xpath("//span[text()='Войти']");
    private final By usernameField = By.xpath("//input[@name='wpName']");
    private final By passwordField = By.xpath("//input[@name='wpPassword']");
    private final By enterButton = By.xpath("//button[@name='wploginattempt']");
    private final By actualNickname = By.xpath("//a[@title='Ваша домашняя страница [alt-shift-.]']/span");

    public void clickLoginButton() {
        click(loginButton, 10);
    }
    public void enterUsername(String text) {
        send(usernameField, text);
    }
    public void enterPassword(String text) {
        send(passwordField, text);
    }
    public void clickEnterButton() {
        click(enterButton, 10);
    }
    public String getActualNickname() {
        return getTextFromElement(actualNickname);
    }


}
