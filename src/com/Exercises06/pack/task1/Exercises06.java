package com.Exercises06.pack.task1;

import java.util.Arrays;

public class Exercises06 {
    public static void main(String[] args){
        Mountain[] mountains ={new Mountain(),new Mountain(),new Mountain()};
        System.out.println(Arrays.toString(mountains));
        ClimberGroup climberGroup1 = new ClimberGroup(mountains[1],new Climber[]{new Climber(),new Climber(),new Climber()},false);
        System.out.println(climberGroup1);
        ClimberGroup climberGroup2 = new ClimberGroup(mountains[2],3);
        climberGroup2.addClimber(new Climber(),new Climber());
        System.out.println(climberGroup2);
        ClimberGroup climberGroup3 = new ClimberGroup(mountains[0],3);
        climberGroup3.addClimber(new Climber(),new Climber());
        System.out.println(climberGroup3);
        }

}
