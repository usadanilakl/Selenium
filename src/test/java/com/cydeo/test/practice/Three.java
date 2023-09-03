package com.cydeo.test.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class Three {
    public static void main(String[] args) {
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://google.com");
        WebElement gSearch = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));

        gSearch.sendKeys("apple" + Keys.ENTER);

        if(driver.getTitle().contains("apple") )System.out.println("Success");
        else System.out.println("not success");

        driver.quit();


    }
}
