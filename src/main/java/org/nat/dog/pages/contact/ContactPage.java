package org.nat.dog.pages.contact;

import org.nat.dog.pages.BasePage;
import org.nat.dog.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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


    }


