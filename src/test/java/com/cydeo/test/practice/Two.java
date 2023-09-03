package com.cydeo.test.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.Thread;
/*
1- Open a chrome browser
2- Go to: https://practice.cydeo.com
3- Click to A/B Testing from top of the list.
4- Verify title is:
Expected: No A/B Test
5- Go back to home page by using the .back();
6- Verify title equals:
Expected: Practice
 */
public class Two {
    public static void main  (String[] args) throws InterruptedException{
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com");

        if(driver.getTitle().equals("Practice")) {
            System.out.println("Very Good");
        }

        WebElement item = driver.findElement(By.partialLinkText("A/B"));
            item.click();




        System.out.println(driver.getTitle());
        Thread.sleep(2000);
       driver.navigate().back();
       Thread.sleep(2000);

       driver.quit();


    }
}
