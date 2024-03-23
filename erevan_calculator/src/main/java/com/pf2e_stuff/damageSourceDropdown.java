package com.pf2e_stuff;

import javax.swing.JComboBox;

public class damageSourceDropdown extends damageSource{
    String[] choiceNames;
    Integer[] diceNumbers;
    Integer[] diceTypes;
    JComboBox<String> dropdown;
    //default constructor
    public damageSourceDropdown(String initName, String[] initNames, Integer[] initDice, Integer[] initDieTypes, GUI gui){
        super(initName, 0, 0);
        choiceNames = initNames;
        diceNumbers = initDice;
        diceTypes = initDieTypes;
        gui.addLabel(initName);
        dropdown = gui.addDropdown(initNames);
    }
    //existing dropdown
    public damageSourceDropdown(String initName, String[] initNames, Integer[] initDice, Integer[] initDieTypes, GUI gui, JComboBox<String> initDropdown){
        super(initName, 0, 0);
        choiceNames = initNames;
        diceNumbers = initDice;
        diceTypes = initDieTypes;
        gui.addLabel(initName);
        dropdown = initDropdown;
    }
    public int getDice(){
        int index = dropdown.getSelectedIndex();
        return diceNumbers[index];
    }
    public int getDieType(){
        int index = dropdown.getSelectedIndex();
        return diceTypes[index];
    }
    public JComboBox<String> getDropdown(){
        return dropdown;
    }
}