package examples;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.* ;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;

public class Example {

    //Driver declare
     AndroidDriver<MobileElement> driver;

     //Setup
    @BeforeClass
    public void setUp() throws MalformedURLException {

        DesiredCapabilities des = new DesiredCapabilities();
        des.setCapability("platformName", "android");
        des.setCapability("automationName", "UiAutomator2");
        des.setCapability("deviceId", "RFCR91FY8LN");
        des.setCapability("appActivity", ".Calculator");
        des.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        des.setCapability("noReset", true);

        //Appium Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //driver
        driver = new AndroidDriver<MobileElement>(serverURL, des);
    }

    @Test
    public void Add(){



    }

}
