package com.tests;

import com.utilities.TestBase;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables2 extends TestBase {

    @Test
    public void test(){
        driver.get("https://demoqa.com/webtables");

        /*
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

        List<WebElement> anzahlDerSäule = driver.findElements(By.className("rt-resizable-header-content"));
        System.out.println("Anzahl der Säule :"+anzahlDerSäule.size());

        List<WebElement>  säuleDreiZelle = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[3]"));
        for (WebElement w: säuleDreiZelle
             ) {
            System.out.println(w.getText());
        }
        for (int i=1; i<säuleDreiZelle.size(); i++){
            WebElement säule3 = driver.findElement(By.xpath("(//div[@class='rt-tr-group']//div[3])["+i+"]"));
            System.out.println(säule3.getText());
        }

         */
        //Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        List<WebElement> lastName = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[2]"));

        List<WebElement> headers = driver.findElements(By.className("rt-resizable-header-content"));
        int emailZelle =0;

        for (int i=0; i<headers.size(); i++){
            if (headers.get(i).getText().equals("Email")){
                emailZelle = i+1;
            }
        }

        int zeile=0;

        for (int i=0; i<lastName.size(); i++){
            if (lastName.get(i).getText().equals("Vega")){
                zeile = i+1;
            }
        }
        WebElement emailVega= driver.findElement(By.xpath("(//div[@class='rt-tr-group'])["+zeile+"]//div["+emailZelle+"]"));
        System.out.println(emailVega.getText());
    }
}
