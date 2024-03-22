package com.pf2e_stuff;

import javax.swing.JComboBox;

public class damageSource {
    String name;
    int dice;
    int dieType;
    public damageSource(String initName, int initDice, int initDieType){
        name = initName;
        dice = initDice;
        dieType = initDieType;
    }
    public String getName(){
        return name;
    }
    public int getDice(){
        return dice;
    }
    public int getDieType(){
        return dieType;
    }
    public JComboBox<String> getDropdown(){
        return null;
    }
}
