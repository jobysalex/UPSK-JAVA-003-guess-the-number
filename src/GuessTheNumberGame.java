import java.util.Scanner;

public class GuessTheNumberGame {
    private static int targetNumber;

    public static void main(String[] arg) {
        targetNumber = (int) (Math.random() * 100) + 1;
        System.out.println("\t \t Bienvenidos a Guess The Number!!!");
        System.out.println("\t \t Numero aleatorio: " + targetNumber );

        Player humanPlayer = new Human(getPlayerName());
        Player computerPlayer = new Computer("computer");

        boolean gameOver = true;

        while (gameOver) {
            checkGuess(humanPlayer);
            if (humanPlayer.getGuesses().size() > 9) {
                System.out.println("Has alcanzado el límite de intentos. ¡Fin del juego!");
                gameOver = false;
                break;
            }

            checkGuess(computerPlayer);
            if (computerPlayer.getGuesses().size() > 9) {
                System.out.println("La computadora ha alcanzado el límite de intentos. ¡Fin del juego!");
                gameOver = false;
                break;
            }
        }
    }

    private static String getPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngresa Tu Nombre: ");
        return scanner.nextLine();
    }

    private static void checkGuess(Player player) {
        System.out.println("\nTurno de " + player.getName());
        int guess = player.makeGuess();
        System.out.println(player.getName() + " ha escogido: " + guess);

        if (guess < targetNumber) {
            System.out.println("Digita un numero mayor ");
        } else if (guess > targetNumber) {
            System.out.println("Digita un numero menor ");
        } else {
            System.out.println(player.getName() + " Gano, ha adivinado el numero... ¡Fin del Juego!");
            System.out.println(player.getName() + " intento con los numeros: " + player.getGuesses() + ", en un Total de: " + player.getGuesses().size() + " intentos" );
            System.exit(0);
        }

        System.out.println();
    }
}