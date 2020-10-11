package com.Exercises07.pack.schollTask.Humans;

abstract public class Human {
    protected String name;
    protected int age;

    protected Human(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null||name.isEmpty()) throw new IllegalArgumentException("The persons name must be proper! ");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    protected void setAge(int age) {
        if(age<=0) throw new IllegalArgumentException("The persons age must be of positive value! ");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
