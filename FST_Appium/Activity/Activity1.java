package Activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.* ;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Activity1 {
    WebDriverWait wait;
    //Driver declare
    AndroidDriver<MobileElement> driver;

    //Setup
    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("platformName", "android");
        des.setCapability("automationName", "UiAutomator2");
        des.setCapability("deviceId", "RFCR91FY8LN");
        //des.setCapability("appActivity", ".Calculator");
        //des.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        des.setCapability("noReset", true);
        des.setCapability("appPackage", "com.google.android.apps.tasks");
        des.setCapability("appActivity", ".ui.TaskListsActivity");

        //Appium Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //wait = new WebDriverWait(driver, 10);
        //driver
        driver = new AndroidDriver<MobileElement>(serverURL, des);
    }

    @Test
    public void taskAddAppium() {

        MobileElement e = driver.findElementById("com.google.android.apps.tasks:id/tasks_fab");

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


        e.click();
        // Wait for page to load
        MobileElement f = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        f.sendKeys("Add task 1");


        MobileElement g = driver.findElementById("com.google.android.apps.tasks:id/add_task_done");
        g.click();

    }


}
