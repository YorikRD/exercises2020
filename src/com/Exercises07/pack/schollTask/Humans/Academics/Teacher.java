package com.Exercises07.pack.schollTask.Humans.Academics;

public class Teacher extends Academics {

    protected Teacher(String name, int age, String discipline, int discLev) {
        super(name, age, discipline, discLev);

    }
    public void instruct(Academics listener){
        if (this.discipline == listener.discipline&&this.discLev>=listener.discLev+2) listener.learn();
    }
    @Override
    public String toString() {
        return  "\n" +"Teacher {" +
                " name='" + name + '\'' +
                " age=" + age +'\''+
                "discipline='" + discipline + '\'' +
                " discLev=" + discLev +'\''+
                '}';
    }

}
