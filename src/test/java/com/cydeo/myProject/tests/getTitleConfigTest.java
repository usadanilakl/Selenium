package com.cydeo.myProject.tests;

import com.cydeo.myProject.utils.Base;
import com.cydeo.myProject.utils.appleConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getTitleConfigTest extends Base {
    @Test
    public void apple(){
        String url = appleConfigReader.getProperty("url");
        driver.get(url);
        driver.findElement(By.id("APjFqb")).sendKeys(appleConfigReader.getProperty("search"), Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains(appleConfigReader.getProperty("search")));
    }
}
