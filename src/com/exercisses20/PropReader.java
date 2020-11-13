package com.exercisses20;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropReader {
    public static String readFrProp(String path, String key){
        String readed = null;
        Properties configPr = new Properties();
        try(InputStream inputStream = PropReader.class.getClassLoader().getResourceAsStream(path) ) {
            configPr.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        readed = configPr.getProperty(key);
        return  readed;
    }
}
