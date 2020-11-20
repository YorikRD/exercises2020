package com.exercisses22;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class University {
    private List<Course> courses = new ArrayList<>();

    public boolean addCourse(Course course) {
        return courses.add(Objects.requireNonNull(course));
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Course> getFilteredCourses(Predicate<Course> mark){
        List<Course> filtered = new ArrayList<>();
        for (Course cours : courses) {
            if (mark.test(cours)) filtered.add(cours);
        }
        return filtered;
    }

}
