package com.cydeo.test.practice;

import com.cydeo.test.utils.Button;
import com.cydeo.test.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Twelve {
    WebDriver driver;

    @BeforeMethod
    public void set(){
        driver = WebDriverFactory.create("Chrome");
    }

    @Test
    public void title(){
        driver.get("https://www.cydeo.com");

        Assert.assertTrue(driver.getTitle().equals("Cydeo"));
    }

    @Test
    public void buttonTest(){
        driver.get("https://practice.cydeo.com/radio_buttons");
        Button.clickAndVerifyRadioButton(driver, "Hockey");
    }

    @Test
    public void dropdown(){
        driver.get("https://practice.cydeo.com/dropdown");
        WebElement dropdown = driver.findElement(By.cssSelector("select[id]"))   ;
        Select select = new Select(dropdown);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Please select an option");

    }

    @Test
    public void dropDownSelect(){
        driver.get(" https://practice.cydeo.com/dropdown");
        ArrayList<WebElement> drops = new ArrayList<>(driver.findElements(By.tagName("select"))) ;

        for(WebElement d : drops){
            Select select = new Select(d);
            if(d.getAttribute("id").equals("year")){
                select.selectByVisibleText("1933");
                System.out.println("select.getFirstSelectedOption() = " + select.getFirstSelectedOption().getText());
            } else if(d.getAttribute("id").equals("month")){
                select.selectByVisibleText("December");
                System.out.println("select.getFirstSelectedOption() = " + select.getFirstSelectedOption().getText());
            }else if(d.getAttribute("id").equals("day")){
                select.selectByVisibleText("1");
                System.out.println("select.getFirstSelectedOption() = " + select.getFirstSelectedOption().getText());
            }
        }

    }

    @Test
    public void state(){
        driver.get(" https://practice.cydeo.com/dropdown");
        WebElement stateSelect = driver.findElement(By.id("state"));
        Select select = new Select(stateSelect);
        select.selectByVisibleText("Illinois");
        select.selectByVisibleText("Virginia");
        select.selectByVisibleText("California");

        System.out.println(select.getFirstSelectedOption().getText());

//        ArrayList<WebElement> options = new ArrayList<>(select.getAllSelectedOptions());
//        for (WebElement o : options){
//            System.out.println(o.getText());
//        }
    }

    @Test
    public void nonSelectDrop() {

        driver.get("https://practice.cydeo.com/dropdown");

        WebElement drop = driver.findElement(By.id("dropdownMenuLink"));
        drop.click();
        driver.findElement(By.linkText("Facebook")).click();
        Assert.assertEquals(driver.getTitle(), "Facebook - log in or sign up");


//        ArrayList<WebElement> drops = new ArrayList<>(driver.findElements(By.tagName("a")));
//
//        for(WebElement d : drops){
//
//            if(d.getText().contains("Facebook")){
//                d.click();
//
//            }
//            System.out.println(d.getText());
//            System.out.println(d.getAttribute("href"));
//        }
//
//        Assert.assertEquals(driver.getTitle(), "Facebook - Log In or Sign Up");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }
}
