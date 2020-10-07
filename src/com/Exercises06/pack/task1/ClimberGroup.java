package com.Exercises06.pack.task1;

import java.util.Arrays;

public class ClimberGroup {
    private Mountain mountain;
    private Climber[] groupClimbers;
    private boolean availableToJoin;

    public ClimberGroup(Mountain mountain, Climber[] groupClimbers, boolean availableToJoin) {
        this.mountain = mountain;
        this.groupClimbers = groupClimbers;
        this.availableToJoin = availableToJoin;
    }

    public ClimberGroup(Mountain mountain, int gropsize) {
        this.mountain = mountain;
        this.groupClimbers = new Climber[gropsize];
        this.availableToJoin = checkSpace();
    }


    public Mountain getMountain() {
        return mountain;
    }

    public Climber[] getGroupClimbers() {
        return groupClimbers;
    }

    public boolean isAvailableToJoin() {
        return availableToJoin;
    }

    public void setMountain(Mountain mountain) {
        if (mountain == null) throw new IllegalArgumentException("Mountain must be Existing mountain");
        this.mountain = mountain;
    }

    public void setGroupClimbers(Climber[] groupClimbers) {
        addClimber(getGroupClimbers());
    }

    private void setAvailableToJoin(boolean availableToJoin) {
        if (availableToJoin == checkSpace()) this.availableToJoin = availableToJoin;
    }

    private boolean checkSpace() {
        for (int i = 0; i < groupClimbers.length; i++) {
            if (groupClimbers[i]== null) {
                return true;
            }
        }
        return false;
    }

    public void addClimber(Climber... climbers) {
        if (this.availableToJoin == false) {
            System.out.println("Sorry there is no available positions in this group");
            return;
        }
        int avpos = 0;
        int inpnomb = 0;
        while (avpos < groupClimbers.length&&inpnomb<climbers.length) {
            if (groupClimbers[avpos] == null)
                {
                    groupClimbers[avpos] = climbers[inpnomb];
                    avpos++;
                    inpnomb++;
                } else {
                avpos++;
            }
        }
        if (avpos == groupClimbers.length){
            System.out.println("Its a pity, all available places are in use");
            setAvailableToJoin(false);
            if (inpnomb == climbers.length){
                System.out.println("All Climbres successfully joined the group");
            } else {
                for (int i = inpnomb; i < climbers.length; i++) {
                    System.out.println(climbers[i]+" was not able to join the group");
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ClimberGroup{" +
                "mountain=" + mountain +
                ", groupClimbers=" + Arrays.toString(groupClimbers) +
                ", avalibleToJoin=" + availableToJoin +
                '}';
    }
}
