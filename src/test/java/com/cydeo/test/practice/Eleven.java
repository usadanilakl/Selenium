package com.cydeo.test.practice;

import com.cydeo.test.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class Eleven {
    WebDriver driver;

    @BeforeMethod
    public void set(){
        driver = WebDriverFactory.create("Chrome");
    }

    @Test
    public void radioButton() throws InterruptedException {
        driver.get("https://practice.cydeo.com/radio_buttons");
        Thread.sleep(4000);

        ArrayList<WebElement> buttons = new ArrayList<>(driver.findElements(By.tagName("button")));
        for (WebElement button : buttons             ) {
            if (button.getText().equals("Hockey")){
                button.click();
                Thread.sleep(4000);
                Assert.assertTrue(button.isSelected());
            }
        }
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
