package academy.mindswap;

public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public int makeAGuess(int min, int max) {
        return Util.generateRandomNumber(min, max);
    }

    public String getName() {
        return name;
    }
}
