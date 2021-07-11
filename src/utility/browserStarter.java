package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class browserStarter {
    private WebDriver driver;
    propertyReader prop = new propertyReader();
    public WebDriver getBrowserInstance(){

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");

        if (prop.getConfig("browser").equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
//            driver = new ChromeDriver(options);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } else if (prop.getConfig("browser").equals("FireFox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        else {
            System.out.println("Browser defined except chrome and firefox \n");
        }

        return driver;
    }

}
