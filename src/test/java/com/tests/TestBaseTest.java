package com.tests;

import com.utilities.TestBase;
import org.testng.annotations.Test;

public class TestBaseTest extends TestBase {

    @Test
    public void youTube(){
        driver.get("https://www.youtube.com");
    }


}
