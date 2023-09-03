package com.cydeo.myProject.tests;

import com.cydeo.myProject.utils.Chrome;
import com.cydeo.myProject.utils.PR;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTesting {
    @Test
    public void iframePractice(){
        String link = PR.getP("link");
        Chrome.getDriver().get(link);
        Chrome.getDriver().switchTo().frame(0);
        Assert.assertEquals(Chrome.getDriver().findElement(By.tagName("p")).getText(), "Your content goes here.");
        Chrome.getDriver().switchTo().defaultContent();
        System.out.println(Chrome.getDriver().findElement(By.tagName("h3")).getText());
        Assert.assertEquals(Chrome.getDriver().findElement(By.tagName("h3")).getText(), "An iFrame containing the TinyMCE WYSIWYG Editor");
        Chrome.end();
    }
}
