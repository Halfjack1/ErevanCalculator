import javax.swing.JCheckBox;

public class damageSourceCheckBox extends damageSource{
    public Boolean state;
    public JCheckBox checkBox;

    //constructor for a checkbox that doesn't default to false
    public damageSourceCheckBox(String initName, int initDice, int initDieType, GUI gui, Boolean initState){
        super(initName, initDice, initDieType);
        state = initState;
        checkBox = gui.addCheckBox(initName, initState);
    }
    //constructor for using an existing checkbox
    public damageSourceCheckBox(String initName, int initDice, int initDieType, GUI gui, JCheckBox initCheckBox){
        super(initName, initDice, initDieType);
        checkBox = initCheckBox;
    }
    //default constructor
    public damageSourceCheckBox(String initName, int initDice, int initDieType, GUI gui){
        super(initName, initDice, initDieType);
        checkBox = gui.addCheckBox(initName, false);
    }
    //returns the number of dice if checked, or zero if it's unchecked
    public int getDice(){
        int toReturn = 0;
        if(checkBox.isSelected()){
            toReturn = dice;
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
