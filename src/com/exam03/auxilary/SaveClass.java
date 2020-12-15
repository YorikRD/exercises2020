package com.exam03.auxilary;

import com.exam03.choiceSubclasses.ChoiceClick;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Class created for saving bouth currient game value and its history
 */
public class SaveClass implements Serializable {
    /**
     * The main property of save file
     */
    private ChoiceClick currient;
    /**
     * Secondary property creates for simple story-collecting
     */
    private LinkedList<ChoiceClick> route;
    private static final long serialVersionUID = 1L;


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
