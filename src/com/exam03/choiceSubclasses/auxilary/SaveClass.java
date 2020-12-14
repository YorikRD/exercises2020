package com.exam03.choiceSubclasses.auxilary;

import com.exam03.choiceSubclasses.ChoiceClick;

import java.io.Serializable;
import java.util.LinkedList;

public class SaveClass implements Serializable {
    private ChoiceClick currient;
    private LinkedList<ChoiceClick> route;

    public SaveClass(ChoiceClick currient, LinkedList<ChoiceClick> route) {
        this.currient = currient;
        this.route = route;
    }

    public ChoiceClick getCurrient() {
        return currient;
    }

    public LinkedList<ChoiceClick> getRoute() {
        return route;
    }
}
