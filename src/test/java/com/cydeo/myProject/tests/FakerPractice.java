package com.cydeo.myProject.tests;

import com.cydeo.myProject.utils.Base;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FakerPractice extends Base {
    @Test
    public void form(){

        Faker faker = new Faker();
        String fName = "Danil";
        String lName = "Klokov";
        String uName = fName.charAt(0)+lName.toLowerCase();
        String email = uName+"@gmail.com";
        String password = "123456789";
        String phone = "333-333-3333";
        Date date = faker.date().birthday();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        String dob = format.format(date);

        driver.get("https://practice.cydeo.com/registration_form");
        ArrayList<WebElement> inputs = new ArrayList<>(driver.findElements(By.tagName("input") ));
        for(WebElement w : inputs){
            if(w.getAttribute("name").equals("firstname")) w.sendKeys(fName);
            if(w.getAttribute("name").equals("lastname")) w.sendKeys(lName);
            if(w.getAttribute("name").equals("username")) w.sendKeys(uName);
            if(w.getAttribute("name").contains("email")) w.sendKeys(email.toLowerCase());
            if(w.getAttribute("name").equals("password")) w.sendKeys(password);
            if(w.getAttribute("name").equals("phone")) w.sendKeys(phone);
            if(w.getAttribute("value").equals("male")) w.click();
            if(w.getAttribute("name").equals("birthday")) w.sendKeys(dob);
            if(w.getAttribute("value").equals("java")) w.click();
        }

        ArrayList<WebElement> selects = new ArrayList<>(driver.findElements(By.tagName("select")));
        for(WebElement w : selects){
            Select select = new Select(w);
            if(w.getAttribute("name").equals("department")){
                select.selectByVisibleText("Department of Engineering");
            }
            if(w.getAttribute("name").equals("job_title")){
                select.selectByVisibleText("SDET");
            }
        }
        driver.findElement(By.id("wooden_spoon")).click();
        System.out.println(driver.findElement(By.xpath("//p")).getText());

    }
}
