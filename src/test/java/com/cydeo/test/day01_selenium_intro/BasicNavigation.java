package com.cydeo.test.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com");

        driver.navigate().to("https://amazon.com");

        driver.navigate().back();

        driver.navigate().forward();

        driver.navigate().refresh();
    }
}
