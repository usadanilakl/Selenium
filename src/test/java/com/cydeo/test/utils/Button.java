package com.cydeo.test.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;

public class Button {

    public static void clickAndVerifyRadioButton(WebDriver driver, String text){
        ArrayList<WebElement> buttons = new ArrayList<>(driver.findElements(By.tagName("button")));
        for (WebElement button : buttons){
            if(button.getText().equals(text)) {
                button.click();
                Assert.assertEquals(button.isSelected(), "ture");
            }
        }
    }

    public static void clickAndVerifyRadioButton(WebDriver driver, String attribute, String id){
        ArrayList<WebElement> buttons = new ArrayList<>(driver.findElements(By.tagName("button")));
        for (WebElement button : buttons){
            if(button.getAttribute(attribute).equals(id)) {
                button.click();
                Assert.assertEquals(button.isSelected(), "ture");
            }
        }
    }
}
