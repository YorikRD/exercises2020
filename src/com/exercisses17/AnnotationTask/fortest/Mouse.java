package com.exercisses17.AnnotationTask.fortest;

import com.exercisses17.AnnotationTask.dIcontainer.marks.RequiredClass;
import com.exercisses17.AnnotationTask.dIcontainer.marks.RequiredField;
import com.exercisses17.AnnotationTask.fortest.config.MouseConfig;

@RequiredClass
public class Mouse {
    @RequiredField
    private MouseConfig mouseConfig;
    private String name;
    private int speed;

    public Mouse() {
        name = mouseConfig.getMouseName();
        speed = mouseConfig.getMouseSpeed();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}