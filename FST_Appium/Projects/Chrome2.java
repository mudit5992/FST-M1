package examples;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Chrome2 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("platformName", "android");
        des.setCapability("automationName", "UiAutomator2");
        des.setCapability("deviceId", "RFCR91FY8LN");
        //des.setCapability("appActivity", ".Calculator");
        //des.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        des.setCapability("noReset", true);
        des.setCapability("appPackage", "com.android.chrome");
        des.setCapability("appActivity", "com.google.android.apps.chrome.Main");

        //Appium Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //wait = new WebDriverWait(driver, 10);
        //driver
        driver = new AndroidDriver<MobileElement>(serverURL, des);
    }

    @Test(priority= 1)
    public void validcredentails()
    {

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View/android.widget.Button[contains(@text,'Log in')]")));

        driver.findElement(MobileBy.xpath("//android.view.View/android.widget.EditText[1]")).sendKeys("admin");
        driver.findElement(MobileBy.xpath("//android.view.View/android.widget.EditText[2]")).sendKeys("password");

        driver.findElement(MobileBy.xpath("//android.view.View/android.widget.Button[contains(@text,'Log in')]")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.widget.TextView[4][contains(@text,'Welcome Back, admin')]"), "Welcome Back, admin"));
        String LoginMessage=driver.findElement(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.widget.TextView[4][contains(@text,'Welcome Back, admin')]")).getText();
        Assert.assertEquals("Welcome Back, admin", LoginMessage);




    }


    @Test (priority= 2)
    public void invalidcredentails()
    {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View/android.widget.Button[contains(@text,'Log in')]")));
        driver.findElement(MobileBy.xpath("//android.view.View/android.widget.EditText[1]")).sendKeys("admin123");
        driver.findElement(MobileBy.xpath("//android.view.View/android.widget.EditText[2]")).sendKeys("password123");
        driver.findElement(MobileBy.xpath("//android.view.View/android.widget.Button[contains(@text,'Log in')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.widget.TextView[4][contains(@text,'Invalid Credentials')]")));
        String Message=driver.findElement(MobileBy.xpath("//android.webkit.WebView/android.view.View/android.widget.TextView[4][contains(@text,'Invalid Credentials')]")).getText();
        Assert.assertEquals("Invalid Credentials", Message);


    }



    @AfterClass
    public void afterclass()
    {
        driver.quit();
    }
}