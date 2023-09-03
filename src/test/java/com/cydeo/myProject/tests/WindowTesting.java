package com.cydeo.myProject.tests;

import com.cydeo.myProject.utils.Chrome;
import com.cydeo.myProject.utils.PR;
import org.openqa.selenium.By;
import org.testng.Assert;

public class WindowTesting {
    public static void main(String[] args) {
        String link = PR.getP("link");
        Chrome.getDriver().get(link);
        Assert.assertEquals(Chrome.getDriver().getTitle(), "Windows");
        System.out.println (Chrome.getDriver().getTitle());
        String curretWindow = Chrome.getDriver().getWindowHandle();
        Chrome.getDriver().findElement(By.linkText("Click Here")).click();
        for(String w : Chrome.getDriver().getWindowHandles()){
            if(!w.equals(curretWindow)){
                Chrome.getDriver().switchTo().window(w);
            }
        }
        Assert.assertEquals(Chrome.getDriver().getTitle(), "New Window"     );
        Chrome.end();


    }
}
