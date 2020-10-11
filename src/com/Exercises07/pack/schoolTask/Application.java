package com.Exercises07.pack.schoolTask;

import com.Exercises07.pack.schoolTask.Humans.Administration.Administrative;
import com.Exercises07.pack.schoolTask.Humans.Administration.Director;

public class Application {
    public static void main(String[] args) {
      Director director1=  Administrative.dirRand();
        System.out.println(director1);
        School school = new School("St Astra school",14,12);
        school.shoolday();

    }

}
