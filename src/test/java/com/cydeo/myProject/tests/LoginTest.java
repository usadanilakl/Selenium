package com.cydeo.myProject.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;



public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void set(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void login(){
        driver.get("http://login1.nextbasecrm.com/");
        driver.findElement(By.xpath("//input[@class='login-inp']")).sendKeys("helpdesk1@cydeo.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("UserUser", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Portal"));
        driver.quit();
    }
}
