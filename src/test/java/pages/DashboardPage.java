package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private final SelenideElement dashboardContainer = $("#dashboardContainer");
    private final SelenideElement dashboardHeader = $(".dashboard-header h1");
    private final SelenideElement logoutButton = $("#logoutButton");

    public void verifyDashboardIsVisible() {
        dashboardContainer.shouldBe(visible);
        dashboardHeader.shouldHave(text("Dashboard"));
    }

    public SelenideElement getDashboardContainer() {
        return dashboardContainer;
    }

    public SelenideElement getDashboardHeader() {
        return dashboardHeader;
    }

    public void clickLogout() {
        logoutButton.click();
    }
} 