import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import javax.swing.JLabel;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.pf2e_stuff.*;

@ExtendWith(MockitoExtension.class)
public class damageCalcTests {

    JLabel jLabel = Mockito.mock(JLabel.class);

    damageSource dmgSrc1 = Mockito.mock(damageSource.class);
    damageSource dmgSrc2 = Mockito.mock(damageSource.class);
    damageSource dmgSrc3 = Mockito.mock(damageSource.class);
    damageSource dmgSrc4 = Mockito.mock(damageSource.class);

    @BeforeEach
    public void setUp(){
        when(dmgSrc1.getDice()).thenReturn(1);
        when(dmgSrc1.getDieType()).thenReturn(6);
        when(dmgSrc2.getDice()).thenReturn(2);
        when(dmgSrc2.getDieType()).thenReturn(12);
        when(dmgSrc3.getDice()).thenReturn(0);
        when(dmgSrc3.getDieType()).thenReturn(8);
        when(dmgSrc4.getDice()).thenReturn(6);
        when(dmgSrc4.getDieType()).thenReturn(1);
    }

    @Test
    public void testDieString(){
        damageSource[] damageSources = {dmgSrc1};
        damageCalculator calc = new damageCalculator(damageSources, jLabel);

        String target = "1d6";
        String value = calc.totalDamage();
        
        assertEquals(target, value);
    }
    @Test
    public void testDieSorting(){
        damageSource[] damageSources = {dmgSrc1,dmgSrc2};
        damageCalculator calc = new damageCalculator(damageSources, jLabel);

        String target = "2d12 + 1d6";
        String value = calc.totalDamage();
        
        assertEquals(target, value);
    }
    @Test
    public void testDiceAdding(){
        damageSource[] damageSources = {dmgSrc1,dmgSrc1,dmgSrc1,dmgSrc1};
        damageCalculator calc = new damageCalculator(damageSources, jLabel);

        String target = "4d6";
        String value = calc.totalDamage();
        
        assertEquals(target, value);
    }
    @Test
    public void testDiceString(){
        damageSource[] damageSources = {dmgSrc1,dmgSrc2,dmgSrc3,dmgSrc4};
        damageCalculator calc = new damageCalculator(damageSources, jLabel);

        String target = "2d12 + 1d6 + 6";
        String value = calc.totalDamage();
        
        assertEquals(target, value);
    }
}
