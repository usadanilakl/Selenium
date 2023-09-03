package com.cydeo.test.practice;

import com.beust.ah.A;
import com.cydeo.test.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Ten {
    WebDriver driver;
    @BeforeMethod
    public void set(){
        driver = WebDriverFactory.create("Chrome");
    }

    @Test
    public void deleteIsDisplayed(){
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        WebElement addButton = driver.findElement(By.cssSelector("button[onclick]"));
        addButton.click();

        ArrayList<WebElement> buttons = new ArrayList<>(driver.findElements(By.tagName("button")));
        ArrayList<String> buttonText = new ArrayList<>();
        for (WebElement button : buttons){
            buttonText.add(button.getText());
            System.out.println(button.getText());
        }

        Assert.assertTrue(buttonText.contains("Delete"));
    }

    @Test
    public void deleteIsNotDisplayed(){
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        WebElement addButton = driver.findElement(By.cssSelector("button[onclick]"));
        addButton.click();

        WebElement delButton = driver.findElement(By.cssSelector("button[class]"));
        delButton.click();

        ArrayList<WebElement> buttons = new ArrayList<>(driver.findElements(By.tagName("button")));
        ArrayList<String> buttonText = new ArrayList<>();
        for (WebElement button : buttons){
            buttonText.add(button.getText());
            System.out.println(button.getText());
        }

        Assert.assertTrue(!buttonText.contains("Delete"));
    }

    @AfterMethod
    public void close () {
        driver.quit();
    }
}
