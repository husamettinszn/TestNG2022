package com.tests;

import com.pages.FaceBookPage;
import com.utilities.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FaceBookPOM extends TestBase {

    @Test
    public void login() throws InterruptedException {
        driver.get("https://facebook.com");
        //Thread.sleep(2000);

        FaceBookPage faceBookPage = new FaceBookPage(driver);
        faceBookPage.erlaub.click();
        faceBookPage.emailTextBox.sendKeys("husjs@gmail.com");
        faceBookPage.passwortTextBox.sendKeys("123");
        faceBookPage.loginButton.click();
    }
}
