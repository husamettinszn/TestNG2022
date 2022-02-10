package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandle1 extends TestBase {

        @Test
        public void test() throws InterruptedException {
            driver.get("https://the-internet.herokuapp.com/windows");
            WebElement seiteText = driver.findElement(By.tagName("h3"));
            System.out.println(seiteText.getText());

            org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();
            softAssert.assertTrue(seiteText.getText().equals("Opening a new window"));

            String actualTitel = driver.getTitle();
            softAssert.assertTrue(actualTitel.equals("The Internet"));

            driver.findElement(By.xpath("//a[@target='_blank']")).click();

            String ersteSeite = driver.getWindowHandle();
            String zweiteSeite = "";
            Set<String> alleSeiten = driver.getWindowHandles();

            for (String w : alleSeiten
            ) {
                if (!ersteSeite.equals(w)) {
                    zweiteSeite = w;
                }
            }
            driver.switchTo().window(zweiteSeite);

            WebElement text2 = driver.findElement(By.tagName("h3"));
            System.out.println(text2.getText());
            softAssert.assertTrue(text2.getText().contains("Window"));

            driver.switchTo().window(ersteSeite);

            softAssert.assertEquals(driver.getTitle(), "The Internet");
        }

    }


