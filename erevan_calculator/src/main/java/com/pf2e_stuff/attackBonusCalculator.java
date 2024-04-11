package com.pf2e_stuff;

import javax.swing.JLabel;

public class attackBonusCalculator {
    public attackBonusSource[] attackBonusSources;
    public JLabel attackLabel;

    public attackBonusCalculator(attackBonusSource[] attackBonusSources, JLabel attackLabel){
        this.attackBonusSources = attackBonusSources;
        this.attackLabel = attackLabel;
    }
    public String attackBonusString(){
        String toReturn = "+" + getAttackBonus(0) + "/+" + getAttackBonus(1) + "/+" + getAttackBonus(2);
        attackLabel.setText(toReturn);
        return toReturn;
    }
    public int getAttackBonus(int attackNumber){
        int total = 0;
        for(attackBonusSource attackBonus : attackBonusSources){
            total += attackBonus.getBonus(attackNumber);
        }
        return total;
    }
}
