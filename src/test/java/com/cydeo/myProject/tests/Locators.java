package com.cydeo.myProject.tests;

import com.cydeo.myProject.utils.Chrome;
import com.cydeo.myProject.utils.PR;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Locators {
    @Test
    public void locators(){
        String link = PR.getP("link");
        Chrome.getDriver().get(link);
        Chrome.getDriver().findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        Alert alert = Chrome.getDriver().switchTo().alert();
        alert.accept();
        Chrome.getDriver().switchTo().defaultContent();
        Assert.assertEquals(Chrome.getDriver().findElement(By.id("result")).getText(),
                "You clicked: Ok");
        Chrome.end();

        Chrome.getDriver().get(link);
        Chrome.getDriver().findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        Alert alert1 = Chrome.getDriver().switchTo().alert();
        alert1.sendKeys("hello");
        alert1.accept();
        Chrome.getDriver().switchTo().defaultContent();
        Assert.assertEquals(Chrome.getDriver().findElement(By.id("result")).getText(), "You entered: hello");
        Chrome.end();
    }
}
