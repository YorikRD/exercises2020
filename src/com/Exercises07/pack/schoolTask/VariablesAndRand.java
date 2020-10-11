package com.Exercises07.pack.schoolTask;

public class VariablesAndRand {
    private static final String[] names ={"Ana","Zara","Tom","John","Olga","Peter","Nikolay","Leo","Rebeca","Cao"};
    private static final String[] surnames ={"Jimenez","Moore","Dotson","Forbes","Roach","Garza","Collins","Li","Sung","Colt"};
    private static final String[] disciplines ={"Maths","Physics","Chemistry","Anatomy","History","Literature","Geometry","Dance","Singing","Art"};


    public static int rand(int min, int max){
        return (int)(Math.random()*(max-min))+min;
    }

    public static String randName(){
        return names[rand(0,names.length)]+" "+surnames[rand(0,surnames.length)];
    }

    public static String randDisc(){
        return disciplines[rand(0,disciplines.length)];
    }
}
