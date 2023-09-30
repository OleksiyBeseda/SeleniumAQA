package selenide.po;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static selenide.js.JSActions.click;

public class LoginPage {

    private final SelenideElement loginButton = $x("//span[text()='Войти']");
    private final SelenideElement usernameField = $x("//input[@name='wpName']");
    private final SelenideElement passwordField = $x("//input[@name='wpPassword']");
    private final SelenideElement enterButton = $x("//button[@name='wploginattempt']");
    private final SelenideElement actualNickname = $x("//a[@title='Ваша домашняя страница [alt-shift-.]']/span");
    private final SelenideElement login = $x("//li[@id='pt-login']");


    public LoginPage clickLogin() {
        login.shouldBe(visible, enabled);
        click(login);
        return page(LoginPage.class);
    }

    public LoginPage clickLoginButton() {
        loginButton.shouldBe(visible, enabled);
        click(loginButton);
        return page(LoginPage.class);
    }

    public LoginPage fillUsername(String text) {
        usernameField.shouldBe(visible).sendKeys(text);
        return page(LoginPage.class);
    }

    public LoginPage enterPassword(String text) {
        passwordField.shouldBe(visible).sendKeys(text);
        return page(LoginPage.class);
    }

    public LoginPage clickEnterButton() {
        enterButton.shouldBe(visible, enabled);
        click(enterButton);
        return page(LoginPage.class);
    }

    public LoginPage getActualNickname(String text) {
        actualNickname.shouldBe(visible).sendKeys(text);
        return page(LoginPage.class).clickLogin();
    }

}