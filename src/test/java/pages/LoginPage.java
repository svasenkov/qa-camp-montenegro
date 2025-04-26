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

    public void setUsername(String username) {
        usernameField.setValue(username);
    }

    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickSubmit();
    }

    public void verifyUsernameError(String expectedError) {
        usernameError.shouldBe(visible)
                .shouldHave(text(expectedError));
    }

    public void verifyPasswordError(String expectedError) {
        passwordError.shouldBe(visible)
                .shouldHave(text(expectedError));
    }

    public void verifyAuthError(String expectedError) {
        authError.shouldBe(visible)
                .shouldHave(text(expectedError));
    }

    public void verifyLoginPageIsVisible() {
        loginContainer.shouldBe(visible);
        welcomeHeader.shouldHave(text("Welcome Back"));
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