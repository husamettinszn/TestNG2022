package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;

import java.util.ArrayList;
import java.util.List;

public class WebTables extends TestBase {

    public void login() throws InterruptedException {
        driver.get("http://qa-environment.crystalkeyhotels.com/admin/HotelRoomAdmin");

        Thread.sleep(2000);
        WebElement userNameTextBox = driver.findElement(By.id("UserName"));
        userNameTextBox.sendKeys("manager");
        WebElement passwordTextBox = driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys("Manager2!", Keys.ENTER);
    }
    @Test
    public void tableTest() throws InterruptedException {
        login();
        Thread.sleep(1000);

        WebElement tBody = driver.findElement(By.xpath("//tbody"));
        System.out.println(tBody.getText());

        List<WebElement> titelList = driver.findElements(By.xpath("//thead//th"));

        System.out.println("Anzahl der Titels : " + titelList.size());

        List<String> titels = new ArrayList<>();
        for (WebElement w:titelList
             ) {
            System.out.println(w.getText());
            titels.add(w.getText());
        }

        System.out.println(titels);
    }
    @Test
    public void printRows() throws InterruptedException {
        login();
        Thread.sleep(2000);

        List<WebElement> rows = driver.findElements(By.xpath("//tbody//tr"));

        System.out.println("Anzahl der Zeilen : "+rows.size());

        for (WebElement w: rows
             ) {
            System.out.println(w.getText());
        }

        WebElement zeile4 = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println("");
        System.out.println(zeile4.getText());
    }
    @Test
    public void printCells() throws InterruptedException {
        login();
        List<WebElement> allZellen = driver.findElements(By.xpath("//tbody//td"));

        System.out.println("Anzahl der Zellen : "+allZellen.size());

        for (  WebElement w:allZellen
             ) {
            System.out.println(w.getText());
        }
    }
    @Test
    public void printColumns() throws InterruptedException {
        login();
        Thread.sleep(2000);

        List<WebElement> anzahlS??ule = driver.findElements(By.xpath("//tbody//tr[1]//td"));
        System.out.println("Anzahl der S??ule : "+anzahlS??ule.size());

        List<WebElement> s??ule5 = driver.findElements(By.xpath("//tbody//td[5]"));
        System.out.println("Anzahl : "+s??ule5.size());

        for (WebElement w: s??ule5
             ) {
            System.out.println(w.getText());
        }

        System.out.println("///////////////////////////////////");

        for (int i=1; i<=anzahlS??ule.size(); i++){

            List<WebElement> s??ule = driver.findElements(By.xpath("//tbody//tr//td["+i+"]"));

            System.out.println(" " +i +"S??ule");
            for (WebElement w :s??ule
                    ) {
                System.out.println(w.getText());
            }
        }
    }
    @Test
    public void titelDritteS??ule() throws InterruptedException {
        login();
        Thread.sleep(2000);
        for (int i=1; i<=9; i++) {

            WebElement dritteS??ule = driver.findElement(By.xpath("//thead//th["+i+"]"));
            System.out.println(dritteS??ule.getText());
        }
    }
    public String printData(int zelle, int s??ule) throws InterruptedException {

        Thread.sleep(2000);
        WebElement data = driver.findElement(By.xpath("//tbody//tr["+zelle+"]//td["+s??ule+"]"));
        //System.out.println(data.getText());

        return data.getText();

    }
    @Test
    public void data() throws InterruptedException {
        login();
        printData(1,2);
       Assert.assertEquals(printData(1,2), "BenDeniz");
    }


}
