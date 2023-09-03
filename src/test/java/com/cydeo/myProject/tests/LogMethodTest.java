package com.cydeo.myProject.tests;

import com.cydeo.myProject.utils.Chrome;
import com.cydeo.myProject.utils.LoginMethod;

public class LogMethodTest {
    public static void main(String[] args) {
        LoginMethod.login(Chrome.getDriver());
        Chrome.end();
    }
}
