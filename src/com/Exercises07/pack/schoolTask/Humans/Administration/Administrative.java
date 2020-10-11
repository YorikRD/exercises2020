package com.Exercises07.pack.schoolTask.Humans.Administration;

import com.Exercises07.pack.schoolTask.VariablesAndRand;

public interface Administrative {
    void startSchoolDay();

    void finishSchoolday();

    static Director dirFoundry(String name, int age) {
        Director director = new Director(name, age);
        return director;
    }
    static Director dirRand() {
        Director director = new Director(VariablesAndRand.randName(), VariablesAndRand.rand(26,75));
        return director;
    }

}
