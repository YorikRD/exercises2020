package com.Exercises07.pack.schoolTask;

import com.Exercises07.pack.schoolTask.Humans.Academics.Academics;
import com.Exercises07.pack.schoolTask.Humans.Academics.Pupil;
import com.Exercises07.pack.schoolTask.Humans.Academics.Teacher;
import com.Exercises07.pack.schoolTask.Humans.Administration.Administrative;
import com.Exercises07.pack.schoolTask.Humans.Administration.Director;

import java.util.Arrays;

public class School {
    private final String name;
    private Director director;
    private Teacher[] teachers;
    private Pupil[] pupils;


    public School(String name, Director director, Teacher[] teachers, Pupil[] pupils) {
        if (name.length()<3) throw new IllegalArgumentException("Shoolname must be longer then 3 symbols");
        this.name = name;
        setDirector(director);
        this.teachers = teachers;
        this.pupils = pupils;
    }

    public School(String name, int nombOfTeach, int nombOfpup) {
        if (name.length()<3) throw new IllegalArgumentException("School name must be longer then 3 symbols");
        this.name = name;
        setDirector(Administrative.dirRand());
        this.teachers = new Teacher[nombOfTeach];
        this.pupils = new Pupil[nombOfpup];
        feelPup();
        feelTeach();
    }

    public String getName() {
        return name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        if (director != null)
        this.director = director;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        this.teachers = teachers;
    }

    public Pupil[] getPupils() {
        return pupils;
    }

    public void setPupils(Pupil[] pupils) {
        this.pupils = pupils;
    }

    private void feelTeach(){
        for (int i = 0; i < teachers.length ; i++) {
            teachers[i]= Academics.teachRand();
        }
    }
    private void feelPup(){
        for (int i = 0; i < pupils.length; i++) {
            pupils[i]= Academics.pupRand();
        }
    }
    public void shoolday(){
        director.startSchoolDay();
        for (Teacher teach:teachers) {
            teach.instruct(pupils[VariablesAndRand.rand(0,pupils.length)]);
        }
        academicResults();
        director.finishSchoolday();
    }
    private void academicResults(){
        for (Pupil pupil:pupils) {
            if (pupil.getDiscLev()>pupil.getDisLevBase()) System.out.println("Pupil "+pupil.getName()+
                    " increased his Level in discipline "+pupil.getDiscipline()+
                    " from "+pupil.getDisLevBase()+" to " + pupil.getDiscLev() );
        }
    }



    @Override
    public String toString() {
        return "School{" +
                "name='" + name + "\n" +
                "Director=" + director +"\n"+
                "Teachers=" + Arrays.toString(teachers)+"\n"+
                "Pupils=" + Arrays.toString(pupils) +
                '}';
    }

}
