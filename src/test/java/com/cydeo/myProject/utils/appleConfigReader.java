package com.cydeo.myProject.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class appleConfigReader {
    private static Properties properties = new Properties();


    static{
        try{
            FileInputStream file = new FileInputStream("C:/Users/usada/IdeaProjects/Selenium/src/test/java/com/cydeo/myProject/utils/appleSearchConfig.properties");
            properties.load(file);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }


}
