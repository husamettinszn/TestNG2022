package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class MauseActions1 extends TestBase {

    @Test
    public void test(){
        //1- Yeni bir class olusturalim: D14_MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");;
        //3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);

        actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        String text = driver.switchTo().alert().getText();
        System.out.println(text);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(text, "You selected a context menu");
        //5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//a[@target='_blank']")).click();

        String ersteSeite = driver.getWindowHandle();

        Set<String> allaSeite = driver.getWindowHandles();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String zweiteSeite = "";

        for (String w:allaSeite
             ) {
            if (!ersteSeite.equals(w)){
                zweiteSeite = w;
            }
        }
        driver.switchTo().window(zweiteSeite);

        WebElement h1Tag = driver.findElement(By.tagName("h1"));

        softAssert.assertEquals(h1Tag.getText(), "Elemental Selenium");

        softAssert.assertAll();
    }
}
