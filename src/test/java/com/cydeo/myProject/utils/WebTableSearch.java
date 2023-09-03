package com.cydeo.myProject.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class WebTableSearch {
    public static String orderDate(WebDriver driver, String name){

        ArrayList<WebElement> columns = new ArrayList<>(driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[1]//th")));

        int dateColumn = 1;
        for (int i = 0; i < columns.size(); i++) {
            if(columns.get(i).getText().equals("Date")){
                dateColumn+=i;
            }
        }
        ArrayList<WebElement> rows = new ArrayList<> (driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr")));

        int rowIndex = 1;

        for (int i = 0; i < rows.size(); i++) {
            if(rows.get(i).getText().contains(name)){
                rowIndex+=i;
            }
        }

        String table = "//table[@id='ctl00_MainContent_orderGrid']";
        String column = "//td["+dateColumn+"]";
        String row = "//tr["+rowIndex+"]";
        String date = table+row+column;

        return driver.findElement(By.xpath(date)).getText();
    }

    public static void dateMatch(WebDriver driver, String name, String date){
        if(orderDate(driver,name).equals(date)){
            System.out.println("Order dates are matching for " + name);
        } else {
            System.out.println("Order dates are not matching for " + name);
        }
    }
}
