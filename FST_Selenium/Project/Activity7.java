package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Activity7 {
    private FirefoxDriver driver;

    @BeforeMethod
    public void Start() {
        driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("http://alchemy.hguy.co/orangehrm");
        WebElement userName = driver.findElement(By.id("txtUsername"));
        WebElement passWord = driver.findElement(By.id("txtPassword"));
        userName.sendKeys("orange");
        passWord.sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
    }

    @Test
    public void test1() {
        driver.findElement(By.id("menu_pim_viewDirectory")).click();
        String Header = driver.findElement(By.className("toggle tiptip")).getText();
        System.out.print(Header);
    }
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[contains(text(),'PIM')]")));


    @AfterMethod
    public void close(){

        driver.close();
    }
}