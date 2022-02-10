package com.tests;

import com.utilities.TestBase;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.awt.image.Kernel;

public class MauseActions3 extends TestBase {

    @Test
    public void amazon() throws InterruptedException {
        driver.get("https://www.amazon.com");

        Actions actions = new Actions(driver);

        WebElement suchDropdown = driver.findElement(By.id("searchDropdownBox"));

        Select select = new Select(suchDropdown);
        select.selectByIndex(5);

        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement ersteProdukt = driver.findElement(By.xpath("//div[@class='p13n-sc-truncate-desktop-type2  p13n-sc-truncated']"));
        Thread.sleep(2000);
        actions.click(ersteProdukt).perform();

        Thread.sleep(2000);


        WebElement wiederClick = driver.findElement(By.xpath("(//img[@class='a-dynamic-image p13n-sc-dynamic-image p13n-product-image'])[14]"));
        actions.click(wiederClick).perform();
        Thread.sleep(5000);
    }
}
