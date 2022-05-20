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

public class keep {
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
        des.setCapability("appPackage", "com.google.android.keep");
        des.setCapability("appActivity", ".activities.BrowseActivity");

        //Appium Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //wait = new WebDriverWait(driver, 10);
        //driver
        driver = new AndroidDriver<MobileElement>(serverURL, des);

    }

    @Test
    public void googlekeep() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
        driver.findElementById("new_note_button").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("title_editor_fragment")));
        driver.findElement(MobileBy.id("editable_title")).sendKeys("TestTitle");
        driver.findElement(MobileBy.id("edit_note_text")).sendKeys("TestNote");
        driver.findElementByAccessibilityId("Reminder").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("menu_text")));
        driver.findElementByXPath("//android.widget.TextView[Contains(@text(),'Pick a date & time')]").click();
        driver.findElementById("com.google.android.keep:id/time_spinner");
        driver.findElementByXPath("//android.widget.TextView[1][Contains(@text(),'Afternoon')]").click();
        driver.findElementById("save").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("reminder_chip")));
        MobileElement reminder = driver.findElementById("reminder_chip");
        Assert.assertEquals(reminder.isDisplayed(), true);
    }

    @AfterClass
    public void afterclass() {
        driver.quit();
    }
}