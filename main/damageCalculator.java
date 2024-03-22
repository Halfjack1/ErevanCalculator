import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JLabel;

public class damageCalculator {
    public static damageSource[] damageSources;
    public JLabel damageLabel;

    public damageCalculator(damageSource[] initDamageSources, JLabel initJLabel){
        damageSources = initDamageSources;
        damageLabel = initJLabel;
    }
    //gets the total damage and sets the label to the value
    public void totalDamage(){
        Map<Integer, Integer> damageDice = getDamageDice();
        damageLabel.setText(getTotalDamageString(damageDice));
    }
    //loops through all damage sources and totals the numbers of dice by their types
    private Map<Integer, Integer> getDamageDice(){
        //sorts in reverse order
        Map<Integer, Integer> damageDice = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        for(damageSource dmgSrc : damageSources) {
            Integer dieType = Integer.valueOf(dmgSrc.getDieType());
            if(damageDice.containsKey(dieType)){
                damageDice.put(dieType, Integer.valueOf(dmgSrc.getDice() + damageDice.get(dieType)));
            }else{
                damageDice.put(dieType, Integer.valueOf(dmgSrc.getDice()));
            }
        }
        return damageDice;
    }
    //gets the final string to be displayed
    private String getTotalDamageString(Map<Integer, Integer> damageDice){
        String toReturn = "";
        for (Map.Entry<Integer, Integer> entry : damageDice.entrySet()) {
            int dieType = entry.getKey();
            int dieNumber = entry.getValue();
            if(dieNumber != 0){
                if(dieType != 1){
                    toReturn += dieNumber;
                    toReturn += "d";
                    toReturn += dieType;
                }else{
                    toReturn += dieNumber;
                }
                toReturn += " + ";
            }
        }
        toReturn = toReturn.substring(0,toReturn.length()-3);
        return toReturn;
    }
    //gets all the damage source objects
    public static damageSource[] getDamageSources(){
        return damageSources;
    }
}
