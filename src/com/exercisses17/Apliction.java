package com.exercisses17;

import com.Exercises07.pack.schoolTask.Humans.Academics.Academics;
import com.Exercises07.pack.schoolTask.Humans.Academics.Pupil;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Apliction {
    public static void main(String[] args) {

      Pupil pupil = Academics.pupRand();
        try {
            ReflectionWorkingClass.showFiled(pupil);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
