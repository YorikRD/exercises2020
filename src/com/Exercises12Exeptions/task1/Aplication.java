package com.Exercises12Exeptions.task1;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class Aplication {


    public static void main(String[] args) {
        try {
            runStat(T1ExClass.Status.FILE_NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            runStat(T1ExClass.Status.ACCESS_DENIED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            runStat(T1ExClass.Status.JAR_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    static void runStat(T1ExClass.Status status) throws Exception {
        try {
            T1ExClass.exthrover(status);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "Some String ");
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage() + "Some Str ");
            throw new Exception("some manual exeption Finish");
        } catch (JarException e) {
            e.printStackTrace();

        }
    }
}
