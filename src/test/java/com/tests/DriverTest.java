package com.tests;

import com.utilities.Driver;
import org.testng.annotations.Test;

public class DriverTest  {

    @Test
    public void test(){
        Driver.getDriver().get("https://www.youtube.com");
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get("https://www.bestbuy.com");

        Driver.driver.close();
    }
}
