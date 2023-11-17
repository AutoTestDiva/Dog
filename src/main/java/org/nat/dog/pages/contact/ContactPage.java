package org.nat.dog.pages.contact;

import org.nat.dog.pages.BasePage;
import org.nat.dog.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ContactPage extends BasePage {
    public ContactPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(tagName= "iframe")
    List<WebElement> iframes;

    public ContactPage returnListOfFrames() {
        System.out.println("The total numbers of iframes: " + iframes.size());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Integer numberOfIframes = Integer.parseInt(js.executeScript("return window.length"). toString());
        System.out.println("The total numbers of items: " + numberOfIframes);
        return this;
    }


    @FindBy(name= "name")
    WebElement userNameContactField;
    @FindBy(name="email")
    WebElement userEmailContactField;
    @FindBy(id= "message")
    WebElement messageContactField;

    public ContactPage enterUserData(String userNameForContactForm, String userEmailForContactForm,
                                     String messageForContactForm) {
        //Прокрутка элемента в видимую область
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", userNameContactField);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        type(userNameContactField,userNameForContactForm);
        click(userEmailContactField);
        type(userEmailContactField,userEmailForContactForm);
        click(messageContactField);
        type(messageContactField,messageForContactForm);
        return this;
    }

    @FindBy(css= "._btn_104v1_86")
    WebElement sendMessage;
    public ContactPage sendMessageButton() {
        click(sendMessage);
        return null;
    }
}


