package com.exercisses17;

import com.exam01.FitnessClub;
import com.exam01.PersonalData;
import com.exam01.Subscription;
import com.exam01.VariablesAndRand;

public class Apliction {

    public static void main(String[] args) {

        PersonalData[] personalData = VariablesAndRand.pdataFactory(1);
        Subscription[] subscriptions = VariablesAndRand.subfact(1,personalData);
        FitnessClub fc1 = new FitnessClub();
        fc1.subscrRegisstraion(subscriptions);

        try {
            System.out.println(ReflectionWorkingClass.showFiled(fc1));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
