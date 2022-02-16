package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

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

        Thread.sleep(3000);
    }
}