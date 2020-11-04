package com.exercises15.arrListAndLinkedList;

import java.util.*;

public class Aplication {
    enum Place{
        BEGIN,MIDDLE,END
    }
    enum Acton{
        ADD,GET,REMOVE
    }

    public static void main(String[] args) {
        Employee single = Employee.employeeGenerator(1).get(0);
        ArrayList<Employee> arrayListEmp = (ArrayList<Employee>) Employee.employeeGenerator(12000);
        long startA = System.currentTimeMillis();
        int quant =6536;
        Aplication ap = new Aplication();
        System.out.println("---Arraylist---");
        ap.diff(arrayListEmp,single,quant,Place.BEGIN,Acton.ADD);
        ap.diff(arrayListEmp,single,quant,Place.BEGIN,Acton.GET);
        ap.diff(arrayListEmp,single,quant,Place.BEGIN,Acton.REMOVE);
        ap.diff(arrayListEmp,single,quant,Place.MIDDLE,Acton.ADD);
        ap.diff(arrayListEmp,single,quant,Place.MIDDLE,Acton.GET);
        ap.diff(arrayListEmp,single,quant,Place.MIDDLE,Acton.REMOVE);
        ap.diff(arrayListEmp,single,quant,Place.END,Acton.ADD);
        ap.diff(arrayListEmp,single,quant,Place.END,Acton.GET);
        ap.diff(arrayListEmp,single,quant,Place.END,Acton.REMOVE);

        LinkedList<Employee> employeeLinkedList = new LinkedList<>();
        employeeLinkedList.addAll(Employee.employeeGenerator(12000));
        System.out.println("---Linkedlist---");
        ap.diff( employeeLinkedList,single,quant,Place.BEGIN,Acton.ADD);
        ap.diff( employeeLinkedList,single,quant,Place.BEGIN,Acton.GET);
        ap.diff( employeeLinkedList,single,quant,Place.BEGIN,Acton.REMOVE);
        ap.diff( employeeLinkedList,single,quant,Place.MIDDLE,Acton.ADD);
        ap.diff( employeeLinkedList,single,quant,Place.MIDDLE,Acton.GET);
        ap.diff( employeeLinkedList,single,quant,Place.MIDDLE,Acton.REMOVE);
        ap.diff( employeeLinkedList,single,quant,Place.END,Acton.ADD);
        ap.diff( employeeLinkedList,single,quant,Place.END,Acton.GET);
        ap.diff( employeeLinkedList,single,quant,Place.END,Acton.REMOVE);
        System.out.println("---EmployeeSort---");
        LinkedList<Employee> sortedList = new LinkedList<>(Employee.employeeGenerator(25));
        Comparator<Employee> byName = new EmloyeeComparatorNm();
        Comparator<Employee>  byNameAge =new EmloyeeComparatorNm().thenComparing(new EmloyeeComparatorAge());
        Comparator<Employee> byNameAgeSalComp =new EmloyeeComparatorNm().thenComparing(new EmloyeeComparatorAge()).thenComparing(new EmloyeeComparatorSal()).thenComparing(new EmloyeeComparatorCmp());
        sortedList.sort(byName);
        System.out.println(" Only by name "+ sortedList);
        sortedList.sort(byNameAge);
        System.out.println(" Only by name & age "+ sortedList);
        sortedList.sort(byNameAgeSalComp);
        System.out.println(" by everything "+sortedList);

        List<Employee> unsortedList2 = new LinkedList<>(Employee.employeeGenerator(25));
        TreeSet<Employee> trByname = new TreeSet<>(new EmloyeeComparatorNm());
        trByname.addAll(unsortedList2);
        System.out.println(" Only by name "+ trByname);

        TreeSet<Employee> trByNameAge = new TreeSet<>(new EmloyeeComparatorNm().thenComparing(new EmloyeeComparatorAge()));
        trByNameAge.addAll(unsortedList2);
        System.out.println(" Only by name & age "+ trByNameAge);

        TreeSet<Employee> trEcr = new TreeSet<>(new EmloyeeComparatorNm().thenComparing(new EmloyeeComparatorAge()).thenComparing(new EmloyeeComparatorSal()).thenComparing(new EmloyeeComparatorCmp()));





    }

    private <T>   long diff (List<T> list, T obj, int times, Place place,Acton acton){
        long startA = System.currentTimeMillis();
        switch (acton){
            case ADD:
                for (int i = 0; i < times; i++) {
                    list.add(pos(place,list),obj);
                }
                break;
            case REMOVE:
                for (int i = 0; i < times; i++) {
                    list.remove(pos(place,list));
                }
                break;
            case GET:
                for (int i = 0; i < times; i++) {
                    list.get(pos(place,list));
                }
                break;
        }
        long finshA= System.currentTimeMillis();
        long result =finshA-startA;
        System.out.println("For list adding: " +times+" elements to "+place+" the time is: "+result+" for Action:"+acton);
        return result;

    }

    private<T> int pos(Place place, List<T> lt){

        switch (place){
            case BEGIN:
                return 0;
            case MIDDLE:
                return lt.size()/2;
            case END:
                return lt.size()-1;
        }
        return 0;
    }


}
