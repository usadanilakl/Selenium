package com.cydeo.test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();


    static{

        try {

            FileInputStream file = new FileInputStream("config.properties");
            properties.load(file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProp(String key){
        return properties.getProperty(key);
    }

}
