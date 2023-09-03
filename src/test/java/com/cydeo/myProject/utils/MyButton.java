package com.cydeo.myProject.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class MyButton {
  public static void buttonClic(WebDriver driver, String text   ){
      ArrayList<WebElement> buttons = new ArrayList<>();
      buttons.addAll(driver.findElements(By.tagName("Button")));
      for (WebElement b : buttons) {
          if(b.getText().toLowerCase().contains(text.toLowerCase())){
              b.click();
          }
      }
  }
}
