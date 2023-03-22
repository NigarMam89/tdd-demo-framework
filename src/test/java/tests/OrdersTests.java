package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.LoginPagePageFactoryModel;
import utils.ConfigReader;
import utils.Driver;
import utils.SeleniumUtils;

public class OrdersTests extends TestBase{



@Test(groups = {"smoke"})
    public void deleteSelectedButton(){


//        Driver.getDriver().findElement(By.name("ctl00$MainContent$username")).sendKeys(ConfigReader.getProperty("username"));
//        Driver.getDriver().findElement(By.name("ctl00$MainContent$password")).sendKeys(ConfigReader.getProperty("password"));
//        Driver.getDriver().findElement(By.className("button")).click();
//
//        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
//        Driver.getDriver().findElement(By.name("ctl00$MainContent$btnDelete")).click();
//
//        Assert.assertTrue(Driver.getDriver().getPageSource().contains("List of orders is empty."));


        LoginPagePageFactoryModel loginPage = new LoginPagePageFactoryModel();
        loginPage.enterPassword(ConfigReader.getProperty("username"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.clickLoginButton();

        AllOrdersPage allOrdersPage = new AllOrdersPage();

        allOrdersPage.clickCheckAll();
        allOrdersPage.clickDeleteSelected();


        Assert.assertTrue(allOrdersPage.getMessage().isDisplayed());



    }





    }

