package com.exercisses20.auxiliary;

import com.exercisses20.PropReader;

import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class Comands {
    private HashMap<String,String> allcomands = new HashMap<>();

    public Comands(String path) {
       PropReader reader = PropReader.getInstance();
        Properties properties = reader.fullRead(path);
       Set<Object> actualKeys = properties.keySet();
        for (Object actualKey : actualKeys) {
            String key = actualKey.toString();
            if (key.startsWith("/"))  allcomands.put(key,(properties.getProperty(key)));
        }
    }

    public HashMap<String,String> getAllcomands(){
        return allcomands;
    }
}
