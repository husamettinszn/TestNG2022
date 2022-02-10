package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MauseActions2 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("http://uitestpractice.com/Students/Actions");

        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.id("div2"))).perform();
        Thread.sleep(3000);

        WebElement clickMe = driver.findElement(By.xpath("//button[@name='click']"));
        actions.click(clickMe).perform();

        String message1 = driver.switchTo().alert().getText();
        System.out.println(message1);
        Assert.assertEquals(message1, "Clicked !!");
        driver.switchTo().alert().accept();

        WebElement doubleClick = driver.findElement(By.xpath("//button[@name='dblClick']"));
        actions.doubleClick(doubleClick).perform();

        String message2 = driver.switchTo().alert().getText();
        System.out.println(message2);
        Assert.assertEquals(message2, "Double Clicked !!");
        driver.switchTo().alert().accept();

        WebElement object = driver.findElement(By.id("draggable"));
        WebElement ziel = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(object, ziel).perform();
        System.out.println(ziel.getText());


        for (int i=1; i<12; i++){
            WebElement nummer = driver.findElement(By.xpath("(//li[@class='ui-state-default ui-selectee'])["+i+"]"));
            actions.click(nummer).perform();
            Thread.sleep(1000);

        }
    }

}
