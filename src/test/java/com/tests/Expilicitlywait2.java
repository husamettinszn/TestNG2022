package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Expilicitlywait2 extends TestBase {

    @Test
    public void ubung() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        SoftAssert softAssert = new SoftAssert();

        WebElement addBton = driver.findElement(By.xpath("//button[@type='button']"));

        softAssert.assertTrue(addBton.isEnabled());
        addBton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        //WebElement message1 = driver.findElement(By.id("message"));
        System.out.println(message.getText());

        softAssert.assertEquals(message.getText(), "It's gone!");

        addBton.click();

        WebElement message1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println(message1.getText());

        softAssert.assertAll();
    }
}
