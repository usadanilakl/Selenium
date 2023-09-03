package com.cydeo.myProject.tests;

import com.cydeo.myProject.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;

public class ActionTests extends Base {
    @Test
    public void hover() throws InterruptedException {
       driver.get("https://practice.cydeo.com/hovers");
       Actions action = new Actions(driver);
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ArrayList<WebElement> images = new ArrayList<>(driver.findElements(By.tagName("img")));
        ArrayList<WebElement> messages = new ArrayList<>(driver.findElements(By.className("figcaption")));
        System.out.println(images.size());
        System.out.println(messages.size());

        for (int i = 0; i < images.size(); i++) {
            action.moveToElement(images.get(i)).perform();
            WebElement message = wait.until(ExpectedConditions.visibilityOf(messages.get(i)));
            Assert.assertTrue(message.getText().contains("name: user1") ||
                    message.getText().contains("name: user2") ||
                    message.getText().contains("name: user3"));

        }
    }

    @Test
    public void scroll() throws InterruptedException {
        driver.get("https://practice.cydeo.com/");
        Actions actions = new Actions(driver);

        WebElement cydeo = driver.findElement(By.xpath("//*[contains(text(), 'Powered')]"));
        actions.moveToElement(cydeo).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP).perform();

    }

    @Test
    public void jsscroll() throws InterruptedException {
        driver.get("https://practice.cydeo.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,750)");
        }
        Thread.sleep(2000);
        for (int i = 0; i < 10; i++) {
            js.executeScript("window.scrollBy(0,-750)");
        }

    }

    @Test
    public void jsscroll2() throws InterruptedException {
        driver.get("https://practice.cydeo.com/large");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement cydeo = driver.findElement(By.linkText("CYDEO"));
        WebElement home = driver.findElement(By.linkText("Home"));
        js.executeScript("arguments[0].scrollIntoView();", cydeo);
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView()", home);
    }
}
