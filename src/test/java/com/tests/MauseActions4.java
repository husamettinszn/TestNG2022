package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MauseActions4 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com");

        WebElement waitSeh = driver.findElement(By.xpath("//div[@class='nav-line-1-container']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(waitSeh).perform();
        actions.click(driver.findElement(By.xpath("//span[@class='nav-text']"))).perform();

        Thread.sleep(1000);
        WebElement textElement = driver.findElement(By.xpath("//div[@role='heading']"));
        System.out.println(textElement.getText());

        Assert.assertEquals(textElement.getText(), "Your Lists");


    }
    @Test
    public void teset(){

        System.out.println("Merhaba");
    }
}
