package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class KeyboardActions1 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com");

        WebElement suchFeld = driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions = new Actions(driver);
        //actions.sendKeys(suchFeld, "Samsung").perform();
        actions.click(suchFeld).perform();

        String gesuchtesWort = "Semaver";
        actions.sendKeys(gesuchtesWort).sendKeys(Keys.ENTER).perform();

        WebElement suchFeld1 = driver.findElement(By.id("twotabsearchtextbox"));

        actions.click(suchFeld1).perform();

        int lenght = gesuchtesWort.length();
        System.out.println(lenght);

        int counter= 0;
        do {
            actions.sendKeys(Keys.BACK_SPACE).perform();
            counter ++;
            System.out.println(counter);

        } while (counter<lenght);

        System.out.println("???");
        System.out.println(counter);
        Thread.sleep(3000);
    }

}
