package com.exam01;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import static com.exam01.Subscription.Type.DAYTIME;

public class FitnessClub {
    private Subscription[] gym;
    private Subscription[] swimmingPool;
    private Subscription[] groupExercises;
    public final LocalTime opening;
    public final LocalTime closing;
    private LocalTime virtualTime;

    public FitnessClub() {
        this.gym = new Subscription[VariablesAndRand.maxInZone];
        this.swimmingPool = new Subscription[VariablesAndRand.maxInZone];
        this.groupExercises = new Subscription[VariablesAndRand.maxInZone];
        this.opening = VariablesAndRand.open;
        this.closing = VariablesAndRand.closing;
        this.virtualTime = LocalTime.of(12,0);
    }

    public LocalTime getVirtualTime() {
        return virtualTime;
    }

    public void setVirtualTime(LocalTime virtualTime) {
        this.virtualTime = virtualTime;
        timeClosing();
    }

    public Subscription[] getGym() {
        return gym;
    }

    public Subscription[] getSwimmingPool() {
        return swimmingPool;
    }

    public Subscription[] getGroupExercises() {
        return groupExercises;
    }

    public void subscrRegisstraion(Subscription... subscriptions) {
        if (!checkWorkingHours()) {
            System.out.println("Sorry the fitnesshall is closed now its avalible from " + opening + " to " + closing);
            return;
        }
        for (Subscription sb : subscriptions) {
            String chouce = sb.choseRandTr();
            if (checkSubdate(sb) && checkTime(sb)) addToZone(sb, chouce);
        }
    }

    private void addToZone(Subscription subscription, String choise) {
        if (!zoneAv(subscription, choise) || subscription.getTraintry() > 3) return;
        if (subIsUsedNow(subscription)) {
            System.out.println("thise subscription is used");
            return;
        }
        Subscription[] zone;
        switch (choise) {
            case "Gym":
                zone = this.gym;
                break;
            case "SwimmingPool":
                zone = this.swimmingPool;
                break;
            case "Group Exercises":
                zone = this.groupExercises;
                break;
            default:
                System.out.println("Unknown subscription type!");
                return;
        }
        for (int i = 0; i < zone.length; i++) {
            if (zone[i] == null) {
                zone[i] = subscription;
                System.out.println(subscription.getClient().getName()+" "+subscription.getClient().getSurname() + " attended training zone " + choise+" at "+LocalDate.now()+" "+virtualTime );
                return;
            }
        }
        System.out.println("Sorry" + subscription.getClient() + "there is no available place in chosen zone");
        subscription.trtryPles();
    }

    private boolean zoneAv(Subscription subscription, String choise) {
        for (int i = 0; i < subscription.getAvalibleZones().length; i++) {
            if (subscription.getAvalibleZones()[i] != null && subscription.getAvalibleZones()[i].equalsIgnoreCase(choise))
                return true;
        }
        System.out.println("Sorry " + subscription.getClient().getName() + " " + subscription.getClient().getSurname() + " your Subscription " + subscription.getType() + " this training Zone is not covered by your subscription");
        return false;
    }

    private boolean checkSubdate(Subscription subscription) {
        return  !(LocalDate.now().isAfter(subscription.getEndDate()) || LocalDate.now().isBefore(subscription.getRegDate()));


    }

    private boolean checkTime(Subscription subscription) {
        if (subscription.getType().equals(DAYTIME)) {
            return (virtualTime.isAfter(VariablesAndRand.stDayly) && virtualTime.isBefore(VariablesAndRand.endDayly));
        }
        return true; // because all other Subscription types are all-day inside working hours available
    }

    private boolean checkWorkingHours() {
       return  !(virtualTime.isBefore(opening) || virtualTime.isAfter(closing));

    }

    private boolean subIsUsedNow(Subscription subscription) { //it is much more easy to create flag in Subscription, but in my opinion the check must be hear.
        for (Subscription sb : this.gym) {
            if (sb != null && sb.equals(subscription)) return true;
        }
        for (Subscription sb : this.swimmingPool) {
            if (sb != null && sb.equals(subscription)) return true;
        }
        for (Subscription sb : this.groupExercises) {
            if (sb != null && sb.equals(subscription)) return true;
        }
        return false;
    }

    public void leaveZone(Subscription sb, Subscription[] zone) {
        Objects.requireNonNull(sb, "Require correct Subscription!");
        Objects.requireNonNull(zone, "Require correct Zone!");
        String zname;
        if (zone == gym) zname = VariablesAndRand.getZones()[0] + " area";
        else if (zone == swimmingPool) zname = VariablesAndRand.getZones()[1] + " area";
        else if (zone == groupExercises) zname = VariablesAndRand.getZones()[2] + " area";
        else zname = "Error";
        for (int i = 0; i < zone.length; i++) {
            if (zone[i] != null && zone[i].equals(sb)) {
                System.out.println("Client " + sb + "leaves " + zname);
                zone[i] = null;
            }
        }
    }

    public void leaveViaTimeZone(Subscription[] zone) {
        for (Subscription sb : zone) {
            if (sb != null && sb.getType().equals(DAYTIME) && virtualTime.isAfter(VariablesAndRand.endDayly))
                leaveZone(sb, zone);
            if (sb != null & virtualTime.isAfter(VariablesAndRand.closing)) leaveZone(sb, zone);
        }
    }

    public void timeClosing() {
        leaveViaTimeZone(this.gym);
        leaveViaTimeZone(this.swimmingPool);
        leaveViaTimeZone(this.groupExercises);
    }

    private void publishZone(Subscription[] zone) {
        String zoneN;
        if (zone == this.gym) zoneN = VariablesAndRand.getZones()[0];
        else if (zone == this.swimmingPool) zoneN = VariablesAndRand.getZones()[1];
        else if (zone == this.groupExercises) zoneN = VariablesAndRand.getZones()[2];
        else zoneN = " unknown";
        System.out.println("The " + zoneN + " is occupied by :");
        for (int i = 0; i < zone.length; i++) {
            if (zone[i] != null)
                System.out.println("Position #" + i + " Client " + zone[i].getClient() + " with sunbscription type of " + zone[i].getType());
        }
    }

    public void publishGym() {
        publishZone(gym);
    }

    public void publishSwim() {
        publishZone(swimmingPool);
    }

    public void publishGroup() {
        publishZone(groupExercises);
    }


}
