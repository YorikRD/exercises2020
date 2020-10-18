package com.Exam01;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class PersonalData {
    private String name;
    private String surname;
    private LocalDate burthdate;


    public PersonalData(String name, String surname,  LocalDate burthdate) {
        setName(name);
        setSurname(surname);
        setBurthdate(burthdate);
        setAge();
    }


    public PersonalData() {
        setName(VariablesAndRand.randName());
        setSurname(VariablesAndRand.randSurname());
        setAge();
        setBurthdate(LocalDate.now().minusYears(VariablesAndRand.rand(16,65)).minusMonths(VariablesAndRand.rand(0,12)).minusDays(VariablesAndRand.rand(0,31)));
    }

    private void setName(String name) {
        Objects.requireNonNull(name, "Persons name must be not null");
        if (name.isEmpty()) throw new IllegalArgumentException("The name must be feeled");
        this.name = name;
    }

    public LocalDate getBurthdate() {
        return burthdate;
    }

    private void setBurthdate(LocalDate burthdate) {
        if (burthdate.isAfter(LocalDate.now())) throw new IllegalArgumentException("Illegal birth date detected") ;
        this.burthdate = burthdate;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        Objects.requireNonNull(surname, "Persons name must be not null");
        if (surname.isEmpty()) throw new IllegalArgumentException("The name must be feeled");
        this.surname = surname;
    }

    private void setAge() {
        int age=(int) ChronoUnit.YEARS.between(this.burthdate,LocalDate.now());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonalData)) return false;

        PersonalData that = (PersonalData) o;


        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(that.getSurname()) : that.getSurname() != null) return false;
        return getBurthdate() != null ? getBurthdate().equals(that.getBurthdate()) : that.getBurthdate() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);

        result = 31 * result + (getBurthdate() != null ? getBurthdate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
