package com.exam03.choiceSubclasses;

import com.exam03.MainField;

public class ForestInGameAction extends ForestAction{
    int choice;

    public ForestInGameAction(ChoiceClick previous, MainField wrap, int choice) {
        super(previous, wrap);
        this.choice = choice;
    }

    @Override
    public void run() {
        System.out.println(Strategy.values()[choice].getText());
        System.out.println("3  - Load game  \";");
        System.out.println("4  - Save game  \";");
        int newChoice = wrap.getScanner().nextInt();
        if (newChoice<=0 || newChoice>=5){
            System.out.println("input a correct command please");
            run();
        }
        switch (newChoice){
            case 3:
                wrap.setCurrient(new Load(this,wrap));
                return;
            case 4:
                wrap.setCurrient(new Saver(this,wrap));
                return;
        }
        int next = Strategy.values()[choice].getLinks()[newChoice-1];
        if (next == -1){
            System.out.println("Victory");
            wrap.setCurrient(new Menu(wrap));
            return;
        } else if (next == -2){
            System.out.println("Defeat");
            wrap.setCurrient(new Menu(wrap));
            return;
        }

        wrap.setCurrient(new ForestInGameAction(this,wrap,next));

    }
}
