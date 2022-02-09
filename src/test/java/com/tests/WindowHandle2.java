package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class WindowHandle2 extends TestBase {

    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        String ersteSeite = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@target='_blank']")).click();

        Set<String> alleSeite = driver.getWindowHandles();

        String zweiteSeite = "";

        for (String w: alleSeite
             ) {
            if (!ersteSeite.equals(w)){
                zweiteSeite = w;
            }
        }
        driver.switchTo().window(zweiteSeite);

        WebElement h1Tag = driver.findElement(By.tagName("h1"));
        SoftAssert softAssert = new SoftAssert();

        System.out.println(h1Tag.getText());
        softAssert.assertTrue(h1Tag.getText().equals("Powered by Tiny"));

        softAssert.assertAll();
    }

}
