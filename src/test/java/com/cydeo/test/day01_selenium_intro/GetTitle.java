package com.cydeo.test.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();

        //Check if the title is Cydeo
        driver.get("https://cydeo.com");
        if(driver.getTitle().equals("Cydeo")) {
            System.out.println("Title verification passed");
        } else {
            System.out.println("Title verification failed");
        }

        System.out.println(driver.getTitle());
    }
}
