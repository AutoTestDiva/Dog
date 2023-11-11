package org.nat.dog.pages;

import org.nat.dog.pages.about.AboutPage;
import org.nat.dog.pages.clinics.ClinicsPage;
import org.nat.dog.pages.kennels.KennelsPage;
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




    @FindBy(css="#name-input[name='firstName']")
    WebElement firstNameField;
    @FindBy(css="#name-input[name='lastName']")
    WebElement lastNameField;
    @FindBy(css="#name-input[name='userName']")
    WebElement usernameField;
    @FindBy(css="#name-input[name='city']")
    WebElement cityField;
    @FindBy(css="#name-input[name='zip']")
    WebElement zipField;
    @FindBy(css="#name-input[name='username']")
    WebElement emailField;
    @FindBy(css="#password-input[name='password']")
    WebElement passwordField;
    @FindBy(css="#password-repeat-input[name='passwordRepeat']")
    WebElement repeatPasswordField;


    public HomePage enterRegistrationData(String firstName, String lastName, String username,
                                          String city, String zip, String email, String password,
                                          String repeatPassword){
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(usernameField, username);
        type(cityField, city);
        type(zipField, zip);
        type(emailField, email);
        type(passwordField, password);
        type(repeatPasswordField, repeatPassword);
        return this;
    }

    //залогинивание
    @FindBy(xpath = "//button[contains(text(),'Log In')]")
    WebElement loginLink;
    public HomePage getLoginLink() {
        click(loginLink);
        return this;
    }

    @FindBy(css="#name-input[name='username']")
    WebElement userLoginField;
     public HomePage enterLoginData(String username, String password){
        type(userLoginField, username);
        type(passwordField, password);
        return this;
    }

    @FindBy(css="[type='submit']")
    WebElement submitFormButton;
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


    @FindBy(css = ".form-check-input")
    WebElement clickOnCheckBoxInRegistrationForm;
    public HomePage clickOnCheckBox() {
        click(clickOnCheckBoxInRegistrationForm);
        return this;
    }

    @FindBy(xpath="//button[@type='submit']")
    WebElement submitInRegistrationFormButton;
    public HomePage submitInRegistrationForm() {
        click(submitInRegistrationFormButton);
        return this;
    }

    @FindBy(css = ".invalid-feedback.mb-3")
    WebElement wrongUserName;
    public void warningWrongUserName(String textAboutMistake) {
        Assert.assertTrue(shouldHaveText(wrongUserName, textAboutMistake, 10));
    }


    @FindBy(css = ".invalid-feedback.mb-3")
    WebElement wrongEmail;
    public void warningWrongEmail(String textAboutMistake) {
        Assert.assertTrue(shouldHaveText(wrongEmail, textAboutMistake, 10));
    }


    @FindBy(xpath = "//a[contains(text(),'Clinics')]")
    WebElement clinicsLink;

    public ClinicsPage getClinics() {
        click(clinicsLink);
        return new ClinicsPage(driver);

    }

    @FindBy(xpath = "//a[contains(text(),'Kennels')]")
    WebElement kennelsLink;

    public KennelsPage getKennels() {
        click(kennelsLink);
        return new KennelsPage(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'About')]")
    WebElement aboutLink;
    public AboutPage getAbout() {
        click(aboutLink);
        return new AboutPage(driver);
    }
}

