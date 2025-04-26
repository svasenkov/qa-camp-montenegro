import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;

@Epic("Authentication")
@Feature("Login Functionality")
@Story("User Authentication")
public class LoginTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @Test
    @DisplayName("Should successfully login with valid credentials")
    @Description("Test successful login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    void successfulLogin() {
        open("/login.html");
        loginPage.login("admin", "admin123")
                .verifyLoginPageIsVisible();
        dashboardPage.verifyDashboardIsVisible();
    }

    @Test
    @DisplayName("Should show error when logging in with incorrect password")
    @Description("Test login failure with incorrect password")
    @Severity(SeverityLevel.NORMAL)
    void failedLoginWithWrongPassword() {
        open("/login.html");
        loginPage.login("admin", "wrongpassword")
                .verifyAuthError("Invalid username or password");
    }

    @Test
    @DisplayName("Should show validation errors for empty credentials")
    @Description("Test validation of empty credentials")
    @Severity(SeverityLevel.NORMAL)
    void loginWithEmptyCredentials() {
        open("/login.html");
        loginPage.clickSubmit()
                .verifyUsernameError("Username is required")
                .verifyPasswordError("Password is required");
    }

    @Test
    @DisplayName("Should successfully complete login and logout flow")
    @Description("Test complete login and logout flow")
    @Severity(SeverityLevel.CRITICAL)
    void logoutFunctionality() {
        open("/login.html");
        // Login first
        loginPage.login("admin", "admin123");
        dashboardPage.verifyDashboardIsVisible()
                .clickLogout();
        
        // Verify we're back at login page
        loginPage.verifyLoginPageIsVisible();
    }
} 