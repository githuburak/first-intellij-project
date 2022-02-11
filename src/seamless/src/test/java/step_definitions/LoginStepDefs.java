package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("the user logged in {string} and {string}")
    public void the_user_logged_in_and(String username, String password) {
        loginPage.login(username, password);
    }

    @When("the user click on login button")
    public void the_user_click_on_login_button() {
        loginPage.loginButton.click();
    }

    @Then("the user should see the title {string}")
    public void the_user_should_see_the_title(String expextedTitle) {
        String actaulTitle = Driver.get().getTitle();
        Assert.assertEquals("Title not match",expextedTitle,actaulTitle);
    }

    @Then("the user click on the user's avatar in the upper right corner of the page")
    public void the_user_click_on_the_user_s_avatar_in_the_upper_right_corner_of_the_page() {
        loginPage.avatarButton.click();
    }

    @Then("the user should see the username in dropdown {string}")
    public void the_user_should_see_the_username_in_dropdown(String expectedUsername) {
        String actualUsername = loginPage.avatarUsername.getText();
        Assert.assertEquals("Avatar not match",expectedUsername,actualUsername);
    }

    @Then("the user should see the wrong message {string}")
    public void theUserShouldSeeTheWrongMessage(String expectedMessage) {
        String actualMessage = loginPage.wrongMessage.getText();
        Assert.assertEquals("wrong message not match",expectedMessage,actualMessage);

    }

    @Then("the user should see the Fill out message {string}")
    public void theUserShouldSeeTheFillOutMessage(String expectedMessage) {
        String actualMessage = "";

        if(loginPage.userNameBox.getAttribute("value").isBlank()) {
            actualMessage = loginPage.userNameBox.getAttribute("validationMessage");
        }else if(loginPage.passwordBox.getAttribute("value").isBlank()){
            actualMessage = loginPage.passwordBox.getAttribute("validationMessage");
        }
        Assert.assertEquals("wrong message not match",expectedMessage,actualMessage);
    }

    @Then("the password appears in a form of dots by default")
    public void the_password_appears_in_a_form_of_dots_by_default() {
        String actualType = loginPage.passwordBox.getAttribute("type");
        Assert.assertEquals("password type not match","password",actualType);
    }

    @When("the user click on eye button in password input box")
    public void the_user_click_on_eye_button_in_password_input_box() {
        loginPage.eyeButton.click();
    }

    @Then("the password appears explicitly on password input box")
    public void the_password_appears_explicitly_on_password_input_box() {
        String actualType = loginPage.passwordBox.getAttribute("type");
        Assert.assertEquals("password type not match","text",actualType);
    }

    @And("the user should see the Forgot password? link")
    public void theUserShouldSeeTheForgotPasswordLink() {
        Assert.assertTrue(loginPage.forgotButton.isDisplayed());
    }

    @When("the user click on Forgot password? link")
    public void the_user_click_on_Forgot_password_link() {
        loginPage.forgotButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("the user should see the Reset password? button")
    public void theUserShouldSeeTheResetPasswordButton() {
        Assert.assertTrue(loginPage.resetButton.isDisplayed());
    }

    @Then("the user should see the valid placeholders on username and password fields")
    public void the_user_should_see_the_valid_placeholders_on_username_and_password_fields() {
        String actualUserNameHolder= loginPage.userNameBox.getAttribute("placeholder");
        Assert.assertEquals("UserNameHolder not match","Username or email",actualUserNameHolder);
        String actualPasswordHolder = loginPage.passwordBox.getAttribute("placeholder");
        Assert.assertEquals("PasswordHolder not match","Password",actualPasswordHolder);
    }


}