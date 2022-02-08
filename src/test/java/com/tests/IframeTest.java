package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class IframeTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test1() throws InterruptedException {
        //● https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        //		○ “An IFrame containing….” textinin ulasilabilir oldugunu dogrulayin ve yazdirin
        WebElement titel= driver.findElement(By.tagName("h3"));
        System.out.println(titel.getText());
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(titel.isDisplayed());

        driver.switchTo().frame("mce_0_ifr");
        WebElement textBox = driver.findElement(By.xpath("//body[@class='mce-content-body ']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dünya");

        driver.switchTo().defaultContent();

        WebElement satz = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        System.out.println(satz.getText());

        softAssert.assertTrue(satz.getText().equals("Elemental Selenium"));

        softAssert.assertAll();
    }
    @AfterClass
    public void tearDown(){
        //driver.close();
    }
}
