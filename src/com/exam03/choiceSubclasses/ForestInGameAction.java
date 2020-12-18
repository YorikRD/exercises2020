package com.exam03.choiceSubclasses;

import com.exam03.MainField;
import com.exam03.strategy.IStrategy;
import com.exam03.strategy.StrClass;

public class ForestInGameAction extends ForestAction {
    int choice;

    public ForestInGameAction(ChoiceClick previous, MainField wrap, int choice) {
        super(previous, wrap);
        this.choice = choice;
    }

    @Override
    public void run() {
        IStrategy thisStr = wrap.strategy;
        System.out.println(wrap.strategy.getTxt(choice));
        int forS = wrap.strategy.getLinks(choice).length+1;
        int forL = forS + 1;
        int forEx = forL + 1;
        System.out.println(" "+forS + "  - Save game  \";");
        System.out.println(" "+forL + "  - Load game  \";");
        System.out.println(" "+forEx + "  - Exit game  \";");

        int newChoice = wrap.getScanner().nextInt();
        if (newChoice <= 0 || newChoice > forEx) {
            System.out.println("input a correct command please");
            run();
        }
        if (newChoice == forS) {
            wrap.setCurrient(new Saver(this, wrap));
            return;
        } else if (newChoice == forL) {
            wrap.setCurrient(new Load(this, wrap));
            return;
        } else if (newChoice == forEx) {
            wrap.setCurrient(new ExitAction());
            return;
        }
        int next = wrap.strategy.getLinks(choice)[newChoice-1];
        wrap.setCurrient(new ForestInGameAction(this, wrap, next));

    }
}
