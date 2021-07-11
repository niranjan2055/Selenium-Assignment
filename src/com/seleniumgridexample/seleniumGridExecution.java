package com.seleniumgridexample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

//Fetches data from table and print in console
public class seleniumGridExecution {
     public static WebDriver driver;
    public static void main(String[] args) throws MalformedURLException {
        String webpage = "https://www.seleniumeasy.com/test/table-pagination-demo.html";
        WebDriverManager.chromedriver().setup();
        String remoteNode = "http://192.168.0.114:4444/wd/hub";
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.MAC);
        driver = new RemoteWebDriver((new URL(remoteNode)),dc);
        driver.get(webpage);

        List<WebElement> rows = driver.findElements(By.cssSelector("#myTable > tr:nth-child(n)"));
        int rowSize = rows.size();

        List<WebElement> column = driver.findElements(By.xpath("//*[@id=\"myTable\"]/tr[1]/td"));
        int columnSize = column.size();

        for (int i=1;i<=rowSize;i++){
            for (int j=1;j<=columnSize;j++)
            {
                if (i==5){
                    driver.findElement(By.xpath("//a[.='2']")).click();
                }
                if(i==10)
                {
                    driver.findElement(By.xpath("//a[.='3']")).click();
                }
                String text = driver.findElement(By.xpath("//*[@id=\"myTable\"]/tr["+i+"]/td["+j+"]")).getText();
                System.out.println(text);
            }
        }




    }

}
