package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.Driver;

public class LogoutStepDefs {
    LoginPage loginPage = new LoginPage();

    @When("the user click on the logout in dropdown")
    public void theUserClickOnTheLogoutInDropdown() {
        loginPage.logoutButton.click();
    }

    @When("the user click on go back button on the browser")
    public void theUserClickOnGoBackButtonOnTheBrowser() {
        Driver.get().navigate().back();
    }

    @Then("the user can NOT go back to homepage and not see the {string}")
    public void theUserCanNOTGoBackToHomepageAndNotSeeThe(String homePageTitle) {
        Assert.assertNotEquals(homePageTitle, Driver.get().getTitle());

    }
}