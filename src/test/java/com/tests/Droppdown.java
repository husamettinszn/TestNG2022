package com.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Droppdown {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        }


     @Test

     public void list(){
         List<WebElement> drop =driver.findElements(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));

         for (WebElement w: drop
              ) {
             System.out.println(w.getText());
         }
     }
    @Test

    public void dropdownTest() throws InterruptedException {

        WebElement drop =driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));

        Select select = new Select(drop);
        select.selectByIndex(2);

        driver.findElement(By.id("nav-search-submit-button")).click();

        WebElement produkt11 = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[11]"));
        System.out.println(produkt11.getText());
        produkt11.click();

        driver.findElement(By.xpath("(//span[@class='a-button-inner'])[7]")).click();
        driver.navigate().back();
    }
     @AfterClass
    public void teardown(){
        driver.close();
     }

}
