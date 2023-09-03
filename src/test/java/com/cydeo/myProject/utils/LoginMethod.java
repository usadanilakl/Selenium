package com.cydeo.myProject.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginMethod {
    public static void login(WebDriver driver){
        driver.get(PR.getP("login"));
        driver.findElement(By.xpath("//input[@class='login-inp']")).sendKeys("helpdesk1@cydeo.com");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("UserUser", Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Portal"));
    }

    public static void login(WebDriver driver, String userName, String password){
        driver.get(PR.getP("login"));
        driver.findElement(By.xpath("//input[@class='login-inp']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password, Keys.ENTER);
        Assert.assertTrue(driver.getTitle().equals("Portal"));
    }
}
