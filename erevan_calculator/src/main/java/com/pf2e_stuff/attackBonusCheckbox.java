package com.pf2e_stuff;

import javax.swing.JCheckBox;

public class attackBonusCheckbox extends attackBonusSource{
    public Boolean state;
    public JCheckBox checkBox;

    //constructors for checkboxes that do not exist yet
    public attackBonusCheckbox(String name, int[] bonuses, GUI gui, Boolean state){
        super(name, bonuses);
        this.state = state;
        checkBox = gui.addCheckBox(name, state);
    }
    public attackBonusCheckbox(String name, int bonus, GUI gui, Boolean state){
        super(name, bonus);
        this.state = state;
        checkBox = gui.addCheckBox(name, state);
    }
    //constructors for pre-existing checkbox
    public attackBonusCheckbox(String name, int[] bonuses, GUI gui, JCheckBox checkBox){
        super(name, bonuses);
        this.checkBox = checkBox;
    }
    public attackBonusCheckbox(String name, int bonus, GUI gui, JCheckBox checkBox){
        super(name, bonus);
        this.checkBox = checkBox;
    }

    //returns the bonus for a given attack
    public int getBonus(int attack){
        int toReturn = 0;
        if(checkBox.isSelected()){
            toReturn = bonuses[attack];
        }else{
            toReturn = 0;
        }
        return toReturn;
    }
    //returns the checkbox
    public JCheckBox getCheckBox(){
        return checkBox;
    }
}
