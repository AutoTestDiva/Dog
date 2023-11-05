package org.nat.dog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage {

    //идентификация элемента на главной странице
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/img[1]")
    WebElement firstPicture;
    public boolean isHomeComponentPresent() {
        return firstPicture.isDisplayed();
    }

    //залогинивание
    @FindBy(xpath = "//button[contains(text(),'Log In')]")
    WebElement loginLink;
    public HomePage getLoginLink() {
        click(loginLink);
        return this;
    }
    @FindBy(id="validationCustom04")
    WebElement emailField;
    @FindBy(id="Form.Password")
    WebElement passwordField;
    @FindBy(css="[type='submit']")
    WebElement submitFormButton;
     public HomePage enterLoginData(String email, String password){
        type(emailField, email);
        type(passwordField, password);
        return this;
    }
    public HomePage submit() {
        click(submitFormButton);
        return this;
    }
    @FindBy(xpath = "//button[contains(text(),'Log In')]") //потом поменять локатор на Logout
    WebElement logoutLink;
    public HomePage verifyLogout(String logout){
        Assert.assertTrue(shouldHaveText(logoutLink, logout, 10));
        return this;
    }

// регистрация
    @FindBy(xpath = "//button[contains(text(),'Registration')]") //потом поменять локатор на Registered
    WebElement registrationLink;
    public HomePage getRegistrationLink() {
        click(registrationLink);
        return this;
    }
    @FindBy(id="validationCustom01")
    WebElement firstNameField;
    @FindBy(id="validationCustom02")
    WebElement lastNameField;
    @FindBy(id="validationCustomUsername")
    WebElement usernameField;
    @FindBy(id="validationCustom03")
    WebElement cityField;
    @FindBy(id="validationCustom05")
    WebElement zipField;
    public HomePage enterRegistrationData(String firstName, String lastName, String username,
                                          String city, String zip, String email, String password){
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(usernameField, username);
        type(cityField, city);
        type(zipField, zip);
        type(emailField, email);
        type(passwordField, password);
        return this;
    }

    @FindBy(css = ".form-check-input")
    WebElement clickOnCheckBoxInRegistrationForm;
    public HomePage clickOnCheckBox() {
        click(clickOnCheckBoxInRegistrationForm);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Submit form')]")
    WebElement submitInRegistrationFormButton;
    public HomePage submitInRegistrationForm() {
        click(submitInRegistrationFormButton);
        return this;
    }
}

