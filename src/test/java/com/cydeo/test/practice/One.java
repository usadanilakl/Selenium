package com.cydeo.test.practice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/*
1. Open Chrome browser
2. Go to https://practice.cydeo.com
3. Verify URL contains
Expected: cydeo
4. Verify title:
Expected: Practice
 */

public class One {
    public static void main (String[] args) {
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com");
        String title = driver.getTitle();
        
        boolean titleContains = title.equals("Practice");
        System.out.println("titleContains = " + titleContains);



    }
}
