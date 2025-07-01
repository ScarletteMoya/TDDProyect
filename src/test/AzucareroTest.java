package test;

import static org.junit.jupiter.api.Assertions.*;

import main.Azucarero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AzucareroTest {

    Azucarero azucarero;

    @BeforeEach
    public void setUp() {
        azucarero = new Azucarero(10);
    }

    @Test
    public void deberiaDevolverVerdaderoSiHaySuficienteAzucarEnElAzucarero() {
        assertTrue(azucarero.hasAzucar(5));
        assertTrue(azucarero.hasAzucar(10));
    }

    @Test
    public void deberiaDevolverFalsoPorqueNoHaySuficienteAzucarEnElAzucarero() {
        assertFalse(azucarero.hasAzucar(15));
    }

    @Test
    public void deberiaRestarAzucarAlAzucarero() {
        azucarero.giveAzucar(5);
        assertEquals(5, azucarero.getCantidadAzucar());
        azucarero.giveAzucar(2);
        assertEquals(3, azucarero.getCantidadAzucar());
    }
}