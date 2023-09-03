package com.cydeo.myProject.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PR {
   private static Properties p = new Properties();

    static{
        try{
            FileInputStream file = new FileInputStream("C:/Users/usada/IdeaProjects/Selenium/src/test/java/com/cydeo/myProject/utils/myProject.properties");
            p.load(file);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String getP(String key){
        return p.getProperty(key);
    }

}
