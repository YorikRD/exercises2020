package com.exercisses17.AnnotationTask.fortest.config;

import com.exercisses17.AnnotationTask.dIcontainer.marks.ConfigClass;

@ConfigClass(file = "app.properties", prefix = "owner")
public class OwnerConfig {
    private String ownerName;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}