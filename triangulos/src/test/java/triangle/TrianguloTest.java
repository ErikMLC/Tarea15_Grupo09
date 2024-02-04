package triangle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.exception.TriangleExceptionNotCreate;
import com.triangle.Triangulo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

public class TrianguloTest {

    @BeforeAll
    public static void setUpClass() {
        System.out.println("Iniciando las pruebas");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Finalizando las pruebas");

    }

    @BeforeEach
    public void setUp() {
        System.out.println("Iniciando prueba");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Finalizando prueba");
    }

    @Test
    public void testEsTriangulo() throws TriangleExceptionNotCreate {
        Triangulo triangulo = new Triangulo();
        assertTrue(triangulo.esTriangulo(3, 4, 5));
    }

    @Test
    public void testEsTrianguloFalse() throws TriangleExceptionNotCreate {
        Triangulo triangulo = new Triangulo();
        assertFalse(triangulo.esTriangulo(2, 7, 12));
    }

    @Test
    public void testCalcularTipo() throws TriangleExceptionNotCreate {
        Triangulo triangulo = new Triangulo(3, 4, 5);
        assertEquals("Escaleno", triangulo.calcularTipo());
    }

    @Test
    public void testCalcularArea() throws TriangleExceptionNotCreate {
        Triangulo triangulo = new Triangulo(3, 4, 5);
        assertEquals(6.0, triangulo.calcularArea(), 0.0);
    }

    @Test
    public void testCalcularPerimetro() throws TriangleExceptionNotCreate {
        Triangulo triangulo = new Triangulo(3, 4, 5);
        assertEquals(12.0, triangulo.calcularPerimetro(), 0.0);
    }

    @Test
    public void testGetLadoA() throws TriangleExceptionNotCreate {
        Triangulo triangulo = new Triangulo(3, 4, 5);
        assertEquals(3.0, triangulo.getLadoA(), 0.0);
    }

    @Test
    public void testGetLadoB() throws TriangleExceptionNotCreate {
        Triangulo triangulo = new Triangulo(3, 4, 5);
        assertEquals(4.0, triangulo.getLadoB(), 0.0);
    }

    @Test
    public void testGetLadoC() throws TriangleExceptionNotCreate {
        Triangulo triangulo = new Triangulo(3, 4, 5);
        assertEquals(5.0, triangulo.getLadoC(), 0.0);
    }

    @Test
    public void testConstructor() throws TriangleExceptionNotCreate {
        Triangulo triangulo = new Triangulo(3, 4, 5);
        assertEquals(3.0, triangulo.getLadoA(), 0.0);
        assertEquals(4.0, triangulo.getLadoB(), 0.0);
        assertEquals(5.0, triangulo.getLadoC(), 0.0);
        assertEquals("Escaleno", triangulo.calcularTipo());
        assertEquals(6.0, triangulo.calcularArea(), 0.0);
        assertEquals(12.0, triangulo.calcularPerimetro(), 0.0);
    }

    @Test
    public void testConstructorException() {
        assertThrows(TriangleExceptionNotCreate.class, () -> {
            new Triangulo(2, 7, 12);
        });
    }

    @Test
    public void testConstructorExceptionMessage() {
        Exception exception = assertThrows(TriangleExceptionNotCreate.class, () -> {
            new Triangulo(2, 7, 12);
        });
        assertEquals("El triángulo no puede ser creado con los lados o dimensiones [2.0, 7.0, 12.0] proporcionados.",
                exception.getMessage());
    }

    @Test
    public void testConstructorExceptionMessage2() {
        Exception exception = assertThrows(TriangleExceptionNotCreate.class, () -> {
            new Triangulo(2, 7, 12);
        });
        assertTrue(exception.getMessage().contains("El triángulo no puede ser creado con los lados o dimensiones"));
    }

    @Test
    public void testConstructorExceptionMessage3() {
        Exception exception = assertThrows(TriangleExceptionNotCreate.class, () -> {
            new Triangulo(2, 7, 12);
        });
        assertTrue(exception.getMessage().contains("proporcionados."));
    }

    @Test
    public void testConstructorExceptionMessage4() {
        Exception exception = assertThrows(TriangleExceptionNotCreate.class, () -> {
            new Triangulo(2, 7, 12);
        });
        assertTrue(exception.getMessage().contains("2.0, 7.0, 12.0"));
    }

    @Test
    public void testTrianguloEquilatero() throws TriangleExceptionNotCreate {
        Triangulo triangulo = new Triangulo(3, 3, 3);
        assertEquals("Equilátero", triangulo.calcularTipo());
    }

    @Test
    public void testTrianguloEquilateroError() throws TriangleExceptionNotCreate {
        Triangulo triangulo = new Triangulo(3, 3, 3);
        assertNotEquals("Isósceles", triangulo.calcularTipo());
    }

}
