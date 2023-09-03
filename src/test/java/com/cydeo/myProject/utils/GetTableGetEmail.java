package com.cydeo.myProject.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class GetTableGetEmail {
    public static void getEmail (WebDriver driver, int tableNum, String firstName){

            String table = "//table[@id='table"+tableNum+"']";
            ArrayList<WebElement> rows1 = new ArrayList<>(driver.findElements(By.xpath(table+"//tr")));

            int nameRow = 0;
            for (int i = 0; i < rows1.size(); i++) {
                if(rows1.get(i).getText().contains(firstName)){
                    nameRow+=i;
                }
            }

            ArrayList<WebElement> columns = new ArrayList<>(driver.findElements(By.xpath(table+"//tr[1]//th")));

            int fNameColumn = 1;
            for (int i = 0; i <columns.size()  ; i++) {
                if(columns.get(i).getText().contains("Email")){
                    fNameColumn+=i;
                }
            }


            String row = "//tr["+nameRow+"]";
            String column = "//td["+fNameColumn+"]";
            String email = table+row+column;

        System.out.println(driver.findElement(By.xpath(email)).getText());



    }
}
