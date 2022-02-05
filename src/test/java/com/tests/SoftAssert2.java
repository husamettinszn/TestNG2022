package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SoftAssert2 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @Test
    public void test01() throws InterruptedException {
        // Yeni bir Class Olusturun : D10_SoftAssert2
        //1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("https://vsr.testbench.com/");
        // 2. Sign in butonuna basin
        //driver.findElement(By.id("login_as_customer")).click();

        // 3. Login kutusuna “username” yazin
        WebElement usernameTextBox = driver.findElement(By.id("input_username"));
        usernameTextBox.sendKeys("SoftwareOktober1_a");

        // 4. Password kutusuna “password” yazin
        WebElement passwordTextbBox = driver.findElement(By.id("input_password"));
        passwordTextbBox.sendKeys("password_a");

        // 5. Sign in tusuna basin
        driver.findElement(By.id("button_login")).click();

        // 6. Pay Bills sayfasina gidin

        for (int i=1; i<26; i++){
            WebElement kunde =driver.findElement(By.xpath("(//mat-grid-tile[@class='mat-grid-tile element ng-star-inserted'])["+i+"]"));
            System.out.println(kunde.getText());
        }

        // 7. “Purchase Foreign Currency” tusuna basin
        // 8. “Currency” drop down menusunden Eurozone’u secin
        // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)",
        // "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        // "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
        // "Singapore (dollar)","Thailand (baht)"
        Thread.sleep(3000);
    }
    @AfterClass
    public void tearDown(){
        //driver.close();
    }
}
