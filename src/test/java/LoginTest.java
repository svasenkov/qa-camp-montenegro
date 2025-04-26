import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "file://" + System.getProperty("user.dir");
    }

    @Test
    void successfulLogin() {
        open("/login.html");
        $("#username").setValue("admin");
        $("#password").setValue("admin123");
        $("#submitButton").click();
        
        $("#dashboardContainer").shouldBe(visible);
        $(".dashboard-header h1").shouldHave(text("Dashboard"));
    }

    @Test
    void failedLoginWithWrongPassword() {
        open("/login.html");
        $("#username").setValue("admin");
        $("#password").setValue("wrongpassword");
        $("#submitButton").click();
        
        $("#authError").shouldBe(visible)
                .shouldHave(text("Invalid username or password"));
    }

    @Test
    void loginWithEmptyCredentials() {
        open("/login.html");
        $("#submitButton").click();
        
        $("#usernameError").shouldBe(visible)
                .shouldHave(text("Username is required"));
        $("#passwordError").shouldBe(visible)
                .shouldHave(text("Password is required"));
    }

    @Test
    void logoutFunctionality() {
        open("/login.html");
        // Login first
        $("#username").setValue("admin");
        $("#password").setValue("admin123");
        $("#submitButton").click();
        
        // Then logout
        $("#logoutButton").click();
        
        // Verify we're back at login page
        $("#loginContainer").shouldBe(visible);
        $("h1").shouldHave(text("Welcome Back"));
    }
} 