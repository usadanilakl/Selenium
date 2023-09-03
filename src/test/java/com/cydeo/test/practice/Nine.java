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
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Nine {
    WebDriver driver;
    @BeforeMethod
    public void start(){
        driver = WebDriverFactory.create("Chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

    @Test
    public void links(){
        driver.get("https://practice.cydeo.com/abtest");
        ArrayList<WebElement> links = new ArrayList<>();
        links.addAll(driver.findElements(By.tagName("a")));

        System.out.println("there are " + links.size() + " links");

        for (WebElement link : links) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
        }
    }

    @Test
    public void checkboxes(){
        driver.get("https://practice.cydeo.com/checkboxes");

        WebElement ch1 = driver.findElement(By.cssSelector("input[name='checkbox1']"));
        Assert.assertEquals(ch1.isSelected(), "false");
        ch1.click();
        Assert.assertTrue(ch1.isSelected());


        WebElement ch2 = driver.findElement(By.cssSelector("input[name='checkbox2']"));
        Assert.assertTrue(ch2.isSelected());
        ch2.click();
        Assert.assertTrue(!ch2.isSelected());
    }

    @Test
    public void refresh() throws InterruptedException {
        driver.get("https://practice.cydeo.com/abtest");
        WebElement link = driver.findElement(By.linkText("CYDEO"));
        Assert.assertTrue(link.isDisplayed());
        System.out.println(link.isDisplayed());

        driver.navigate().refresh();
        Thread.sleep(3000);
        WebElement link2 = driver.findElement(By.linkText("CYDEO"));
        Assert.assertTrue(link2.isDisplayed());
        System.out.println("link2.isDisplayed() = " + link2.isDisplayed());

    }
}
