package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class pageSetup {

    protected WebDriver driver;

    public pageSetup(WebDriver driver){
        PageFactory.initElements(driver,this);

    }
}
