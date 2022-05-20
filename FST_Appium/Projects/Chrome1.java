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
import java.util.List;

public class Chrome1 {

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

    @Test
    public void test()
    {
        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"To-Do List\"))")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className("android.view.View")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id("tasksCard")));
        String Taskstoadd [] =
                {"Task1","Task2","Task3"
                };

        for(String Tasktoadd : Taskstoadd)
        {
            driver.findElement(MobileBy.id("taskInput")).sendKeys(Tasktoadd);
            driver.findElement(MobileBy.xpath("//android.view.View/android.view.View[1][contains(@text,'Add Task')]")).click();

        }
        List<MobileElement> tasklist = driver.findElementsById("tasksList");
        for(MobileElement element: tasklist)
        {
            System.out.println("The No of Tasks are:"+ element.getSize());
            driver.findElement(MobileBy.id("tasksList")).click();
        }
        driver.findElement(MobileBy.className("android.widget.TextView"));
        List<MobileElement> tasklist1 = driver.findElements(MobileBy.id("tasksList"));
        Assert.assertEquals("TC Passed!",0, String.valueOf(tasklist1.size()));
        Assert.assertEquals("TC Failed!",1, String.valueOf(tasklist1.size()));



    }
    @AfterClass
    public void afterclass()
    {
        driver.quit();
    }
}