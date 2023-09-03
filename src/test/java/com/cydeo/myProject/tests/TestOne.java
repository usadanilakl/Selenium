package com.cydeo.myProject.tests;

import com.cydeo.myProject.utils.MyButton;
import com.cydeo.myProject.utils.PR;
import com.cydeo.myProject.utils.SetDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public class TestOne {
    public static void main(String[] args) throws InterruptedException {
        SetDriver.getDriver(PR.getP("browser"));
        SetDriver.getDriver(PR.getP("browser")).get(PR.getP("link"));
        SetDriver.getDriver(PR.getP("browser")).findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        Alert alert = SetDriver.getDriver(PR.getP("browser")).switchTo().alert();
        alert.accept();
        SetDriver.getDriver(PR.getP("browser")).switchTo().defaultContent();
        String res = SetDriver.getDriver(PR.getP("browser")).findElement(By.id("result")).getText();
        System.out.println(res);
        SetDriver.closeDriver();




    }

}
