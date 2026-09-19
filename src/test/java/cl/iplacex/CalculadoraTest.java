package cl.iplacex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {

    @Test
    void debeSumarDosNumeros() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.sumar(5, 3);
        assertEquals(8, resultado);
    }

    @Test
    void debeMultiplicarDosNumeros() {
        Calculadora calculadora = new Calculadora();
        int resultado = calculadora.multiplicar(5, 3);
        assertEquals(15, resultado);
    }
}
