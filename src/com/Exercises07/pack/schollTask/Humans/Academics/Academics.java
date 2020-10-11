package com.Exercises07.pack.schollTask.Humans.Academics;

import com.Exercises07.pack.schollTask.Humans.Human;
import com.Exercises07.pack.schollTask.VariablesAndRand;

abstract public class Academics extends Human implements CanLearn {

    protected String discipline;
    protected int discLev;
    final int disLevBase;
    public static final int pupMinAge = 8;
    public static final int pupMaxAge = 17;
    public static final int pupMinDislevStart = 0;
    public static final int pupMaxDislevSteart = 12;
    public static final int tecahMinAge = 21;
    public static final int teachMaxAge = 75;
    public static final int teachMinDislevStart = 22;
    public static final int teachMaxDislevSteart = 40;

    public int getDisLevBase() {
        return disLevBase;
    }

    public Academics(String name, int age, String discipline, int discLev) {
        super(name, age);
        this.discipline = discipline;
        this.discLev = discLev;
        disLevBase=discLev;
    }

    public static Pupil pupRand() {
        Pupil pupil = new Pupil(VariablesAndRand.randName(),
                VariablesAndRand.rand(pupMinAge, pupMaxAge),
                VariablesAndRand.randDisc(),
                VariablesAndRand.rand(pupMinDislevStart, pupMaxDislevSteart));
        return pupil;
    }

    public static Teacher teachRand() {
        Teacher teacher = new Teacher(VariablesAndRand.randName(),
                VariablesAndRand.rand(tecahMinAge, teachMaxAge),
                VariablesAndRand.randDisc(),
                VariablesAndRand.rand(teachMinDislevStart, teachMaxDislevSteart));
        return teacher;
    }

    public String getDiscipline() {
        return discipline;
    }

    public int getDiscLev() {
        return discLev;
    }

    public void setDiscLev(int discLev) {
        if (discLev < 0) throw new IllegalArgumentException("It is not possible for discipline level to be negative");
        this.discLev = discLev;
    }

    @Override
    public String toString() {
        return "Academics{" +
                ", name='" + name + '\'' +
                ", age=" + age +"\n"+
                "discipline='" + discipline + '\'' +
                ", discLev=" + discLev +"\n"+
                '}';
    }

    @Override
    public void learn() {
        discLev = discLev + 2;
    }


}
