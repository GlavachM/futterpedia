package de.futterpedia;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FunctionalTest {
    protected  WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser)throws Exception{
        if(browser.equalsIgnoreCase("firefox")){
           driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/Java/driver/chromedriver.exe");
            driver = new ChromeDriver();
        }
//        else if(browser.equalsIgnoreCase("Edge")){
//            System.setProperty("webdriver.edge.driver","C:/Java/driver/MicrosoftWebDriver.exe");
//            driver = new EdgeDriver();
//        }
        else{
            throw new Exception("Browser is not correct");
        }
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       }

    @AfterTest
    public void tearDown(){
        driver.close();

    }

}