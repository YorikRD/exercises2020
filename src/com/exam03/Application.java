package com.exam03;

import com.exam03.choiceSubclasses.ForestInGameAction;
import com.exam03.choiceSubclasses.Menu;
import com.exam03.choiceSubclasses.Saver;

public class Application {
    public static void main(String[] args) {
        MainField game = new MainField();
        game.startGame();
//        MainField game2 = new MainField();
//        Menu menu = new Menu(game2);
//        ForestInGameAction act0 = new ForestInGameAction(menu,game2,0);
//        Saver testsaver = new Saver(act0,game2);
//        testsaver.run();


    }
}
