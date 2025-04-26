package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class DashboardPage {
    private final SelenideElement dashboardContainer = $("#dashboardContainer");
    private final SelenideElement dashboardHeader = $(".dashboard-header h1");
    private final SelenideElement logoutButton = $("#logoutButton");

    public DashboardPage verifyDashboardIsVisible() {
        dashboardContainer.shouldBe(visible);
        dashboardHeader.shouldHave(text("Dashboard"));
        return this;
    }

    public SelenideElement getDashboardContainer() {
        return dashboardContainer;
    }

    public SelenideElement getDashboardHeader() {
        return dashboardHeader;
    }

    public DashboardPage clickLogout() {
        logoutButton.click();
        return this;
    }
} 