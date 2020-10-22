package com.Exercises11.planets;

public enum Planets {
    MERCURY(12,18000),VENUS(16,25000),EARTH(18,32000), MARS(19,40000),
    ;

    private final int massM;
    private final int radiusKm;
    private final int orbitrad;

    Planets(int radiusKm,int orbitrad) {
        this.radiusKm = radiusKm;
        this.massM = radiusKm * 4 / 3 * 3 * 1000;
        this.orbitrad =orbitrad;
    }

    public int getMassM() {
        return massM;
    }

    private int getRadiusKm() {
        return radiusKm;
    }

    public void getProp(){
        System.out.println(this +" planet"+"\n"+getRadiusKm()+" with radius "+"\n"+getMassM()+" with mass of "+"\n"+orbitrad +" with radius of planets orbit " );
    }

}
