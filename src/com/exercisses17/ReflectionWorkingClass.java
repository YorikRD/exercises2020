package com.exercisses17;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class ReflectionWorkingClass {
    public static String showFiled(Object o) throws IllegalAccessException {
        StringBuilder mainBuilder = new StringBuilder();
        if (o == null) return " nullValue ";
//        System.out.println("The object of " + o + " from class of " + o.getClass().getSimpleName() + " is Under analis");
        if (o.getClass().equals(LocalDate.class) ||
                o.getClass().equals(LocalDateTime.class) ||
                o.getClass().equals(LocalTime.class) ||
                o.getClass().isEnum() || o.getClass().equals(Integer.class))
            //Integer is added simply because
            // without it stack overflow occurs always
            return mainBuilder.append(o).toString();
        if (o.getClass().isPrimitive() || o.getClass().equals(String.class)) {
//            System.out.println("Primitive or string append is triggered with " + o.getClass() + " " + o);
            mainBuilder.append(o);
            return mainBuilder.toString();
        }
        Class objclass = o.getClass();
        if (objclass.isArray()) {
            mainBuilder.append(" Includes an array of: '\n'");
            for (int i = 0; i < Array.getLength(o); i++) {
                if (!showFiled(Array.get(o, i)).equals(null)) {
                    mainBuilder.append("At index of " + i + " ").append(showFiled(Array.get(o, i))).append("\n");
                }
            }
        }
//        TODO check for collection!
        ArrayList<Field> fields = new ArrayList<>(Arrays.asList(objclass.getDeclaredFields()));
//        System.out.println(fields);
        Class superclass = o.getClass().getSuperclass();
        while (!superclass.equals(Object.class)) {
            fields.addAll(Arrays.asList(superclass.getDeclaredFields()));
            superclass = superclass.getSuperclass();
        }
//        System.out.println("Field collection was created" + fields);
        for (Field field : fields) {
            field.setAccessible(true);
            mainBuilder.append("\n" + "The field of:" + field.getName() + "with value of: " + showFiled(field.get(o)));

        }

        return mainBuilder.toString();


    }
}
