package com.seleniumheadlessautomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class multipleWindowsHandling {
    public static EventFiringWebDriver driver;
    public static void main (String []args){

        String url = "https://www.seleniumeasy.com/test/window-popup-modal-demo.html";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        EventFiringWebDriver driver = new EventFiringWebDriver(new ChromeDriver(options));
        eventReporter reporter = new eventReporter();
        driver.register(reporter);

        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String parenrWindowTitle = driver.getTitle();
        driver.findElement(By.cssSelector("[title='Follow @seleniumeasy on Facebook']")).click();
        Set<String> windowhandles = driver.getWindowHandles();
        Iterator<String> iterator = windowhandles.iterator();
        String parentWindow = iterator.next();
        String nextWindow = iterator.next();

        driver.switchTo().window(nextWindow);
        String nextWindowTitle = driver.getTitle();

        System.out.println("Switched from webpage titled ["+parenrWindowTitle+"] To ["+nextWindowTitle+"]");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("._4jy1._3obb")).click();
        System.out.println("Currently in webpage titled "+driver.getTitle());
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#loginbutton")).click();
        driver.switchTo().window(parentWindow);
        System.out.println("Back to webpage "+ driver.getTitle());

        driver.quit();


    }
}
