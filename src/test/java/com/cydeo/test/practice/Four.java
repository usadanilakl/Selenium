package com.cydeo.test.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Four {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver();
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://library2.cybertekschool.com/login.html");
        WebElement eMail = driver.findElement(By.xpath("//input[@id='inputEmail']"));
        eMail.sendKeys("incorrect@email.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword']"));
        password.sendKeys("incorrect password" + Keys.ENTER);
        
      // Thread.sleep(3000);

        WebElement mess = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[@class='alert alert-danger']")));

        String message = mess.getText();
       // WebElement mess = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        // String message = mess.getText();

        System.out.println(message);

        if(message.equals("Sorry, Wrong Email or Password")) {
            System.out.println("Success" );
        } else {
            System.out.println("no success");
        }

        driver.quit();
    }
}
