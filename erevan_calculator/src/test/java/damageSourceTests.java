import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import javax.swing.JCheckBox;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.pf2e_stuff.*;

@ExtendWith(MockitoExtension.class)
public class damageSourceTests {
    JCheckBox jCheckBoxTrue = Mockito.mock(JCheckBox.class);
    JCheckBox jCheckBoxFalse = Mockito.mock(JCheckBox.class);

    GUI gui = Mockito.mock(GUI.class);

    damageSourceCheckBox dmgCheckBoxTrue = new damageSourceCheckBox("", 1, 6, gui,jCheckBoxTrue);
    damageSourceCheckBox dmgCheckBoxFalse = new damageSourceCheckBox("", 1, 6, gui,jCheckBoxFalse);

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
    public void testDiceNumberFalse(){
        int target = 0;
        int value = dmgCheckBoxFalse.getDice();
        assertEquals(target, value);
    }

}
