package com.exercisses17.AnnotationTask.fortest.config;

import com.exercisses17.AnnotationTask.dIcontainer.marks.ConfigClass;

@ConfigClass(file = "app.properties", prefix = "cat")
public class CatConfig {
    private String catName;
    private int catSpeed;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatSpeed() {
        return catSpeed;
    }

    public void setCatSpeed(int catSpeed) {
        this.catSpeed = catSpeed;
    }
}
