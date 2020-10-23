package com.Exercises12Exeptions.task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class T1ExClass {
    enum Status{
        FILE_NOT_FOUND,ACCESS_DENIED,JAR_ERROR
    }
   static   void exthrover (Status status) throws AccessDeniedException, FileNotFoundException, JarException {
        switch (status){
            case FILE_NOT_FOUND:
                throw new FileNotFoundException("Called FileNotFoundException");
            case ACCESS_DENIED:
                File somefile;
                throw new AccessDeniedException("Called AccessDeniedException");
            case JAR_ERROR:
                throw new JarException("Called JarException");
        }

    }
}
