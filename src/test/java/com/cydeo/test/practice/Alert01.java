package com.cydeo.test.practice;

import com.cydeo.test.Base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Alert01 extends TestBase {
    @Test
    public void alertVerification() throws InterruptedException{
        driver.get("http://practice.cydeo.com/javascript_alerts");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
       // WebDriverWait wait = new WebDriverWait(driver, 10);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.accept();
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You successfully clicked an alert");
        if(driver.findElement(By.id("result")).getText().equals("You successfully clicked an alert")){
            System.out.println("You are good");
        }

        driver.quit();


    }
}
