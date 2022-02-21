package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceBookPage {

    WebDriver driver;

    public FaceBookPage(WebDriver driver){

        this.driver=driver;

        PageFactory.initElements(driver, this);

    }
    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(id = "pass")
    public WebElement passwortTextBox;

    @FindBy(xpath = "//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']")
    public  WebElement loginButton;

    @FindBy(xpath = "//button[@class='_42ft _4jy0 _9xo7 _4jy3 _4jy1 selected _51sy']")
    public WebElement erlaub;
}
