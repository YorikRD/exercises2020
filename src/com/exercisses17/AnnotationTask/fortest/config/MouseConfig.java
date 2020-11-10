package com.exercisses17.AnnotationTask.fortest.config;

import com.exercisses17.AnnotationTask.dIcontainer.marks.ConfigClass;

@ConfigClass(file = "app.properties", prefix = "mouse")
public class MouseConfig {
    private String mouseName;
    private int mouseSpeed;

    public String getMouseName() {
        return mouseName;
    }

    public void setMouseName(String mouseName) {
        this.mouseName = mouseName;
    }

    public int getMouseSpeed() {
        return mouseSpeed;
    }

    public void setMouseSpeed(int mouseSpeed) {
        this.mouseSpeed = mouseSpeed;
    }
}