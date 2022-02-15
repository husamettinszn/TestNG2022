package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload extends TestBase {

    //Tests packagenin altina bir class oluşturun : D14_UploadFile
    //https://the-internet.herokuapp.com/upload adresine gidelim
    //chooseFile butonuna basalim
    //4. Yuklemek istediginiz dosyayi secelim.
    //5. Upload butonuna basalim.
    //6. “File Uploaded!” textinin goruntulendigini test edelim.
    @Test
    public void upload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dataAuswhlen = driver.findElement(By.id("file-upload"));

        String homePath = System.getProperty("user.home");
        String filePath =  homePath + "\\Downloads\\CAPSTONE PROJESI TEST PLANI Hüsamettin SÖZEN (2).docx";

        dataAuswhlen.sendKeys(filePath);
        Thread.sleep(3000);

        WebElement upLoad = driver.findElement(By.id("file-submit"));
        upLoad.click();

        WebElement upLoadMesage = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(upLoadMesage.isDisplayed());



        Thread.sleep(3000);








    }

}
