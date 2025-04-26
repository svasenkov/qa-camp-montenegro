package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement usernameField = $("#username");
    private final SelenideElement passwordField = $("#password");
    private final SelenideElement submitButton = $("#submitButton");
    private final SelenideElement usernameError = $("#usernameError");
    private final SelenideElement passwordError = $("#passwordError");
    private final SelenideElement authError = $("#authError");
    private final SelenideElement loginContainer = $("#loginContainer");
    private final SelenideElement welcomeHeader = $("h1");

    public LoginPage setUsername(String username) {
        usernameField.setValue(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordField.setValue(password);
        return this;
    }

    public LoginPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public LoginPage login(String username, String password) {
        return setUsername(username)
                .setPassword(password)
                .clickSubmit();
    }

    public LoginPage verifyUsernameError(String expectedError) {
        usernameError.shouldBe(visible)
                .shouldHave(text(expectedError));
        return this;
    }

    public LoginPage verifyPasswordError(String expectedError) {
        passwordError.shouldBe(visible)
                .shouldHave(text(expectedError));
        return this;
    }

    public LoginPage verifyAuthError(String expectedError) {
        authError.shouldBe(visible)
                .shouldHave(text(expectedError));
        return this;
    }

    public LoginPage verifyLoginPageIsVisible() {
        loginContainer.shouldBe(visible);
        welcomeHeader.shouldHave(text("Welcome Back"));
        return this;
    }

    public SelenideElement getUsernameError() {
        return usernameError;
    }

    public SelenideElement getPasswordError() {
        return passwordError;
    }

    public SelenideElement getAuthError() {
        return authError;
    }
} 