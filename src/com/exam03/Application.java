package com.exam03;

import com.exam03.strategy.StrClass;

public class Application {
    public static void main(String[] args) {
        StrClass strategy = new StrClass();
        MainField game = new MainField(strategy);
        game.startGame();
    }
}
