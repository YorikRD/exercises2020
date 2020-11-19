package com.exercisses17.AnnotationTask.dIcontainer;

import com.exercisses17.AnnotationTask.dIcontainer.marks.ConfigClass;
import com.exercisses17.AnnotationTask.dIcontainer.marks.RequiredClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class DIContainer {
    HashMap<Class, Object> mainMap;
    HashSet<Class> ours;

    public DIContainer(Collection<Class> input) {
     addAllNotNull(input);
        for (Class clazz : ours) {

            }


    }

    private void addAllNotNull(Collection<Class> input){
        this.ours = new  HashSet();
        for (Class aClass : input) {
            if (aClass != null)  ours.add(aClass);
        }
    }

    /**
     *
     * @param clazz in current version works only with void consructors
     * @return returns an object.
     */
    private Object reflectiveCreator(Class clazz){
        Object o = null;
        if (clazz.isAnnotationPresent(RequiredClass.class)||clazz.isAnnotationPresent(ConfigClass.class)){




        }

        return o;
    }

}
