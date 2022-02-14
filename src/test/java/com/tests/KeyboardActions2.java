package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class KeyboardActions2 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com");

        Actions actions = new Actions(driver);
        //WebElement emailTextBox = driver.findElement(By.id("email"));

        WebElement allow = driver.findElement(By.xpath("(//button[@value='1'])[3]"));
        actions.click(allow).perform();
        WebElement emailTextBox = driver.findElement(By.id("email"));
        actions.click(emailTextBox)
                .sendKeys("husamettinszn@yandex.com")
                .sendKeys(Keys.TAB)
                .sendKeys("hsmttgshj12")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        WebElement message = driver.findElement(By.linkText("Find your account and log in."));
        WebElement message2 = driver.findElement(By.className("_9ay7"));
        System.out.println(message.getText());
        System.out.println(message2.getText());

        Assert.assertEquals(message2.getText(), "The email you entered isn’t connected to an account. Find your account and log in.");
    }

}
