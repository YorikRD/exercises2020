package com.exam03.choiceSubclasses;

import com.exam03.MainField;
import com.exam03.auxilary.SaveClass;

import java.io.*;

/**
 * The ChoiceClick implementation responsible for loading files from save games.
 */
public class Load extends ForestAction {
    public Load(ChoiceClick previous, MainField wrap) {
        super(previous, wrap);
    }

    @Override
    public void run() {
        File[] files = new File("C:\\Users\\Алексей\\IdeaProjects\\Exercises 2020\\src\\com\\exam03\\saves").listFiles();
        System.out.println("Please input nomber of the desired save");
        System.out.println(wrap.getScanner());
        for (int i = 0; i < files.length; i++) {
            System.out.println(i + 1 + " - " + files[i].getName());
        }
        int choice = wrap.getScanner().nextInt();
        if (choice < 1 || choice > files.length) {
            System.out.println("Please input correct number");
            run();
        }
        System.out.println("choice leads to: " +files[choice-1]);
        try(FileInputStream fis = new FileInputStream(files[choice-1]);
            ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            Object obj = ois.readObject();
            SaveClass loaded =(SaveClass)obj;
            ForestAction next = (ForestAction) loaded.getCurrient();
            next.setWrap(wrap);
            wrap.setCurrient(next);
            wrap.setRoute(loaded.getRoute());
            System.out.println("game successfully loaded");
//            System.out.println("notNull ="+ wrap.scannerExisits());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
