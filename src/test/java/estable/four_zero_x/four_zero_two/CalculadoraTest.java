package estable.four_zero_x.four_zero_two;

import estable.four_zero_x.four_zero_two.Calculadora;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private InputStream originalIn;

    @BeforeEach
    public void setUp() {
        // Capture system output
        outContent = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Capture system input
        originalIn = System.in;
    }

    @Test
    public void testSumar() {
        assertEquals(6, Math.round(Calculadora.sumar(2, 4,5,6)[0] * 10000.0) / 10000.0);
        assertEquals(11, Math.round(Calculadora.sumar(2, 4,5,6)[1] * 10000.0) / 10000.0);
        assertEquals(0.956, Math.round(Calculadora.sumar(-1.8, 2.756, 9.87, 2.21)[0] * 10000.0) / 10000.0);
        assertEquals(12.08, Math.round(Calculadora.sumar(-1.8, 2.756, 9.87, 2.21)[1] * 10000.0) / 10000.0);
    }

    @Test
    public void testRestar() {
        assertEquals(-2, Math.round(Calculadora.restar(2, 4,5,6)[0] * 10000.0) / 10000.0);
        assertEquals(-1, Math.round(Calculadora.restar(2, 4,5,6)[1] * 10000.0) / 10000.0);
        assertEquals(-4.556, Math.round(Calculadora.restar(-1.8, 2.756, 9.87, 2.21)[0] * 10000.0) / 10000.0);
        assertEquals(7.66, Math.round(Calculadora.restar(-1.8, 2.756, 9.87, 2.21)[1] * 10000.0) / 10000.0);
    }

    @Test
    public void testMultiplicar() {
        assertEquals(1.967, Calculadora.multiplicar(1.2457, 1.57893, 3));
        assertEquals(-12, Calculadora.multiplicar(-2.75672, 4.354321, 2));
    }

    @Test
    public void testDividir() {
        assertEquals(2.351, Calculadora.dividir(6.478, 2.7549, 3));
        assertEquals(-0.30993, Calculadora.dividir(154.563, -498.6969, 5));
    }

    @Test
    public void testExponenciacion() {
        assertEquals(3912.68, Calculadora.exponentiation(5.67823, 4.76321, 2));
        assertEquals(5471.1467, Calculadora.exponentiation(233.33, 1.5786, 4));
    }

    @Test
    public void testSine() {
        assertEquals(0.5, Calculadora.sine(30,1));
        assertEquals(0.7428, Calculadora.sine(47.968,4));
    }

    @Test
    public void testCosine() {
        assertEquals(0.5, Calculadora.cosine(60,1));
        assertEquals(-0.805, Calculadora.cosine(143.56873,3));
    }

    @Test
    public void testTangent() {
        assertEquals(0, Calculadora.tangent(0,1));
        assertEquals(-0.769, Calculadora.tangent(-37.54342,3));
    }

    @Test
    public void testDecimalLog() {
        assertEquals(1, Calculadora.decimalLog(10,1));
       assertEquals(4.7370, Calculadora.decimalLog(54576.5849,4));
    }


    /*
    @Test
    public void testCalculateSuma() {
        String userInput = "1\n2,0\n3,0\n6\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Calculadora.calculateWithScanner(new Scanner(System.in));

        String expectedOutput = "Selecciona una opción:\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Multiplicación\n" +
                "4. División\n" +
                "5. Exponienciación\n" +
                "6. Salir\n" +
                "Escribe el primer número:\n" +
                "Escribe el segundo número:\n" +
                "Resultado: 5.0\n" +
                "Selecciona una opción:\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Multiplicación\n" +
                "4. División\n" +
                "5. Exponienciación\n" +
                "6. Salir\n" +
                "Saliendo...\n";
        assertEquals(expectedOutput, outContent.toString().replace("\r", ""));
    }

    @Test
    public void testCalculateResta() {
        String userInput = "2\n5,0\n3,0\n6\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Calculadora.calculateWithScanner(new Scanner(System.in));

        String expectedOutput = "Selecciona una opción:\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Multiplicación\n" +
                "4. División\n" +
                "5. Exponienciación\n" +
                "6. Salir\n" +
                "Escribe el primer número:\n" +
                "Escribe el segundo número:\n" +
                "Resultado: 2.0\n" +
                "Selecciona una opción:\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Multiplicación\n" +
                "4. División\n" +
                "5. Exponienciación\n" +
                "6. Salir\n" +
                "Saliendo...\n";
        assertEquals(expectedOutput, outContent.toString().replace("\r", ""));
    }

    @Test
    public void testCalculateMultiplicacion() {
        String userInput = "3\n3,0\n4,0\n6\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Calculadora.calculateWithScanner(new Scanner(System.in));

        String expectedOutput = "Selecciona una opción:\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Multiplicación\n" +
                "4. División\n" +
                "5. Exponienciación\n" +
                "6. Salir\n" +
                "Escribe el primer número:\n" +
                "Escribe el segundo número:\n" +
                "Resultado: 12.0\n" +
                "Selecciona una opción:\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Multiplicación\n" +
                "4. División\n" +
                "5. Exponienciación\n" +
                "6. Salir\n" +
                "Saliendo...\n";
        assertEquals(expectedOutput, outContent.toString().replace("\r", ""));
    }

    @Test
    public void testCalculateDivision() {
        String userInput = "4\n10,0\n2,0\n6\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Calculadora.calculateWithScanner(new Scanner(System.in));

        String expectedOutput = "Selecciona una opción:\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Multiplicación\n" +
                "4. División\n" +
                "5. Exponienciación\n" +
                "6. Salir\n" +
                "Escribe el primer número:\n" +
                "Escribe el segundo número:\n" +
                "Resultado: 5.0\n" +
                "Selecciona una opción:\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Multiplicación\n" +
                "4. División\n" +
                "5. Exponienciación\n" +
                "6. Salir\n" +
                "Saliendo...\n";
        assertEquals(expectedOutput, outContent.toString().replace("\r", ""));
    }

    @Test
    public void testCalculateExponenciacion() {
        String userInput = "5\n2,0\n3,0\n6\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Calculadora.calculateWithScanner(new Scanner(System.in));

        String expectedOutput = "Selecciona una opción:\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Multiplicación\n" +
                "4. División\n" +
                "5. Exponienciación\n" +
                "6. Salir\n" +
                "Escribe el primer número:\n" +
                "Escribe el segundo número:\n" +
                "Resultado: 8.0\n" +
                "Selecciona una opción:\n" +
                "1. Suma\n" +
                "2. Resta\n" +
                "3. Multiplicación\n" +
                "4. División\n" +
                "5. Exponienciación\n" +
                "6. Salir\n" +
                "Saliendo...\n";
        assertEquals(expectedOutput, outContent.toString().replace("\r", ""));
    }
*/

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}
