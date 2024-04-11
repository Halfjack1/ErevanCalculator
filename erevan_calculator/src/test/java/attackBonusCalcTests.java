import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import javax.swing.JLabel;
import com.pf2e_stuff.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class attackBonusCalcTests {
    JLabel jLabel = Mockito.mock(JLabel.class);

    attackBonusSource atkSrc1 = Mockito.mock(attackBonusSource.class);
    attackBonusSource atkSrc2 = Mockito.mock(attackBonusSource.class);

    @BeforeEach
    public void setUp(){
        when(atkSrc1.getBonus(0)).thenReturn(10);
        when(atkSrc2.getBonus(0)).thenReturn(0);
        when(atkSrc1.getBonus(1)).thenReturn(10);
        when(atkSrc2.getBonus(1)).thenReturn(-5);
        when(atkSrc1.getBonus(2)).thenReturn(10);
        when(atkSrc2.getBonus(2)).thenReturn(-10);
    }
    @Test
    public void testAtkBonusString(){
        attackBonusCalculator atkCalc = new attackBonusCalculator(new attackBonusSource[] {atkSrc1, atkSrc2}, jLabel);
        String target = "+10/+5/+0";
        String value = atkCalc.attackBonusString();
        
        assertEquals(target, value);
    }
}
