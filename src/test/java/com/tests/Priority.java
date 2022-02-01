package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class Priority {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void suchFeld(){
        driver.get("https://www.youtube.com");
        WebElement suchFeld = driver.findElement(By.xpath("//div[@id='search-input']"));
        Assert.assertTrue(suchFeld.isEnabled());

    }
    @Test(priority = 2)
    public void image() throws InterruptedException {
        driver.get("https://www.youtube.com");
        WebElement imageYoutube= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[2]"));
        Assert.assertTrue(imageYoutube.isDisplayed());
    }
    @Test(priority = 3)
    public void falscheTitel(){
        driver.get("https://www.youtube.com");
        String falsceTitel= "youtube";
        Assert.assertFalse(falsceTitel.equals(driver.getTitle()));
    }@Test(priority = 4)
    public void titel(){
        String titel = "YouTube";
        Assert.assertTrue(titel.equals(driver.getTitle()));
        System.out.println(driver.getTitle());
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
