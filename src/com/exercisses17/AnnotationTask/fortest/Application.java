package com.exercisses17.AnnotationTask.fortest;

import com.exercises19.Aplication;
import com.exercisses17.AnnotationTask.dIcontainer.marks.ConfigClass;
import com.exercisses17.AnnotationTask.fortest.config.CatConfig;
import com.exercisses17.AnnotationTask.fortest.config.MouseConfig;
import com.exercisses17.AnnotationTask.fortest.config.OwnerConfig;

import java.io.*;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Set<Class> classes = new HashSet<>();
        classes.add(Cat.class);
        classes.add(Mouse.class);
        classes.add(Owner.class);
        classes.add(CatConfig.class);
        classes.add(MouseConfig.class);
        classes.add(OwnerConfig.class);

        classes.add(null);
        System.out.println(classes);
        Properties common = new Properties();
        common.put("cat.name","Tom");
        common.put("cat.sped","18");


        // TODO:: инициализация DI контейнера и тд
    }
}