package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables2 extends TestBase {

    @Test
    public void test(){
        driver.get("https://demoqa.com/webtables");

        List<WebElement> titels = driver.findElements(By.className("rt-resizable-header-content"));

        for (WebElement w : titels
                ) {
            System.out.println(w.getText());
        }

        WebElement säuleDrei = driver.findElement(By.xpath("(//div[@class='rt-resizable-header-content'])[3]"));
        System.out.println(säuleDrei.getText());

        System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");

        WebElement alleData = driver.findElement(By.className("rt-table"));
        System.out.println(alleData.getText());

        System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§§");

        List<WebElement> alleZelle = driver.findElements(By.className("rt-td"));

        for (WebElement w : alleZelle) {
            System.out.println(w.getText());
        }
        System.out.println("Anzahl der Zellen :"+alleZelle.size());

        List<WebElement> anzahlDerZeile = driver.findElements(By.className("rt-tr-group"));
        System.out.println(anzahlDerZeile.size());

    }
}
