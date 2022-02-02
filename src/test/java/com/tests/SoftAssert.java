package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


import java.time.Duration;

public class SoftAssert {
    //Yeni bir Class Olusturun : D11_SoftAssert1
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    @Ignore
    public void test1() {
        //1. “https://www.ebay.com/” Adresine gidi
        driver.get("https://www.ebay.com/");
        // 2. Basliginin "Electronics, Cars, Fashion, Collectibles & More | eBay" oldugunu dogrulayin
        String titel = "Electronics, Cars, Fashion, Collectibles & More | eBay";
        org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();
        softAssert.assertEquals(driver.getTitle(), titel);
        // 3. search kutusuna transformers yazip arattirin
        WebElement suchFeld = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        suchFeld.sendKeys("transformers");
        suchFeld.submit();

        // 4.	bulunan sonuc sayisini yazdirin
        WebElement anzahlErgebnisse = driver.findElement(By.xpath("//div[@class='srp-controls__control srp-controls__count']"));
        System.out.println(anzahlErgebnisse.getText());

        // 5.	sonuc yazisinin "araba" icerdigini dogrulayin
        softAssert.assertTrue(anzahlErgebnisse.getText().contains("transformers"));

        //6.	Tumunu temizle linkini tiklayin
        WebElement suchFeld2 = driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
        suchFeld2.clear();
        suchFeld2.submit();
        //7.	Bulunan sonucu yazdirin
        WebElement end = driver.findElement(By.xpath("//a[@class='top-cat']"));
        System.out.println(end.getText());
        //8.	Sonuc yazisinin “araba” kelimesi icermedigini dogrulayin
        softAssert.assertTrue(end.getText().contains("transformers"));

        softAssert.assertAll();
        //System.out.println("Ist das?");

    }
    @Test
    public void kralSakir() throws InterruptedException {
        driver.get("http://www.youtube.com");
        driver.findElement(By.xpath("(//yt-formatted-string[@class='style-scope ytd-button-renderer style-primary size-default'])[2]")).click();
        Thread.sleep(3);
        WebElement suchFeld = driver.findElement(By.xpath("//div[@class='ytd-searchbox-spt']"));
        suchFeld.sendKeys("kral sakir");
    }
    @AfterClass
    public void tearDown(){
        //driver.close();
    }
}
