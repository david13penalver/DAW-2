import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ProgramacionFuncionalTest {

    static List<Integer> ejercicioNumber;

    @Test
    public void ejercicio1() {
        ejercicioNumber = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer ejercicio1OK = ejercicioNumber.stream().reduce(0, Integer::sum);
        Integer expected = 55;
        assertEquals(expected, ejercicio1OK);
    }

    @Test
    public void ejercicio1_2() {
        ejercicioNumber = List.of(1, 2, 3);
        Integer ejercicio1OK = ejercicioNumber.stream().reduce(0, Integer::sum);
        Integer expected = 6;
        assertEquals(expected, ejercicio1OK);
    }
    @Test
    public void ejercicio2() {
            List<Integer> ejercicio2 = ejercicioNumber.stream().filter(n -> n % 2 == 0).toList();
            List<Integer> expected = List.of(2, 4, 6, 8, 10);
            assertEquals(expected, ejercicio2);
    }

}