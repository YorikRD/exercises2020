package com.exercisses20;

public enum Comands {
    HELP("/help - List of available commands"),
    COUNT("/count - The number of connections"),
    PING("/ping - Time of Message reaching server and returning"),
    EXIT("/exit - Terminating the program");

    private String textanwer;
    Comands(String textanwer) {this.textanwer = textanwer; }

    public String getTextanwer() {
        return textanwer;
    }

}
