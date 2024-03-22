import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.pf2e_stuff.GUI;
import com.pf2e_stuff.damageSourceCheckBox;
import com.pf2e_stuff.damageSourceDropdown;

@ExtendWith(MockitoExtension.class)
public class damageSourceTests {
    JCheckBox jCheckBoxTrue = Mockito.mock(JCheckBox.class);
    JCheckBox jCheckBoxFalse = Mockito.mock(JCheckBox.class);

    GUI gui = Mockito.mock(GUI.class);

    damageSourceCheckBox dmgCheckBoxTrue = new damageSourceCheckBox("", 1, 6, gui,jCheckBoxTrue);
    damageSourceCheckBox dmgCheckBoxFalse = new damageSourceCheckBox("", 1, 6, gui,jCheckBoxFalse);

    JComboBox<String> jDropdown = Mockito.mock(JComboBox.class);

    damageSourceDropdown dmgDropdown = new damageSourceDropdown("", 
                new String[] {"none","small","big"}, 
                new Integer[] {0,1,2}, 
                new Integer[] {6,6,6}, gui,jDropdown);

    @BeforeEach
    public void setUp(){
        when(jCheckBoxTrue.isSelected()).thenReturn(true);
        when(jCheckBoxFalse.isSelected()).thenReturn(false);
    }

    @Test
    public void testDiceNumberTrue(){
        int target = 1;
        int value = dmgCheckBoxTrue.getDice();
        assertEquals(target, value);
    }
    @Test
    public void testDiceNumberFalse(){
        int target = 0;
        int value = dmgCheckBoxFalse.getDice();
        assertEquals(target, value);
    }
    @Test
    public void testDropdownNone(){
        when(jDropdown.getSelectedIndex()).thenReturn(0);
        int target = 0;
        int value = dmgDropdown.getDice();
        assertEquals(target, value);
    }
    @Test
    public void testDropdownOne(){
        when(jDropdown.getSelectedIndex()).thenReturn(1);
        int target = 1;
        int value = dmgDropdown.getDice();
        assertEquals(target, value);
    }
    @Test
    public void testDropdownTwo(){
        when(jDropdown.getSelectedIndex()).thenReturn(2);
        int target = 2;
        int value = dmgDropdown.getDice();
        assertEquals(target, value);
    }



}
