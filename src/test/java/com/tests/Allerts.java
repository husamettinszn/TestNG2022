package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Allerts {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void acceptAlert() {
        //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //● Bir metod olusturun: acceptAlert
        // 			○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        //“You successfuly clicked an alert” oldugunu test edin.
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        WebElement message1 = driver.findElement(By.id("result"));
        System.out.println(message1.getText());

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(message1.isDisplayed());

    }
    @Test
    public void dismissAssert(){
        //● Bir metod olusturun: dismissAlert
        //			○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının 									“successfuly” icermedigini test edin.
        //             “successfuly” icermedigini test edin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        WebElement message1 = driver.findElement(By.id("result"));
        System.out.println(message1.getText());

        Assert.assertFalse(message1.getText().contains("Succesfully"));

    }
    @Test
    public void sendKeysAllert(){
        //● Bir metod olusturun: sendKeysAlert
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //			○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Hüsamettin Sözen");
        driver.switchTo().alert().accept();
        //			tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        WebElement message = driver.findElement(By.id("result"));
        Assert.assertTrue(message.getText().contains("Hüsamettin Sözen"));
    }
    @AfterClass
    public void tearDown(){
        driver.close();
    }

}
