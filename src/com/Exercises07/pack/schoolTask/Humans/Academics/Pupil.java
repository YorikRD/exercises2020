package com.Exercises07.pack.schoolTask.Humans.Academics;

public class Pupil extends Academics{

    public Pupil(String name, int age, String discipline, int discLev) {
        super(name, age, discipline, discLev);
    }

    @Override
    public String toString() {
        return  "\n" +"Pupil {" +
                " name= '" + name + '\'' +
                " age= '" + age +'\''+
                " discipline= '" + discipline + '\'' +
                " discLev=" + discLev +'\''+
                '}';
    }

}
