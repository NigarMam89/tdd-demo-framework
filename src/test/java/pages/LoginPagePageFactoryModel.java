package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

public class LoginPagePageFactoryModel {

    // THIS CONSTRUCTOR IS A MUST -> standart script
    public LoginPagePageFactoryModel(){
        PageFactory.initElements(Driver.getDriver(),this);//initialized everything that has @FindBy annotation
    }


@FindBy(name = "ctl00$MainContent$username")
        private WebElement username;
@FindBy(name = "ct100$MainContent$password")
        private WebElement password;
@FindBy(className = "button")
        private WebElement button;




    public void enterUsername(String username) {
        this.username.sendKeys(username);
    }


    public void enterPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
                button.click();
    }


    public void login(){
    this.username.sendKeys(ConfigReader.getProperty("username"));
        this.password.sendKeys(ConfigReader.getProperty("password"));
        this.button.click();

    }
}


