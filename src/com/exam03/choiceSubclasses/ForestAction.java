package com.exam03.choiceSubclasses;

import com.exam03.MainField;

import java.io.Serializable;

public abstract class ForestAction implements ChoiceClick, Serializable {
    protected ChoiceClick previous;
    protected MainField wrap;

    public ForestAction(ChoiceClick previous, MainField wrap) {
        this.previous = previous;
        this.wrap = wrap;
    }

    @Override
    public void run() {

    }

    public void setWrap(MainField wrap) {
        this.wrap = wrap;
    }
}
