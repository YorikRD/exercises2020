package com.exam02.auxiliary;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Singletone class responsible for reading data from config.prop files
 */
public class PropReader {
    private static PropReader instance = null;
    private static final long serialVersionUID = 2L;

    private PropReader() {
    }

    /**
     *
     * @param path path to config.prop file
     * @return Properties readed
     */
    public Properties fullRead(String path){
        Properties configPr = new Properties();
        try(InputStream inputStream = PropReader.class.getClassLoader().getResourceAsStream(path) ) {
            configPr.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configPr;
    }

    /**
     * Access to class instance
     * @return
     */
    public static PropReader getInstance (){
        PropReader propReader = null;
        if (instance == null) {
            propReader = new PropReader();
            instance = propReader;
        } else propReader = instance;
        return propReader;
    }

    /**
     *
     * @param path path to config.prop file
     * @param key key for propertie to read
     * @return string readed
     */
    public  String readFrProp(String path, String key){
        Properties configPr = fullRead(path);
        String readed =  configPr.getProperty(key);
        return  readed;
    }

    /**
     *
     * @param path path to config.prop file
     * @param key key for propertie to read
     * @return return int value of propertie
     */
    public  int intreadfropmProp(String path, String key) throws NumberFormatException {

        return Integer.parseInt(readFrProp(path, key));
    }
}
