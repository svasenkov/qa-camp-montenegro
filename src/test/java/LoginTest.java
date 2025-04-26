import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;

public class LoginTest extends BaseTest {
    private final LoginPage loginPage = new LoginPage();
    private final DashboardPage dashboardPage = new DashboardPage();

    @Test
    void successfulLogin() {
        open("/login.html");
        loginPage.login("admin", "admin123");
        dashboardPage.verifyDashboardIsVisible();
    }

    @Test
    void failedLoginWithWrongPassword() {
        open("/login.html");
        loginPage.login("admin", "wrongpassword");
        loginPage.verifyAuthError("Invalid username or password");
    }

    @Test
    void loginWithEmptyCredentials() {
        open("/login.html");
        loginPage.clickSubmit();
        loginPage.verifyUsernameError("Username is required");
        loginPage.verifyPasswordError("Password is required");
    }

    @Test
    void logoutFunctionality() {
        open("/login.html");
        // Login first
        loginPage.login("admin", "admin123");
        dashboardPage.verifyDashboardIsVisible();
        
        // Then logout
        dashboardPage.clickLogout();
        
        // Verify we're back at login page
        loginPage.verifyLoginPageIsVisible();
    }
} 