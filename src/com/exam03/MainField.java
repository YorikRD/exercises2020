package com.exam03;

import com.exam03.choiceSubclasses.ChoiceClick;
import com.exam03.choiceSubclasses.ExitAction;
import com.exam03.choiceSubclasses.Menu;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

public class MainField implements Serializable {
    private ChoiceClick currient;
    private LinkedList<ChoiceClick> route;
    private transient Scanner scanner;
    private static final long serialVersionUID = 1L;


    public ChoiceClick getCurrient() {
        return currient;
    }

    public void setCurrient(ChoiceClick currient) {
        this.currient = currient;
    }

    public LinkedList<ChoiceClick> getRoute() {
        return route;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setRoute(LinkedList<ChoiceClick> route) {
        this.route = route;
    }

    public MainField() {
        currient = new Menu(this);
        route = new LinkedList<>();

    }

    public void setScanner() {
        this.scanner = new Scanner(System.in);
    }

    protected void startGame(){
        scanner = new Scanner(System.in);
        StringBuilder story = new StringBuilder(" In the beginning: '\n'");
        while (!currient.getClass().equals(ExitAction.class)){
            currient.run();
            route.add(currient);
        }
        System.out.println("The game is aborted");
    }

    @Override
    public String toString() {
        return "MainField{scanner=" + scanner +
                '}';
    }

    public boolean scannerExisits(){
        return scanner.equals(null);
    }
}
