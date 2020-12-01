package com.exam01;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Subscription {
    private LocalDate regDate;
    private LocalDate endDate;
    private PersonalData client;
    private String[] avalibleZones;
    private Type type;
    private int traintry;

    enum Type{
        SINGLEUSE,
        DAYTIME,
        FULL
    }

    public Subscription(LocalDate endDate, PersonalData client, Type type) {
        this.type = type;
        setRegDate(LocalDate.now());
        this.endDate =(type == Type.SINGLEUSE)? regDate:endDate;
        setClient(client);
        setAvalibleZones();
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    private void setRegDate(LocalDate regDate) {
        if(regDate.isBefore(LocalDate.now())) throw new IllegalArgumentException("Attempt to created Subscription postfactum detected!");
        this.regDate = regDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if(endDate.isBefore(LocalDate.now())) throw new IllegalArgumentException("Caution you are trying to create out of date Subscription");
        this.endDate = endDate;
    }

    public PersonalData getClient() {
        return client;
    }

    private void setClient(PersonalData client) {
        Objects.requireNonNull(client,"Subscription cannot be created without valid ClientMultiThread");
        this.client = client;
    }

    public String[] getAvalibleZones() {
        return avalibleZones;
    }

    private  void setAvalibleZones() {
        String[] avalibleZones =new String[3];
        switch (type){
            case SINGLEUSE:
                avalibleZones[0] = VariablesAndRand.getZones()[0]; //GYM
                avalibleZones[1] =VariablesAndRand.getZones()[1]; //SwimmingPool
                break;
            case DAYTIME:
                avalibleZones[0] = VariablesAndRand.getZones()[0];//GYM
                avalibleZones[1] = VariablesAndRand.getZones()[2];//Group Exercises
                break;
            case FULL:
                avalibleZones[0] = VariablesAndRand.getZones()[0];//GYM
                avalibleZones[1] =VariablesAndRand.getZones()[1]; //SwimmingPool
                avalibleZones[2] = VariablesAndRand.getZones()[2];//Group Exercises
        }
        this.avalibleZones = avalibleZones;
    }

    public Type getType() {
        return type;
    }

    public String choseRandTr(){
        int fchoice =VariablesAndRand.rand(0,3);
        return VariablesAndRand.getZones()[fchoice];
        }
    public void trtryPles(){
        traintry++;
        if (this.traintry ==5) System.out.println(toString() +" was tired od getting some training space and left");
    }

    public int getTraintry() {
        return traintry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription)) return false;

        Subscription that = (Subscription) o;

        if (getTraintry() != that.getTraintry()) return false;
        if (getRegDate() != null ? !getRegDate().equals(that.getRegDate()) : that.getRegDate() != null) return false;
        if (getEndDate() != null ? !getEndDate().equals(that.getEndDate()) : that.getEndDate() != null) return false;
        if (getClient() != null ? !getClient().equals(that.getClient()) : that.getClient() != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getAvalibleZones(), that.getAvalibleZones())) return false;
        return getType() == that.getType();
    }

    @Override
    public int hashCode() {
        int result = getRegDate() != null ? getRegDate().hashCode() : 0;
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        result = 31 * result + (getClient() != null ? getClient().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getAvalibleZones());
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + getTraintry();
        return result;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "regDate=" + regDate +
                ", endDate=" + endDate +
                ", client=" + client +
                ", avalibleZones=" + Arrays.toString(avalibleZones) +
                ", type=" + type +
                '}' +"\n";
    }
}
