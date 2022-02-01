package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class DependsOnMethods {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void startSeiteTest(){
        driver.get("https://www.alibaba.com");
        WebElement logoAlibab = driver.findElement(By.xpath("(//a[@class='J-sc-hd-i-logo sc-hd-i-logo sc-hd-i-logo-new'])[2]"));
        Assert.assertTrue(logoAlibab.isDisplayed());
    }
    @Test (dependsOnMethods = "startSeiteTest")
    public void suchTest(){
        WebElement search = driver.findElement(By.xpath("//input[@class='ui-searchbar-keyword']"));
        search.sendKeys("nutella");
        search.submit();
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Nutella"));

    }
    @Test(dependsOnMethods = "suchTest")
    public void preisNutella() throws InterruptedException {

        WebElement aaa = driver.findElement(By.xpath("//img[@class='J-img-switcher-item']"));
        aaa.click();

        String ilkSayfaHandle=driver.getWindowHandle();
        Set<String> tumSayfaHandleKumesi=driver.getWindowHandles();
        String ikinciSayfaHandle="";
        for (String w:tumSayfaHandleKumesi
        ) {
            if (!w.equals(ilkSayfaHandle)){
                ikinciSayfaHandle=w;
            }
        }

        driver.switchTo().window(ikinciSayfaHandle);
        driver.findElement(By.xpath("//div[@class='gdpr-btn gdpr-agree-btn']")).click();

        WebElement preis = driver.findElement(By.xpath("//span[@class='ma-ref-price']"));
        String erwarteterpreis = "$3.50";
        Assert.assertTrue(preis.getText().contains(erwarteterpreis));

    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
