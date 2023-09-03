package com.cydeo.myProject.tests;

import com.cydeo.myProject.utils.Chrome;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowHandling {
    @Test
    public void multiWindow(){
        Chrome.getDriver().get("https://amazon.com");
        JavascriptExecutor js = (JavascriptExecutor) Chrome.getDriver();
        js.executeScript("window.open('http://google.com','_blank')");
        js.executeScript("window.open('http://etsy.com','_blank')");
        js.executeScript("window.open('http://facebook.com','_blank')");

        for(String w : Chrome.getDriver().getWindowHandles()){
            Chrome.getDriver().switchTo().window(w);
            if(Chrome.getDriver().getTitle().contains("Etsy")){
                break;
            }
        }

        Assert.assertTrue(Chrome.getDriver().getTitle().contains("Etsy") );
        Chrome.end();


    }
}
