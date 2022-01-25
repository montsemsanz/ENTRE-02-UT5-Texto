
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextoTest {
    private Texto texto;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
        texto = new Texto(50);

    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testTextoCompleto() {
        assertFalse(texto.textoCompleto());
        assertTrue(texto.getPalabra(0) == null);
    }

    @Test
    public void testEstaPalabra() {
        assertFalse(texto.estaPalabra("casa") != -1);
        texto.addPalabras(" la.. casa,, de la playa de la amiga    ");
        int p = texto.estaPalabra("casa");
        assertTrue(p == 1);
        assertTrue(texto.estaPalabra("playa") == 4);
        assertTrue(texto.estaPalabra("amiga") == 0);

    }
    @Test
    public void testAddPalabras() {
        texto.addPalabras(" la casa de la playa de la amiga    ");
        int p = texto.estaPalabra("casa");
        assertTrue(p == 1);
        assertTrue(texto.estaPalabra("playa") == 4);
        assertTrue(texto.estaPalabra("amiga") == 0);
        texto.addPalabras(" voy a la playa.    ");
        assertTrue(texto.getPalabra(0).getPalabra().equals("A"));
        assertTrue(texto.totalPalabras() == 7);
        assertTrue(texto.getPalabra(5).getFrecuencia() == 2);

    }

    @Test
    public void testCapitalizarAlterna() {
        texto.addPalabras(" la casa de la playa de la amiga    ");
        assertArrayEquals(new String[] {"AMIga", "CASa", "DE", "LA", "PLAya"}, texto.capitalizarAlterna());
    }

    @Test
    public void testPalabrasConLetrasRepetidas() {
        texto.addPalabras(" la casa de la playa de la amiga    ");
        assertArrayEquals(new String[] {"AMIGA", "CASA", "PLAYA"}, texto.palabrasConLetrasRepetidas());
    }

    @Test
    public void testBorrarDeFrecuenciaMenor() {
        texto.addPalabras(" la casa de la playa de la amiga    ");
        int frecuencia = 2;
        int borradas = texto.borrarDeFrecuenciaMenor(frecuencia);
        assertTrue(borradas == 3);
        
        int p = texto.estaPalabra("de");
        assertTrue(p == 0);
        p = texto.estaPalabra("la");
        assertTrue(p == 1);

        
    }

    @Test
    public void testCalcularFrecuenciaLongitud() {
        texto.addPalabras(" la casa de la playa de la amiga    ");
        assertArrayEquals(new int[] {0, 2, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, texto.calcularFrecuenciaLongitud());

    }
}