package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    // this class uses Singlerton Design pattern -> guarantee that all the test will run in the same browser

    private static WebDriver driver;

    private Driver(){}


    public static WebDriver getDriver() {

        String browser = ConfigReader.getProperty("browser");

        if(driver == null) {// check if the driver is initialized
            // if not initialize using the value from properties file

            switch (browser) {
                case "chrome":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    WebDriver driver = new ChromeDriver(options);
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Unsupported browser");


            }

        }
        return driver;// if already initialized previously, return this initialized object
    }


    public static void quitDriver() {

        if(driver!= null){//meaning it is active
            driver.quit();
            driver = null;
        }


    }
}
