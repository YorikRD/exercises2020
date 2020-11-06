package com.exercisses17;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class ReflectionWorkingClass {
    public static void showFiled(Object o) throws IllegalAccessException {
        if (o.equals(null)) return;
        if (o.getClass().isPrimitive()||o.getClass().equals(String.class)) System.out.println("This is instance of:  with a value of: "+o);
        Class objclass = o.getClass();
        LinkedList<Field> fields = new LinkedList<>(Arrays.asList(objclass.getDeclaredFields()));
        Class superclass =o.getClass().getSuperclass();
        while (!superclass.equals(Object.class)){
            fields.addAll(Arrays.asList(superclass.getDeclaredFields()));
            superclass = superclass.getSuperclass();
        }
        for (Field field : fields) {
            field.setAccessible(true);
           if (field.getType().isPrimitive()||field.getType().equals(String.class))
               { if (field.getModifiers()!=25) // added to cut of public static final fields used in abstract classes
                   System.out.println("The field of:" + field.getName() + "with value of: " + field.get(o));}
           else {
               showFiled(field.get(o));
           }
        }





    }

}
