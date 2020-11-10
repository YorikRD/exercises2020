package com.exercisses17.AnnotationTask.fortest;

import com.exercisses17.AnnotationTask.dIcontainer.marks.RequiredClass;
import com.exercisses17.AnnotationTask.dIcontainer.marks.RequiredField;
import com.exercisses17.AnnotationTask.fortest.config.OwnerConfig;

@RequiredClass
public class Owner {
    @RequiredField
    private OwnerConfig ownerConfig;
    private String name;

    public Owner() {
        this.name = ownerConfig.getOwnerName();
    }
}