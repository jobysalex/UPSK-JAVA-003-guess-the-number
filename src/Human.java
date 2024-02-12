import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player {

    public Human(String name) {
        super(name);
    }

    @Override
    public int makeGuess() {
        Scanner scanner = new Scanner(System.in);
        int guess = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Ingresa un numero entre 1 y 100: ");
                guess = scanner.nextInt();

                if (guess < 1 || guess > 100) {
                    System.out.println("   *** Error ***   Número fuera del Rango.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("   *** Error   ***   Jugada Invalida");
                scanner.next(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
        }

        addGuess(guess);
        return guess;
    }
}