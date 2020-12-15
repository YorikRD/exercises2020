package com.exam03.choiceSubclasses;

import com.exam03.MainField;

public class Menu implements ChoiceClick {
    /**
     * Link to the running MainField,for using its Scanner & Strategy
     */
    private MainField wrap;
    private static final long serialVersionUID = 1L;

    public Menu(MainField wrap) {
        this.wrap = wrap;
    }

    /**
     * The method representing the games main menu.
     */
    @Override
    public void run() {
        System.out.println("Welcome to the forest adventure '\n'" +
                "Please input a number:  '\n'" +
                " 1 - Start the adventure '\n'"+
                " 2 - Load game '\n'" +
                " 3 - Exit game"
        );
      int choice = wrap.getScanner().nextInt();
      switch (choice){
          case 1:
              wrap.setCurrient(new ForestInGameAction(this,wrap,0));
              break;
          case 2:
              wrap.setCurrient(new Load(this,wrap));
              break;
          case 3:
              wrap.setCurrient(new ExitAction());
              break;
          default:
              System.out.println("Illegal input please select one from list");
              this.run();
      }
    }



}
