package com.cydeo.test.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByClass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://google.com");
        WebElement search = driver.findElement(By.className("gLFyf"));
        search.sendKeys("apple" + Keys.ENTER);

        if(driver.getTitle().contains("Hello")){
            System.out.println("Success");
        }else {
            System.out.println("fail");
        }

        driver.quit();

    }
}
