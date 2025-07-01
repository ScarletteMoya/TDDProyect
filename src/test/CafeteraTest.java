package test;

import main.Cafetera;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CafeteraTest {
    @Test
    public void deberiaDevolverVerdaderoSiExisteCafe() {
        Cafetera cafeteras = new Cafetera(10);
        boolean resultado = cafeteras.hasCafe(5);
        assertTrue(resultado);
    }

    @Test
    public void deberiaDevolverFalsoSiNoExisteCafe() {
        Cafetera cafetera = new Cafetera(10);
        boolean resultado = cafetera.hasCafe(11);
        assertFalse(resultado);
    }

    @Test
    public void deberiaRestarcafeAlaCafetera() {
        Cafetera cafetera = new Cafetera(10);
        cafetera.giveCafe(7);
        assertEquals(3, cafetera.getCantidadCafe());
    }
}
