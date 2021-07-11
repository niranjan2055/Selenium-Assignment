package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.browserStarter;
import utility.propertyReader;
import utility.testDataReader;

@Test
public class multipleFramesTest {
    WebDriver driver;
    @Test
    public void multipleFramesTest() {

        String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_button_test";

        propertyReader prop = new propertyReader();
        testDataReader testData = new testDataReader();
        browserStarter browser = new browserStarter();
        driver = browser.getBrowserInstance();
        driver.get(url);
        int numberOfFrames = driver.findElements(By.tagName("iframe")).size();
        System.out.println("Total Number Of iFrame available "+numberOfFrames);
        driver.switchTo().frame("iframeResult");
        System.out.println(driver.getTitle());
        WebElement clickMEBtn = driver.findElement(By.xpath("//button[.='Click Me!']"));
        clickMEBtn.click();
        String alert = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        driver.switchTo().parentFrame();
        Assert.assertEquals(alert,"Hello world!");
        driver.quit();
    }
    }
