package com.pom;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.browserStarter;
import utility.propertyReader;
import utility.testDataReader;

import java.util.concurrent.TimeUnit;

@Test
public class signUpTest {
    WebDriver driver;
    @Test
    public void signupTest(){
        propertyReader prop = new propertyReader();
        testDataReader testData = new testDataReader();
        browserStarter browser = new browserStarter();
        driver = browser.getBrowserInstance();
        driver.get(prop.getConfig("url"));
        driver.manage().window().maximize();
        driver.findElement(By.partialLinkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys(testData.getValue("newEmail"));
        driver.findElement(By.id("passwd")).sendKeys(testData.getValue("password"));
        driver.findElement(By.cssSelector("i.icon-lock")).click();
        Assert.assertEquals(driver.getTitle(),"My account - My Store");
        driver.close();
    }
}
