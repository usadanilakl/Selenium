package com.cydeo.test.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByTagName {
    public static void main(String[] args) {
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com");

        WebElement header = driver.findElement(By.tagName("h1"));
        String text = header.getText();

        System.out.println("text = " + text);


    }
}
