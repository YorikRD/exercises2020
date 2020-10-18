package com.Exam01;

import java.sql.Array;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now().minusDays(2);
        System.out.println(date);
        int a = (int)ChronoUnit.DAYS.between(date,LocalDate.now());
        System.out.println(a);
        PersonalData[] personalData = VariablesAndRand.pdataFactory(60);
//        System.out.println(Arrays.toString(personalData));
        Subscription[] subscriptions =VariablesAndRand.subfact(60,personalData);
        FitnessClub fc1 = new FitnessClub();
        fc1.subscrRegisstraion(subscriptions);
        fc1.publishGym();
        fc1.publishSwim();
        fc1.publishGroup();
        fc1.setVirtualTime(LocalTime.of(18,0));

    }
}
