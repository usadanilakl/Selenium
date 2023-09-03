package com.cydeo.test.practice;

import com.cydeo.test.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Eight {
    WebDriver driver;

    @BeforeMethod
    public void set ()  {
        driver = WebDriverFactory.create("Chrome");
    }

    @AfterMethod
    public void close ()    {
        driver.quit();
    }

    @Test
    public void locateElementsXpath(){
        driver.get("https://practice.cydeo.com/forgot_password");
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        Assert.assertEquals(homeLink.getText(), "Home");

        WebElement forgotPassword = driver.findElement(By.xpath("//div[@class='example']/h2"));
        Assert.assertEquals(forgotPassword.getText(), "Forgot Password");

        WebElement emailText = driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/label"));
        Assert.assertEquals(emailText.getText(), "E-mail");

        WebElement emailInput = driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/input"));
        Assert.assertEquals(emailInput.getAttribute("name"), "email");

        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));
        Assert.assertEquals(retrievePasswordButton.getText(), "Retrieve password");

        WebElement cydeoText = driver.findElement(By.xpath("//div[@class='large-4 large-centered columns']/div"));
        Assert.assertEquals(cydeoText.getText(), "Powered by CYDEO");
        

    }

    @Test
    public void locateCSS(){

        driver.get("https://practice.cydeo.com/forgot_password");

        WebElement home = driver.findElement(By.cssSelector("a[class"));
        System.out.println("home = " + home.getText());

        WebElement forgotText = driver.findElement(By.cssSelector("h2"));
        System.out.println("forgotText = " + forgotText.getText());

        WebElement emailText = driver.findElement(By.cssSelector("label[for]"));
        System.out.println("emailText = " + emailText.getText());

        WebElement emailInput = driver.findElement(By.cssSelector("input[type='text']"));
        System.out.println("email input = " + emailInput.getAttribute("name"));

        WebElement button = driver.findElement(By.cssSelector("button[id]"));
        System.out.println("button = " + button.getText()       );

        WebElement cydeo = driver.findElement(By.cssSelector("div[style]"));
        System.out.println("cydeo = " + cydeo.getText());
    }
}
