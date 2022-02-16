package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ExplicitlyWait extends TestBase {

    @Test
    public void enableTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        SoftAssert softAssert = new SoftAssert();

        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));

        softAssert.assertFalse(textBox.isEnabled());

        WebElement enableDisableButton = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enableDisableButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        System.out.println(message.getText());

        softAssert.assertEquals(message.getText(), "It's enabled!");

        softAssert.assertAll();
    }
    @Test
    public void dynamicProperties(){
        driver.get("https://demoqa.com/dynamic-properties");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));

        WebElement visibleButton = driver.findElement(By.id("visibleAfter"));

        Assert.assertTrue(visibleButton.isDisplayed());

    }
}
