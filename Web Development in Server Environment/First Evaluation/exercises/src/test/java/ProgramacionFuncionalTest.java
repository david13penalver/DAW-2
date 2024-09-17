import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ProgramacionFuncionalTest {

    public static ProgramacionFuncional programacionFuncional;

    @BeforeAll
    public static void setUp() {
        programacionFuncional = new ProgramacionFuncional();
    }

    @Test
    public void ejercicio1Test_1() {
        List<Integer> listaEjercicio1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer expected = 55;
        Integer actual = programacionFuncional.ejercicio1(listaEjercicio1);
        assertEquals(expected, actual);
    }

    @Test
    public void ejercicio1Test_2() {
        List<Integer> listaEjercicio1 = List.of(1, 2, 3, -1);
        Integer expected = 5;
        Integer actual = programacionFuncional.ejercicio1(listaEjercicio1);
        assertEquals(expected, actual);
    }

    @Test
    public void ejercicio2Test() {
        List<Integer> listaEjercicio2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = List.of(2, 4, 6, 8, 10);
        List<Integer> actual = programacionFuncional.ejercicio2(listaEjercicio2);
        assertEquals(expected, actual);
    }

    @Test
    public void ejercicio3Test() {
        List<String> listaEjercicio3 = List.of("hola", "adios");
        List<String> expected = List.of("HOLA", "ADIOS");
        List<String> actual = programacionFuncional.ejercicio3(listaEjercicio3);
        assertEquals(expected, actual);
    }

    @Test
    public void ejercicio4Test_1() {
        List<Integer> listaEjercicio4 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> expected = Optional.of(10);
        Optional<Integer> actual = programacionFuncional.ejercicio4(listaEjercicio4);
        assertEquals(expected, actual);
    }

    @Test
    public void ejercicio4Test_2() {
        List<Integer> listaEjercicio4 = List.of(-1, -2, -3, -4, -5);
        Optional<Integer> expected = Optional.of(-1);
        Optional<Integer> actual = programacionFuncional.ejercicio4(listaEjercicio4);
        assertEquals(expected, actual);
    }

    @Test
    public void ejercicio4Test_3() {
        List<Integer> listaEjercicio4 = List.of();
        Optional<Integer> expected = Optional.empty();
        Optional<Integer> actual = programacionFuncional.ejercicio4(listaEjercicio4);
        assertEquals(expected, actual);
    }

    @Test
    public void ejercicio5Test() {
        List<Integer> listaEjercicio5 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long expected = 3;
        long actual = programacionFuncional.ejercicio5(listaEjercicio5);
        assertEquals(expected, actual);
    }

    @Test
    public void ejercicio6Test() {
        List<String> listaEjercicio6 = List.of("hola", "adios");
        String expected = "holaadios";
        String actual = programacionFuncional.ejercicio6(listaEjercicio6);
        assertEquals(expected, actual);
    }

    @Test
    public void ejercicio7Test() {
        List<Integer> listaEjercicio7 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> expected = List.of(1, 4, 9, 16, 25, 36, 49, 64, 81, 100);
        List<Integer> actual = programacionFuncional.ejercicio7(listaEjercicio7);
        assertEquals(expected, actual);
    }

    @Test
    public void ejercicio8Test() {
        List<String> listaEjercicio8 = List.of("hola", "adios", "hola");
        List<String> expected = List.of("hola", "adios");
        List<String> actual = programacionFuncional.ejercicio8(listaEjercicio8);
        assertEquals(expected, actual);
    }

    @Test
    public void ejercicio9Test_1() {
        List<Integer> listaEjercicio9 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer number = 5;
        Optional<Integer> expected = Optional.of(6);
        Optional<Integer> actual = programacionFuncional.ejercicio9(listaEjercicio9, number);
        assertEquals(expected, actual);
    }

    @Test
    public void ejercicio9Test_2() {
        List<Integer> listaEjercicio9 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer number = 10;
        Optional<Integer> expected = Optional.empty();
        Optional<Integer> actual = programacionFuncional.ejercicio9(listaEjercicio9, number);
        assertEquals(expected, actual);
    }

    @Test
    public void ejercicio10StringTest() {
        List<String> listaEjercicio10 = List.of("hola", "adios", "hasta luego", "hello");
        long expected = 3;
        long actual = programacionFuncional.ejercicio10String(listaEjercicio10, "h");
        assertEquals(expected, actual);
    }

    @Test
    public void ejercicio10CharTest() {
        List<String> listaEjercicio10 = List.of("hola", "adios", "hasta luego", "hello");
        long expected = 3;
        long actual = programacionFuncional.ejercicio10Char(listaEjercicio10, 'h');
        assertEquals(expected, actual);
    }

}