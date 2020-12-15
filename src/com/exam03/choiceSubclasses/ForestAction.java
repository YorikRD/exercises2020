package com.exam03.choiceSubclasses;

import com.exam03.MainField;

/**
 * Abstract class declaring using of the previous & wrap fields
 * is extended by all ChoiceClick classes except Menu and Exit classes
 */
public abstract class ForestAction implements ChoiceClick {
    /**
     * Represents the previous ChoiceClick exemplar
     */
    protected ChoiceClick previous;
    /**
     * Link to the running MainField,for using its Scanner & Strategy
     */
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
