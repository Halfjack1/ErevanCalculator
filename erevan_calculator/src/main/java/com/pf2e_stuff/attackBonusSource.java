package com.pf2e_stuff;

import javax.swing.JCheckBox;

public class attackBonusSource {
    String name;
    int[] bonuses = new int[3];

    public attackBonusSource(String name, int bonus){
        this.name = name;
        bonuses[0] = bonus;
        bonuses[1] = bonus;
        bonuses[2] = bonus;
    }
    public attackBonusSource(String name, int[] bonuses){
        this.name = name;
        this.bonuses = bonuses;
    }
    public String getName(){
        return name;
    }
    public int getBonus(int attack){
        return bonuses[attack];
    }
    public JCheckBox getCheckBox(){
        return null;
    }
}
