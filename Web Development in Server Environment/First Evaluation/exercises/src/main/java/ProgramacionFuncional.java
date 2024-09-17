import java.util.List;
import java.util.Optional;

public class ProgramacionFuncional {

    public Integer ejercicio1(List<Integer> ejercicioNumber) {
        return ejercicioNumber.stream().reduce(0, Integer::sum);
    }

    public List<Integer> ejercicio2(List<Integer> ejercicioNumber) {
        return ejercicioNumber.stream().filter(n -> n % 2 == 0).toList();
    }

    public List<String> ejercicio3(List<String> ejercicioNumber) {
        return ejercicioNumber.stream().map(String::toUpperCase).toList();
    }

    public Optional<Integer> ejercicio4(List<Integer> ejercicioNumber) {
        return ejercicioNumber.stream().reduce(Integer::max);
    }

    public long ejercicio5(List<Integer> ejercicioNumber) {
        return ejercicioNumber.stream().filter(n -> n > 7).count();
    }

    public String ejercicio6(List<String> ejercicioNumber) {
        return ejercicioNumber.stream().reduce("", String::concat);
    }

    public List<Integer> ejercicio7(List<Integer> ejercicioNumber) {
        return ejercicioNumber.stream().map(n -> n * n).toList();
    }

    public List<String> ejercicio8(List<String> ejercicioNumber) {
        return ejercicioNumber.stream().distinct().toList();
    }

    public Optional<Integer> ejercicio9(List<Integer> ejercicioNumber, Integer number) {
        return ejercicioNumber.stream().filter(n -> n > number).findFirst();
    }

    public long ejercicio10String(List<String> ejercicioNumber, String letter) {
        return ejercicioNumber.stream().filter(n -> n.startsWith(letter)).count();
    }

    public long ejercicio10Char(List<String> ejercicioNumber, char letter) {
        return ejercicioNumber.stream().filter(n -> n.charAt(0) == letter).count();
    }

    public static void main(String[] args) {
        List<Integer> ejercicio1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Ejercicio 1. Dada una lista de enteros, usa programación funcional para calcular la suma de todos los elementos.
        Integer ejercicio1OK = ejercicio1.stream().reduce(0, Integer::sum);
        System.out.println("Ejercicio 1: " + ejercicio1OK);

        // Ejercicio 2.  Dada una lista de enteros, devuelve una lista con solo los números pares.

        List<Integer> ejercicio2 = ejercicio1.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("Ejercicio 2: " + ejercicio2);

        // Ejercicio 3.  Dada una lista de cadenas, convierte todas a mayúsculas usando programación funcional.
        List<String> ejercicio3 = List.of("hola", "adios", "buenos días", "buenas noches", "hasta luego");
        List<String> ejercicio3OK = ejercicio3.stream().map(String::toUpperCase).toList();

        System.out.println("Ejercicio 3: " + ejercicio3OK);

        // Ejercicio 4.  Dada una lista de enteros, usa programación funcional para encontrar el número máximo.

        Optional<Integer> ejercicio4OK = ejercicio1.stream().reduce(Integer::max);

        System.out.println("Ejercicio 4: " + ejercicio4OK);

        // Ejercicio 5.  Dada una lista de enteros y un valor, cuenta cuántos elementos son mayores a ese valor.

        long ejercicio5OK = ejercicio1.stream().filter(n -> n > 7).count();

        System.out.println("Ejercicio 5: " + ejercicio5OK);

        // Ejercicio 6.  Dada una lista de cadenas, usa programación funcional para concatenar todas las cadenas en una sola.

        String ejercicio6OK = ejercicio3.stream().reduce("", String::concat);

        System.out.println("Ejercicio 6: " + ejercicio6OK);

        // Ejercicio 7.  Dada una lista de enteros, devuelve una lista con los cuadrados de cada número.

        List<Integer> ejercicio7OK = ejercicio1.stream().map(n -> n * n).toList();

        System.out.println("Ejercicio 7: " + ejercicio7OK);

        // Ejercicio 8.  Dada una lista de enteros, elimina los duplicados usando programación funcional.
        List<String> ejercicio8 = List.of("hola", "adios", "hola", "buenos días", "buenas noches", "hasta luego", "adios");
        List<String> ejercicio8OK = ejercicio8.stream().distinct().toList();

        System.out.println("Ejercicio 8: " + ejercicio8OK);

        // Ejercicio 9.  Dada una lista de enteros, devuelve el primer número que sea mayor a un valor dado.

        Optional<Integer> ejercicio9OK = ejercicio1.stream().filter(n -> n > 5).findFirst();

        System.out.println("Ejercicio 9: " + ejercicio9OK);

        // Ejercicio 10.  Dada una lista de cadenas, cuenta cuántas empiezan con una letra específica.

        long ejercicio10OK = ejercicio3.stream().filter(n -> n.startsWith("h")).count();

        System.out.println("Ejercicio 10: " + ejercicio10OK);
    }

}
