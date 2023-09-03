package com.cydeo.test.practice;

import com.cydeo.test.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Seven {
    WebDriver driver;
    @BeforeMethod
    public void set(){
       driver = WebDriverFactory.create("Chrome");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void locator(){
        driver.get("https://practice.cydeo.com/inputs");
        driver.findElement(By.linkText("Home")).click();
        Assert.assertEquals(driver.getTitle(), "Practice");
    }

    @Test
    public void login(){
        driver.get("https://login1.nextbasecrm.com/");
        driver.findElement(By.xpath("//div[@class='login-item']/input")).sendKeys("incorrect");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("incorrect" + Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='errortext']")).getText(),
                "Incorrect login or password");
    }

    @Test
    public void baseCRM(){
        driver.get("https://login1.nextbasecrm.com/");
        Assert.assertEquals(driver.findElement(By.xpath("//label[@class='login-item-checkbox-label']")).getText(), "Remember me on this computer");
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='login-link-forgot-pass']")).getText(),
                "Forgot your password?");
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='login-link-forgot-pass']")).getAttribute("href"), "forgot_password=yes" );
    }

    @Test
    public void button(){
        driver.get("https://login1.nextbasecrm.com/");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='submit']")).getAttribute("value"),
                "Log In");

    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
