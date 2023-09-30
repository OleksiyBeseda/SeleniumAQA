package selenium.builder;

import selenium.po.LoginPage;

public class LoginPageBuilder {

    private String username;
    private String password;

    public LoginPageBuilder withUsername(String username) {
        this.username = username;
        return this;
    }

    public LoginPageBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public LoginPage build() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        return loginPage;
    }
}
