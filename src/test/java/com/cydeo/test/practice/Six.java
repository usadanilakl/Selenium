package com.cydeo.test.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Six {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void etsyTitle(){
        driver.get("https://etsy.com");
       WebElement search = driver.findElement(By.id("global-enhancements-search-query") );
       search.sendKeys("wooden spoon" + Keys.ENTER);
        Assert.assertEquals(driver.getTitle(), "Wooden spoon - Etsy");
    }

    @Test
    public void zeroBank(){

        driver.get("http://zero.webappsecurity.com/login.html");
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Log in to ZeroBank");
    }

    @Test
    public void google(){
        driver.get("https://google.com");
        WebElement gmail = driver.findElement(By.xpath("//div[@class='gb_w gb_x']/a"));
        gmail.click();
        Assert.assertTrue(driver.getTitle().contains("Gmail"));
        driver.navigate().back();
        Assert.assertTrue(driver.getTitle().equals("Google"));

    }

    @AfterTest
    public void close(){
        driver.quit();
    }
}
