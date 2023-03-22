package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPagePOM;
import pages.LoginPagePageFactoryModel;
import utils.ConfigReader;
import utils.Driver;

public class LoginTests extends TestBase{

    @Test(groups = {"smoke"})
    public void positiveLogin(){
        LoginPagePOM loginPage = new LoginPagePOM();
        loginPage.enterUsername(ConfigReader.getProperty("username"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals( Driver.getDriver().getTitle(), "Web Orders");

    }


@Test(groups = {"smoke"})
    public void negativeLogin(){
    LoginPagePageFactoryModel pageFactory = new LoginPagePageFactoryModel();
   pageFactory.enterUsername(ConfigReader.getProperty(""));
    pageFactory.enterPassword(ConfigReader.getProperty("gkfjgdk"));
    pageFactory.clickLoginButton();
    Assert.assertNotEquals( Driver.getDriver().getTitle(), "Web Orders");


    }

    @Test
    public void negativeLogin2(){

        LoginPagePOM loginPage = new LoginPagePOM();
        loginPage.enterUsername(ConfigReader.getProperty(""));
        loginPage.enterPassword(ConfigReader.getProperty(""));
        loginPage.clickLoginButton();
        Assert.assertNotEquals( Driver.getDriver().getTitle(), "Web Orders");


    }
}
