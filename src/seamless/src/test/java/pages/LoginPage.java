package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPage extends pages.BasePage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css="[id='user']")
    public WebElement userNameBox;

    @FindBy(css="[id='password']")
    public WebElement passwordBox;

    @FindBy(css="[id='submit-form']")
    public WebElement loginButton;

    @FindBy(css="[id='lost-password']")
    public WebElement forgotButton;

    @FindBy(css="[id='reset-password-submit']")
    public WebElement resetButton;

    @FindBy(css="[class='toggle-password']")
    public WebElement eyeButton;


    public void login(){
        userNameBox.sendKeys(ConfigurationReader.get("username"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
    }

    public void login(String username,String password){
        userNameBox.sendKeys(username);
        passwordBox.sendKeys(password);
    }

}