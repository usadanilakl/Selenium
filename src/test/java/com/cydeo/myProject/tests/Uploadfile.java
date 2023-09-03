package com.cydeo.myProject.tests;

import com.cydeo.myProject.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Uploadfile extends Base {
    @Test
    public void uploading() throws InterruptedException {
        driver.get("https://practice.cydeo.com/upload");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = driver.findElement(By.xpath("//input[@id='file-upload']"));
        Thread.sleep(2000);
        button.sendKeys("C:/Users/usada/OneDrive/Desktop/Small file on my computer.txt");
        driver.findElement(By.id("file-submit")).click();

    }
}
