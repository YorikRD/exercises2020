package com.exam03;

import com.exam03.choiceSubclasses.ChoiceClick;
import com.exam03.choiceSubclasses.ExitAction;
import com.exam03.choiceSubclasses.Menu;
import com.exam03.strategy.Flaff;
import com.exam03.strategy.StrClass;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class MainField implements Serializable {
    /**
     * Field comtaining currient running action which automaticaly calls the next
     */
    private ChoiceClick currient;
    /**
     * List of priviously called actions.
     */
    private LinkedList<ChoiceClick> route;
    /**
     * System scanner which is used by all the actions
     */
    private transient Scanner scanner;
    /**
     * For serialisation
     */
    public final transient StrClass strategy;

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

    public MainField(StrClass strategy) {
        currient = new Menu(this);
        route = new LinkedList<>();
        Objects.requireNonNull(strategy);
        this.strategy = strategy;

    }

    /**
     * The main method which calls the currient action class untill meeting the ExitAction
     */
    protected void startGame(){
        scanner = new Scanner(System.in);
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

}
