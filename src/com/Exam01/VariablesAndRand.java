package com.Exam01;

import java.time.LocalDate;
import java.time.LocalTime;

public class VariablesAndRand {
    private static final String[] names ={"Ana","Zara","Tom","John","Olga","Peter","Nikolay","Leo","Rebeca","Cao"};
    private static final String[] surnames ={"Jimenez","Moore","Dotson","Forbes","Roach","Garza","Collins","Li","Sung","Colt"};
    private static final  String[] zones ={"Gym","SwimmingPool","Group Exercises"};
    public static final int maxInZone =20;
    public static final LocalTime open =LocalTime.of(8,0);
    public static final LocalTime closing =LocalTime.of(22,0);
    public static final LocalTime stDayly =LocalTime.of(8,0);
    public static final LocalTime endDayly =LocalTime.of(16,0);

    public static PersonalData[] pdataFactory(int length){
        PersonalData[] personalData =new  PersonalData[length];
        for (int i = 0; i < length; i++) {
            personalData[i]=new PersonalData(randName(),randSurname(), LocalDate.now().minusDays(rand(5240,29200)));
        }

        return personalData;
    }
    public static Subscription[] subfact(int nomb, PersonalData[] ps){
        Subscription[] subscriptions = new Subscription[nomb];
        for (int i = 0; i < nomb; i++) {
            int rnd =rand(0,3);
            Subscription.Type type;
            switch (rnd){
                case 1:
                    type = Subscription.Type.DAYTIME;
                    break;
                case 2:
                    type = Subscription.Type.FULL;
                    break;
                default:
                    type = Subscription.Type.SINGLEUSE;
            }
            subscriptions[i] = new Subscription(LocalDate.now().plusDays(rand(31,365)),ps[rand(0,ps.length)],type);
        }
        return subscriptions;
    }


    public static String[] getZones() {
        return zones;
    }

    public static int rand(int min, int max){
        return (int)(Math.random()*(max-min))+min;
    }
    public static String randName(){
        return names[rand(0,names.length)];
    }
    public static String randSurname(){
        return surnames[rand(0,surnames.length)];
    }



}
