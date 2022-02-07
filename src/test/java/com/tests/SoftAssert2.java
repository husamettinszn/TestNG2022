package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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

        List<String> kundenList = new ArrayList<>();

        for (int i=1; i<26; i++){
            WebElement kunde =driver.findElement(By.xpath("(//mat-grid-tile[@class='mat-grid-tile element ng-star-inserted'])["+i+"]"));
            //System.out.println(kunde.getText());
            kundenList.add(kunde.getText());
        }
        System.out.println(kundenList);

        WebElement sadeVatandas = driver.findElement(By.xpath("(//div[@class='mat-grid-tile-content'])[18]"));
        sadeVatandas.click();

        WebElement geburstDatum = driver.findElement(By.id("birth_date"));
        //geburstDatum.clear();
        geburstDatum.sendKeys("18/10/2000");

        driver.findElement(By.id("save")).click();
        Thread.sleep(1000);
        WebElement message = driver.findElement(By.xpath("//div[@class='cdk-global-overlay-wrapper']"));
        String erwareteMessage = "Could not save client";
        System.out.println(message.getText());

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(message.getText(), erwareteMessage);

        driver.findElement(By.id("dream_car")).click();
        driver.findElement(By.id("button_new_car")).click();

        WebElement model1PriceBase = driver.findElement(By.id("label_price_component"));
        System.out.println(model1PriceBase.getText());
        softAssert.assertTrue(model1PriceBase.getText().equals(" 29.000,00 €"));

        WebElement arrowNext = driver.findElement(By.id("arrow_next"));
        arrowNext.click();

        driver.findElement(By.id("mat-select-value-5")).click();
        WebElement motor2Punkt = driver.findElement(By.xpath("(//span[@class='mat-option-text'])[4]"));
        motor2Punkt.click();
        WebElement totalAmount = driver.findElement(By.id("label_price_sum"));
        System.out.println(totalAmount.getText());
        softAssert.assertTrue(totalAmount.getText().equals("31.200,00 €"));


        driver.findElement(By.id("arrow_next")).click();

        WebElement luxusPackage = driver.findElement(By.xpath("(//span[@class='mat-radio-inner-circle'])[3]"));
        luxusPackage.click();
        softAssert.assertTrue(driver.findElement(By.id("label_price_sum")).getText().equals("36.699,99 €"));

        driver.findElement(By.id("arrow_next")).click();

        Thread.sleep(2000);
        WebElement floorMats =driver.findElement(By.xpath("(//label[@class='mat-checkbox-layout'])[2]"));
        WebElement intelligentLight =driver.findElement(By.xpath("(//label[@class='mat-checkbox-layout'])[3]"));
        WebElement leatherstWheel =driver.findElement(By.xpath("(//label[@class='mat-checkbox-layout'])[4]"));

        floorMats.click();
        intelligentLight.click();
        leatherstWheel.click();

        driver.findElement(By.id("arrow_next")).click();
        driver.findElement(By.id("arrow_next")).click();

        driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[8]")).click();
        driver.findElement(By.xpath("(//span[@class='mat-button-wrapper'])[7]")).click();
        driver.findElement(By.id("order_close_ok")).click();
        WebElement orderMessage = driver.findElement(By.xpath("//div[@class='cdk-global-overlay-wrapper']"));
        System.out.println(orderMessage.getText());








        Thread.sleep(3000);
        softAssert.assertAll();


        // 7. “Purchase Foreign Currency” tusuna basin
        // 8. “Currency” drop down menusunden Eurozone’u secin
        // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)",
        // "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        // "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)",
        // "Singapore (dollar)","Thailand (baht)"

    }
    @AfterClass
    public void tearDown(){
        //driver.close();
    }
}
