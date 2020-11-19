package com.exsercisses22;


import com.Exercises07.pack.schoolTask.Humans.Academics.Academics;
import com.Exercises07.pack.schoolTask.Humans.Academics.Pupil;
import com.exercises15.compare.Car;
import com.exercisses20.SimpleMessage;

import java.io.Serializable;
import java.util.*;
import java.util.function.*;

public class ApplicationL21 {
    public static void main(String[] args) {
        System.out.println("----- Predicates-----");
        Predicate <Object> hasParrentClNoO = obg -> obg.getClass().getSuperclass() != Object.class;
        Pupil pupil = Academics.pupRand();
        System.out.println("Object has parrent other then Object "+hasParrentClNoO.test(pupil));
        Predicate <Object> isSerialisable = obj ->  Serializable.class.isAssignableFrom(obj.getClass());
        SimpleMessage test = new SimpleMessage("Me", "lalalal");

        System.out.println("Object is Serialisable "+isSerialisable.test(test));
        System.out.println("Object is Serialisable "+isSerialisable.test(pupil));

        System.out.println("----- Function-----");
        ArrayList<Academics> baze = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            baze.add(Academics.pupRand());
            baze.add(Academics.teachRand());
        }

        Function <List<Academics>, Map<String, ArrayList<Academics>>> packByDiscipline = list ->{
            Map<String, ArrayList<Academics>> out = new HashMap<>();
            for (Academics academics : list) {
                String disc = academics.getDiscipline();
                if (out.containsKey(disc)) out.get(disc).add(academics);
                else {
                    ArrayList<Academics> newA = new ArrayList<>();
                    newA.add(academics);
                    out.put(disc,newA);
                }
            }
            return out;
        };
        Map<String, ArrayList<Academics>> map =packByDiscipline.apply(baze);

        for (String s : map.keySet()) {
            System.out.println(s+": ");
            System.out.println(map.get(s));

        }

        System.out.println("-----UnaryOperator-----");
        UnaryOperator<University> withReverseCoursreOrder = university -> {
            Objects.requireNonNull(university);
            University other = new University();
            ArrayList<Course> bazeList = new ArrayList<>(university.getCourses());
            Collections.reverse(bazeList);
            return other;
        };

        UnaryOperator<Course> courseWithDiscount = course -> {
            Course other = Course.getInstance();
            other.setPrice(course.getPrice()*2/3);
            return other;
        };
        System.out.println("-----BinaryOperator-----");

        BinaryOperator<Course> priceFiersDurSec = (c1,c2)->{
            Course other = Course.getInstance();
            other.setPrice(c1.getPrice());
            other.setDuration(c2.getDuration());
            return other;
        };


        BinaryOperator<University> mergeUniv =(u1, u2) ->{
            University other = new University();
            List<Course> f1 = u1.getCourses();
            List<Course> f2 = u2.getCourses();
            for (Course course : f1) {
             other.addCourse(course);
            }
            for (Course course : f2) {
                other.addCourse(course);
            }
            return other;
        };

        System.out.println("-----Consumer-----");
        Consumer<Course> priceUpper10_000 = course -> course.setPrice(course.getPrice()+10_000);
        Consumer<String> trimToLowerCase = string -> string.trim().toLowerCase();


        System.out.println("-----Comparator-----");
        Comparator<Car> carColourComparator = (car1, car2 ) ->{
            return car1.getColor().compareToIgnoreCase(car2.getColor());
        };

        Comparator<Car> carBrandComparati = (car1, car2 ) ->{
            return car1.getBrand().compareToIgnoreCase(car2.getBrand());
        };

        Comparator<Car> carPriceComparator = Comparator.comparingInt(Car::getPrice);

        Predicate<Course> timeThreeMounths = course -> course.getDuration()<3;
        Predicate<Course> priceLess20000 = course -> course.getPrice()<20000;
        Predicate<Course> titleIsJJD = course -> course.getName().equals("JJD");

        University uni1 = new University();
        for (int i = 0; i < 22 ; i++) {
            uni1.addCourse(Course.getInstance());
        }
        System.out.println(uni1.getFilteredCourses(timeThreeMounths));
        System.out.println(uni1.getFilteredCourses(priceLess20000));
        System.out.println(uni1.getFilteredCourses(titleIsJJD));
        System.out.println(uni1.getFilteredCourses(timeThreeMounths.and(priceLess20000)));
        System.out.println(uni1.getFilteredCourses(timeThreeMounths.and(priceLess20000).or(titleIsJJD)));

        System.out.println(uni1.getCourses());
       List<Course> all =  uni1.getCourses();
        for (Course course : all) {
            priceUpper10_000.accept(course);
        }
        System.out.println(uni1.getCourses());

        //


    }
}
