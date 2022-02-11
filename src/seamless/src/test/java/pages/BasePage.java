package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//div[@id='expand']/div[1]/img")
    public WebElement avatarButton;

    @FindBy(xpath = "//div[@class='user-status-menu-item']/span")
    public WebElement avatarUsername;

    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//p[contains(.,'password')]")
    public WebElement wrongMessage;

    public void navigateToThreeDots(String name){
        Driver.get().findElement(By.xpath("//span[.='"+name+"']//..//..//span[@class='fileactions']/a[2]/span[1]")).click();
    }

    public void threeDotDropdown(String name){
        Driver.get().findElement(By.xpath("//a[contains(.,'"+name+"')]")).click();
    }

    public void navigateToLeftTab(String name){
        Driver.get().findElement(By.xpath("//a[contains(.,'"+name+"')]")).click();
    }

}