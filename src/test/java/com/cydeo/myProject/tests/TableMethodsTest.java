package com.cydeo.myProject.tests;

import com.cydeo.myProject.utils.Base;
import com.cydeo.myProject.utils.GetTableGetEmail;
import org.testng.annotations.Test;

public class TableMethodsTest extends Base {
    @Test
    public void getEmail(){
        driver.get("https://practice.cydeo.com/tables");
        GetTableGetEmail.getEmail(driver, 1, "John");
        GetTableGetEmail.getEmail(driver, 2,"Tim");

    }
}
