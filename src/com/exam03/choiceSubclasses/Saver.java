package com.exam03.choiceSubclasses;

import com.exam03.MainField;

import java.io.*;

public class Saver extends ForestAction {


    public Saver(ChoiceClick previous, MainField wrap) {
        super(previous, wrap);
    }

    @Override
    public void run() {
        System.out.println("Please enter the game save title of your choice");
        String filename = new String();
        while (filename.isEmpty()){
            filename = wrap.getScanner().nextLine();
        }
        String path = null;
        if (!filename.equals(null)) {
           path = "src/com/exam03/saves/" + filename + ".save";
        }
        File thisGameFile = new File(path);
        System.out.println(path);
        try {
            thisGameFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Save file creation failed");
            e.printStackTrace();
            wrap.setCurrient(previous);
            return;
        }
        wrap.setCurrient(previous);
        try (FileOutputStream fops = new FileOutputStream(thisGameFile);
                ObjectOutputStream oops = new ObjectOutputStream(fops)
        ) {
            oops.writeObject(wrap);
        } catch (IOException e) {
            System.out.println("Save creation Failed");
            e.printStackTrace();
            return;
        }
        System.out.println("The game: "+filename +" successfully saved");
    }
}
