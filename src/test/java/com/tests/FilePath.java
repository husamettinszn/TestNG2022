package com.tests;

import com.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePath extends TestBase {

   @Test
    public void test(){
       System.out.println(System.getProperty("user.dir")); //icinde oldugumuz dosyanin yolunu verir
       System.out.println(System.getProperty("user.home"));//bilgisayarimizin ana path ini verir.

       String anaPath = System.getProperty("user.home");

       System.out.println("desktop yolu : "+ anaPath + "\\Desktop");

   }
    @Test
    public void isExist(){
       //C:\Users\Husamettin\Desktop\präsentation.jpeg
        String homePath = System.getProperty("user.home");

        String filePath = homePath + "\\Desktop\\präsentation.jpeg";

        System.out.println(filePath);

        Files.exists(Paths.get(filePath));

        boolean dosyaVarMi = Files.exists(Paths.get(filePath));

        System.out.println(dosyaVarMi);

        Assert.assertTrue(Files.exists(Paths.get(filePath)));


    }
}
