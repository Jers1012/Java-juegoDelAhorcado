import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //Declaraciones y asignaciones
        String palabraSecreta = "inteligencia";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        //Arreglos
        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        //Estructuras de control iterativas (bucles)
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        // Estructuras de control iterativas (bucles)
        while (!palabraAdivinada && intentos < intentosMaximos) {
            //String.valueOf(letrasAdivinadas) se utiliza para convertir el arreglo de caracteres letrasAdivinadas en una cadena que se puede imprimir
            //Esto toma el contenido del arreglo letrasAdivinadas, que inicialmente está lleno de guiones bajos ('_'), y lo convierte en una cadena como "___________"A medida que el jugador adivina letras correctas, el contenido de letrasAdivinadas se actualiza y String.valueOf(letrasAdivinadas) reflejará esos cambios, mostrando las letras adivinadas en su posición correcta y los guiones bajos para las letras que aún no han sido adivinadas.
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");

            System.out.println("Introduce una letra, por favor");
            //lo que ingresa el usuario lo pasa a caracter, lo pone en minuscula y solo toma la primera letra en caso de ser mas de una
            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            
            // Estructura de control condicional
            if (!letraCorrecta) {
                intentos++;
                System.out.println("¡Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos");
            }

            //Estructura de control condicional
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("¡Felicidades! has adivinado, la palabra es: " + palabraSecreta);
            }
        }
        //Estructura de control condicional
        if (!palabraAdivinada) {
            System.out.println("Game Over");
        }
        //Cierre scanner
        scanner.close();
    }
}