package com.cydeo.test.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public static WebDriver create (String browserType){
        WebDriver driver;
        if(browserType.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
//            ChromeOptions option = new ChromeOptions();
//            option.setHeadless(true);
            driver = new ChromeDriver();
            return driver;
        } throw new IllegalArgumentException("Browser type not supported " + browserType);
    }
}
