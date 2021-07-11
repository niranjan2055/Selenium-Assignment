package com.seleniumheadlessautomation;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//This class uses java script executer to check if the page is scrollable or not

public class jsExecuter {

    public static void main(String[] args){

        String url = "https://www.google.com";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
        //comenting line 24 makes the page unscrollable
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("JavaScript is fun to learn"+ Keys.ENTER);
        JavascriptExecutor jsExe = (JavascriptExecutor) driver;
        jsExe.executeScript("window.scrollTo(0,0)");

        long scrollHeight = (long) jsExe.executeScript("return document.documentElement.scrollHeight");
        long clientHeight = (long) jsExe.executeScript("return document.documentElement.clientHeight");

        //Checking if scrollBar is present or not
        if(scrollHeight>clientHeight){
            System.out.println("Page is scrollable");

           }
        else {
            System.out.println("Page is not Scrollable");
        }

       }




    }
