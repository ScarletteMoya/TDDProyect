package test;

import static org.junit.jupiter.api.Assertions.*;

import main.Vaso;
import org.junit.jupiter.api.Test;
public class VasoTest {
    @Test
    public void deberiaDevolverVerdaderoSiExistenVasos() {
        Vaso vasosPequenos = new Vaso(2, 10);
        boolean resultado = vasosPequenos.hasVasos(1);
        assertTrue(resultado);
    }
    @Test
    public void deberiaDevolverFalsoSiNoExistenVasos() {
        Vaso vasosPequenos = new Vaso(1, 10);
        boolean resultado = vasosPequenos.hasVasos(2);
        assertFalse(resultado);
    }
    @Test
    public void deberiaRestarCantidadDeVaso() {
        Vaso vasosPequenos = new Vaso(5, 10);
        vasosPequenos.giveVasos(1);
        assertEquals(4, vasosPequenos.getCantidadVasos());
    }
}