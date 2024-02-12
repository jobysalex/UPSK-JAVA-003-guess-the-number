public class Computer extends Player {
    public Computer(String name) {
        super(name);
    }

    public int makeGuess() {
        int guess = (int)(Math.random() * 100) + 1;
        addGuess(guess);
        return guess;
    }
}