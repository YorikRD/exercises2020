package com.exercisses20;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropReader {
    private static PropReader instance = null;
    private static final long serialVersionUID = 2L;

    private PropReader() {
    }

    public Properties fullRead(String path){
        Properties configPr = new Properties();
        try(InputStream inputStream = PropReader.class.getClassLoader().getResourceAsStream(path) ) {
            configPr.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configPr;
    }


    public static PropReader  getInstance (){
        PropReader propReader = null;
        if (instance == null) {
            propReader = new PropReader();
            instance = propReader;
        } else propReader = instance;
        return propReader;
    }


    public  String readFrProp(String path, String key){
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

    public  int intreadfropmProp(String path, String key){

        return Integer.parseInt(readFrProp(path, key));
    }
}
