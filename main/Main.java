import javax.swing.JLabel;

public class Main {
    public static void main(String[] args){
        GUI gui = new GUI();
        damageSource[] damageSources = {
            new damageSourceDropdown("Weapon", 
                new String[] {"Bowblade","Mercy","Fist"}, 
                new Integer[] {3,2,2}, 
                new Integer[] {6,6,4}, gui),

            new damageSourceCheckBox("Psychic Glyph", 2, 12,gui,true),
            new damageSource("Strength+Specialization", 5, 1),

            new damageSourceCheckBox("Sneak Attack", 1, 6, gui,true),
            new damageSourceCheckBox("Melee", 3, 1, gui,true),
            new damageSourceCheckBox("Devil Trigger 1/turn", 1, 6, gui),
            new damageSourceCheckBox("Devil Trigger Combo", 1, 8, gui),
            new damageSourceCheckBox("Shrike Rune", 1, 6, gui),
            new damageSourceCheckBox("Breaker Bonus", 1, 6, gui,true),
            new damageSourceCheckBox("Salter Buff", 4, 1, gui),
            new damageSourceDropdown("Oculus Buff",
                new String[] {"None","Tier 1","Tier 2","Tier 3","Tier 4","Tier 5"},
                new Integer[] {0,2,4,6,8,10},
                new Integer[] {6,6,6,6,6,6}, gui)
        };
        JLabel damageIndicator = gui.addLabel("null");
        damageCalculator dmgCalc = new damageCalculator(damageSources, damageIndicator);
        gui.setDmgCalc(dmgCalc);
        dmgCalc.totalDamage();
        gui.addLabel("+22/+20/+18 to hit vs hunted prey");
        gui.addLabel("+22/+18/+14 to hit vs anything else");

    }    
}
