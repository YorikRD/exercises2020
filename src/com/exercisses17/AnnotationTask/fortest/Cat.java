package com.exercisses17.AnnotationTask.fortest;

import com.exercisses17.AnnotationTask.dIcontainer.marks.RequiredClass;
import com.exercisses17.AnnotationTask.dIcontainer.marks.RequiredField;
import com.exercisses17.AnnotationTask.fortest.config.CatConfig;

import java.util.ArrayList;

@RequiredClass
public class Cat {
    @RequiredField
    private CatConfig catConfig;
    private String name;
    private int speed;

    @RequiredField
    private Owner owner;

    private ArrayList<Mouse> mice = new ArrayList<>(20);

    public Cat() {
        name = catConfig.getCatName();
        speed = catConfig.getCatSpeed();
    }

    public void catchMouse(Mouse mouse) {
        if (speed < mouse.getSpeed()) {
            System.out.println(mouse.getName() + " убежал от " + name);
            return;
        }
        mice.add(mouse);
        System.out.println(name + " поймал " + mouse.getName());

    }

}