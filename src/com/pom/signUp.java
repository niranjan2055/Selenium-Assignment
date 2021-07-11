package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class signUp extends com.pom.pageSetup {
        public signUp(WebDriver driver) {
            super(driver);
            this.driver = driver;
        }

        @FindBy(className = "login")
        WebElement loginbtn;

        @FindBy(id = "email_create")
        WebElement emailfield;

        @FindBy(id = "SubmitCreate")
        WebElement SubmitBtn;

        @FindBy(id = "id_gender1")
        WebElement radiobtn;

        @FindBy(id = "customer_firstname")
        WebElement firstNameField;

        @FindBy(id = "customer_lastname")
        WebElement lastNameField;

        @FindBy(id = "passwd")
        WebElement passwdField;

        @FindBy(name = "days")
        WebElement Days;
        @FindBy(name = "months")
        WebElement Month;
        @FindBy(name = "years")
        WebElement Yr;

        @FindBy(id = "newsletter")
        WebElement newsletter ;

        @FindBy(id = "company")
        WebElement companyName;

        @FindBy(name = "address1")
        WebElement address;

        @FindBy(id = "city")
        WebElement city;

        @FindBy(id = "id_state")
        WebElement State ;

        @FindBy(id = "postcode")
        WebElement postCode;

        @FindBy(name = "id_country")
        WebElement Country;

        @FindBy(id = "phone_mobile")
        WebElement mobileNumber;

        @FindBy(id = "alias")
        WebElement alias;

        @FindBy(id = "submitAccount")
        WebElement submitAccBtn;

        public void setNewEmail(String email){
            emailfield.sendKeys(email);
        }

        public void clickSubmit(){
            SubmitBtn.click();
        }

        public void setGender(){
            radiobtn.click();
        }

        public void setFirstName(String name){
            firstNameField.sendKeys(name);
        }

        public void setLastName(String lastname){
            lastNameField.sendKeys(lastname);
        }

        public void setPassword(String pass){
            passwdField.sendKeys(pass);
        }

        public void setCompanyName(String nameOfCom) {
            companyName.sendKeys(nameOfCom);
        }

        public void checkNewsletter(){
            newsletter.click();
        }

        public void setAddress(String addr){
            address.sendKeys(addr);
        }

        public void setPostCode(String post){
            postCode.sendKeys(post);
        }

        public void clickSubmitAcc(){
            submitAccBtn.click();
        }

        public void setCity(String ctname){
            city.sendKeys(ctname);
        }

        public void selectDOB(){
            Select days = new Select(Days);
            days.selectByIndex(8);
            Select month = new Select(Month);
            month.selectByIndex(6);
            Select yr = new Select(Yr);
            yr.selectByValue("2000");
        }

        public void selectState(String text){
            Select state = new Select(State);
            state.selectByVisibleText(text);
        }

        public void selectCountry(){
            Select country = new Select(Country);
            country.selectByIndex(1);
        }

        public void clickLogin(){
            loginbtn.click();
        }

        public void  setMobileNumber(String phnum){
            mobileNumber.sendKeys(phnum);
        }

        public void extraBox(){
            alias.clear();
            alias.sendKeys("same as address");
        }

    }


