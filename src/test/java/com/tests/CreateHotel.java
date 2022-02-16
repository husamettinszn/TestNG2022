package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateHotel extends TestBase {

    @Test
    public void createHotel() throws InterruptedException {

        driver.get("http://qa-environment.crystalkeyhotels.com");

        WebElement loginButton = driver.findElement(By.xpath("(//a[@class='nav-link'])[7]"));
        loginButton.click();
        WebElement userNameTextBox = driver.findElement(By.id("UserName"));
        userNameTextBox.sendKeys("manager");
        WebElement passwordTextBox = driver.findElement(By.id("Password"));
        passwordTextBox.sendKeys("Manager2!");
        WebElement submitLogin = driver.findElement(By.id("btnSubmit"));
        submitLogin.click();

        WebElement hotelManagement = driver.findElement(By.xpath("//*[text()='Hotel Management']"));
        hotelManagement.click();

        WebElement hotelList = driver.findElement(By.xpath("(//i[@class='icon-calendar'])[2]"));
        hotelList.click();

        WebElement addHotel = driver.findElement(By.xpath( "//a[@class='btn btn-circle btn-default']"));
        addHotel.click();

        WebElement code = driver.findElement(By.xpath("(//input[@class='form-control input-lg required'])"));
        code.sendKeys("1357");

        WebElement nameTextBox = driver.findElement(By.xpath("(//input[@class='form-control input-lg required'])[2]"));
        WebElement adressTextBox = driver.findElement(By.xpath("(//input[@class='form-control input-lg required'])[3]"));
        WebElement phoneTextBox = driver.findElement(By.xpath("(//input[@class='form-control input-lg required'])[4]"));
        WebElement emailTextBox =    driver.findElement(By.xpath("(//input[@class='form-control input-lg required'])[5]"));
        WebElement idGroupDropdown = driver.findElement(By.id("IDGroup"));
        WebElement saveButton = driver.findElement(By.id("btnSubmit"));

        nameTextBox.sendKeys("Ömer Muhtar Hotel");
        adressTextBox.sendKeys("Atlar sok, 23, Kiel, Polen");
        phoneTextBox.sendKeys("0192837465");
        emailTextBox.sendKeys("omermuhtar@gmail.com");

        Select select = new Select(idGroupDropdown);
        select.selectByVisibleText("Hotel Type2");
        saveButton.click();

        Thread.sleep(1000);
        WebElement succesfullyMessage = driver.findElement(By.xpath("//*[text()='Hotel was inserted successfully']"));

        System.out.println(succesfullyMessage.getText());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(succesfullyMessage.getText(), "Hotel was inserted successfully");


        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();




        softAssert.assertAll();

        Thread.sleep(3000);
    }
}