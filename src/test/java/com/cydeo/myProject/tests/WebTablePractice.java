package com.cydeo.myProject.tests;

import com.cydeo.myProject.utils.Base;
import com.cydeo.myProject.utils.WebTableSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class WebTablePractice extends Base {
    @Test
    public void bob(){
        driver.get("https://practice.cydeo.com/web-tables");
        ArrayList<WebElement> rows = new ArrayList<>(driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr")));

        int bobRow = 0;
        int dateColumn = 1;

        for (int i = 0; i < rows.size(); i++) {
            if(rows.get(i).getText().contains("Bob Martin") && rows.get(i).getText().contains("12/31/2021")){
                bobRow = i+1;
                System.out.println("Data matched, all good");
            }
        }

        WebElement rowBob = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+bobRow+"]"));

        WebElement rowOne = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[1]"));

        ArrayList <WebElement> columns = new ArrayList<>(rowOne.findElements(By.xpath("//th")));
        for(int i = 0; i<columns.size(); i++){
            if(columns.get(i).getText().contains("Date")){
                dateColumn += i;
            }
        }


        Assert.assertTrue(rowBob.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+bobRow+"]//td["+ dateColumn + "]")).getText().equals("12/31/2021"));
        

    }

    @Test
    public void methodTest(){
        driver.get("https://practice.cydeo.com/web-tables");
        System.out.println(WebTableSearch.orderDate(driver, "Bart"));
        WebTableSearch.dateMatch(driver, "Bart", "01/16/2021");
        WebTableSearch.dateMatch(driver, "Bob", "01/16/2021");
    }
}
