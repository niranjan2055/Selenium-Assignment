package com.pom;

import org.openqa.selenium.WebDriver;
import utility.browserStarter;
import utility.propertyReader;
import utility.testDataReader;

public class signUpAutomation {
        public static WebDriver driver;
        public static  void main(String[] args) {

            propertyReader prop = new propertyReader();
            testDataReader testData = new testDataReader();
            browserStarter browser = new browserStarter();
            driver = browser.getBrowserInstance();
            driver.get(prop.getConfig("url"));

            com.pom.signUp newUsr = new com.pom.signUp(driver);

            newUsr.clickLogin();
            newUsr.setNewEmail(testData.getValue("newEmail"));
            newUsr.clickSubmit();
            newUsr.setGender();
            newUsr.setFirstName(testData.getValue("firstName"));
            newUsr.setLastName(testData.getValue("lastName"));
            newUsr.setPassword(testData.getValue("password"));
            newUsr.selectDOB();
            newUsr.checkNewsletter();
            newUsr.setCompanyName(testData.getValue("companyName"));
            newUsr.setAddress(testData.getValue("address"));
            newUsr.setCity(testData.getValue("cityName"));
            newUsr.selectState(testData.getValue("state"));
            newUsr.setPostCode(testData.getValue("postalCode"));
            newUsr.selectCountry();
            newUsr.setMobileNumber(testData.getValue("phoneNum"));
            newUsr.extraBox();
            newUsr.clickSubmitAcc();
            driver.quit();
            System.out.println("Account Created!");


        }

 }

