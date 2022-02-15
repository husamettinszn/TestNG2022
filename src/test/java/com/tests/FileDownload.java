package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends TestBase {
    //1. Tests packagenin altina bir class oluşturalim : D14_FileDownload
    //2. Iki tane metod oluşturun : isExist() ve downloadTest()
    //3. downloadTest () metodunun icinde aşağıdaki testi yapalim:
    //		- https://the-internet.herokuapp.com/download adresine gidelim.
    //		- image1.jpg dosyasını indirelim
    //4. Ardından isExist()  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
    @Test
    public void fileDownload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[@href='download/image.png']")).click();
        Thread.sleep(3000);
    }
    @Test (dependsOnMethods = "fileDownload")
    public void isExist(){
        String homePath = System.getProperty("user.home");
        String filePath = homePath + "\\Downloads\\image.png";
        System.out.println(filePath);

        boolean isExistFile = Files.exists(Paths.get(filePath));
        System.out.println(isExistFile);


    }
}
