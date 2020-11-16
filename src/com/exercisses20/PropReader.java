package com.exercisses20;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropReader {
    private static PropReader instance = null;

    private PropReader() {
        instance= this;
    }


    public static String readBySingle (String path, String key){
        PropReader propReader = null;
        if (instance == null) {
            propReader = new PropReader();
        } else propReader = instance;
        return propReader.readFrProp(path, key);
    }


    private   String readFrProp(String path, String key){
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

    public static int intreadfropmProp(String path, String key){

        return Integer.parseInt(readBySingle(path, key));
    }
}
