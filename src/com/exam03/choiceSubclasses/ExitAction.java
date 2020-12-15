package com.exam03.choiceSubclasses;


/**
 * The only action breaking the .startgame() method of the main class
 */
public class ExitAction implements ChoiceClick {
    @Override
    public void run() {
        System.out.println("The game is closing");
    }
}
