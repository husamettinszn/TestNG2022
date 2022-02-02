package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AmazonDropdown {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    //● https://www.amazon.com/ adresine gidin.
    public void gehZurStartSeite(){
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void test1(){
        //		- Test 1
        //			Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 27 oldugunu test edin
        WebElement dropTitel = driver.findElement(By.xpath("//select[@name='url']"));

        Select select = new Select(dropTitel);
        List<WebElement> allList = select.getOptions();
        int anzahlKategorie = allList.size() -1 ;

        Assert.assertEquals(anzahlKategorie, 27);
    }
    @Test
    public void test2() throws InterruptedException {
        //		-Test 2
        //			1. Kategori menusunden Books secenegini  secin
        WebElement dropTitel = driver.findElement(By.xpath("//select[@name='url']"));
        Select select = new Select(dropTitel);
        select.selectByVisibleText("Books");
        //          2. Arama kutusuna Java yazin ve aratin
        WebElement suchFeld = driver.findElement(By.id("twotabsearchtextbox"));
        suchFeld.sendKeys("Java");
        suchFeld.submit();
        //			3. Bulunan sonuc sayisini yazdirin
        WebElement anzahlErgebnis = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(anzahlErgebnis.getText());

        //			4. Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(anzahlErgebnis.getText().contains("Java"));

    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
