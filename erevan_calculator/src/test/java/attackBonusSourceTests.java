import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import javax.swing.JCheckBox;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pf2e_stuff.GUI;
import com.pf2e_stuff.attackBonusCheckbox;
import com.pf2e_stuff.attackBonusSource;

@ExtendWith(MockitoExtension.class)
public class attackBonusSourceTests {
    JCheckBox jCheckBoxTrue = Mockito.mock(JCheckBox.class);
    JCheckBox jCheckBoxFalse = Mockito.mock(JCheckBox.class);
    GUI gui = Mockito.mock(GUI.class);

    
    attackBonusSource atkBonusTrue = new attackBonusCheckbox("true", 5, gui, jCheckBoxTrue);
    attackBonusSource atkBonusFalse = new attackBonusCheckbox("false", 5, gui, jCheckBoxFalse);
    attackBonusSource atkBonusVariable = new attackBonusSource("flat", new int[] {5,4,3});

    @BeforeEach
    public void setUp(){
        when(jCheckBoxTrue.isSelected()).thenReturn(true);
        when(jCheckBoxFalse.isSelected()).thenReturn(false);
    }
    //tests a checked checkbox
    @Test
    public void testCheckboxTrue(){
        int target = 5;
        int value = atkBonusTrue.getBonus(0);
        assertEquals(target, value);
    }
    //tests an unchecked checkbox
    @Test
    public void testCheckboxFalse(){
        int target = 0;
        int value = atkBonusFalse.getBonus(0);
        assertEquals(target, value);
    }
    //checks a source with different values for each attack
    @Test
    public void testCheckboxVariable(){
        int target = 3;
        int value = atkBonusVariable.getBonus(2);
        assertEquals(target, value);
    }

}
