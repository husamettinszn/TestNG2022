package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateHotelRoom extends TestBase {

    @Test
    public void createHotelRoom() throws InterruptedException {

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

        WebElement hotelRooms = driver.findElement(By.partialLinkText("Hotel Rooms"));
        hotelRooms.click();

        WebElement addHotelRoom = driver.findElement(By.xpath("//*[text()='Add Hotelroom ']"));
        addHotelRoom.click();

        WebElement selectHotelDropdown = driver.findElement(By.xpath("//select[@class='form-control input-lg required']"));

        Select select = new Select(selectHotelDropdown);
        select.selectByVisibleText("Ömer Muhtar Hotel");

        WebElement roomCode = driver.findElement(By.xpath("(//input[@class='form-control input-lg required'])[1]"));
        WebElement roomName = driver.findElement(By.xpath("(//input[@class='form-control input-lg required'])[2]"));
        WebElement roomLocation = driver.findElement(By.xpath("(//input[@class='form-control input-lg required'])[3]"));
        WebElement textAreaDescription = driver.findElement(By.xpath("//textarea[@dir='ltr']"));
        WebElement euro600 = driver.findElement(By.xpath("(//a[@class='label label-success'])[5]"));

        WebElement roomAdultAccount = driver.findElement(By.xpath("(//input[@class='form-control input-lg required'])[4]"));
        WebElement roomChildrenCount = driver.findElement(By.xpath("(//input[@class='form-control input-lg required'])[5]"));
        WebElement approvedCheckBox = driver.findElement(By.id("IsAvailable"));
        WebElement saveButton = driver.findElement(By.id("btnSubmit"));
        WebElement priceTextBox = driver.findElement(By.id("Price"));

        roomCode.sendKeys("341");
        roomName.sendKeys("hervorragend");
        roomLocation.sendKeys("4.Stock");
        textAreaDescription.sendKeys("Das ist eine schönes, bereites, helles Zimmer.");

        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(euro600, priceTextBox).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(2000);

        Thread.sleep(2000);
        WebElement roomType = driver.findElement(By.id("IDGroupRoomType"));
        Select select1 = new Select(roomType);
        select1.selectByValue("7");
        Thread.sleep(2000);

        roomAdultAccount.sendKeys("2");
        roomChildrenCount.sendKeys("3");

        approvedCheckBox.click();
        saveButton.click();

        Thread.sleep(2000);

        WebElement succesfullyMessage = driver.findElement(By.xpath("//div[@class='bootbox-body']"));

        Assert.assertEquals(succesfullyMessage.getText(), "HotelRoom was inserted successfully");


        WebElement okButton = driver.findElement(By.xpath("(//button[@type='button'])[6]"));
        okButton.click();

        Thread.sleep(3000);





    }
}
