package com.cydeo.test.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Five {
    public static void main(String[] args){
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/registration_form");
        WebElement header = driver.findElement(By.xpath("//div[@class='page-header']/h2"));
        String text = header.getText();

        System.out.println(text);

        if(text.equals("Registration form")) System.out.println("Success");


        WebElement fname = driver.findElement(By.xpath("//div[@class='col-sm-5']/input[@name='firstname']"));

        if(fname.getAttribute("placeholder").equals("first name"))System.out.println("Success2");

        driver.quit();

    }
}
