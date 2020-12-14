package com.exam03.choiceSubclasses;

public class ExitAction implements ChoiceClick {
    @Override
    public void run() {
        System.out.println("The game is closing");
    }
}
