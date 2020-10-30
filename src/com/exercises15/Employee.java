package com.exercises15;

import com.exam01.VariablesAndRand;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    private Employee(String name, String company, int salary, int age) {
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    private void setCompany(String company) {
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    private void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }
// TODO: конструктор, геттеры и сеттеры

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(names[VariablesAndRand.rand(0,names.length)],
                    companies[VariablesAndRand.rand(0,companies.length)],
                    VariablesAndRand.rand(21,60),
                    VariablesAndRand.rand(60000,135000)  )); // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
        }
        return employees;
    }
}

class EmloyeeComparatorNm implements Comparator<Employee>{
    @Override
    public int compare(Employee employee, Employee t1) {
        return employee.getName().compareTo(t1.getName());
    }
}
class EmloyeeComparatorCmp implements Comparator<Employee>{
    @Override
    public int compare(Employee employee, Employee t1) {
        return employee.getCompany().compareTo(t1.getCompany());
    }
}
class EmloyeeComparatorSal implements Comparator<Employee>{
    @Override
    public int compare(Employee employee, Employee t1) {
        return Integer.compare(employee.getSalary(),t1.getSalary());
    }
}

class EmloyeeComparatorAge implements Comparator<Employee>{
    @Override
    public int compare(Employee employee, Employee t1) {
        return Integer.compare(employee.getAge(),t1.getAge());
    }
}