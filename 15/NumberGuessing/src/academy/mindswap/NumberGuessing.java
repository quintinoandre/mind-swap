package academy.mindswap;

public class NumberGuessing {
    private final int[] range;
    private final Player player1;
    private final Player player2;
    private static final int MIN = 0;
    private static final int MAX = 1;

    public NumberGuessing(int[] range, Player player1, Player player2) {
        this.range = range;
        this.player1 = player1;
        this.player2 = player2;
    }

    private int generateHouseNumber() {
        return Util.generateRandomNumber(range[MIN], range[MAX]);
    }

    public void playGame() {
        int houseNumber = generateHouseNumber();
        int guessPlayer1;
        int guessPlayer2;
        boolean isDraw = false;

        do {
            guessPlayer1 = player1.makeAGuess(range[MIN], range[MAX]);
            guessPlayer2 = player2.makeAGuess(range[MIN], range[MAX]);

            if (guessPlayer1 == guessPlayer2 && guessPlayer1 == houseNumber) {
                isDraw = true;

                printReport(houseNumber, player1, guessPlayer1, isDraw);

                return;
            }

            if (guessPlayer1 == houseNumber) {
                printReport(houseNumber, player1, guessPlayer1, isDraw);
            }

            if (guessPlayer2 == houseNumber) {
                printReport(houseNumber, player2, guessPlayer2, isDraw);
            }

        } while (guessPlayer1 != houseNumber && guessPlayer2 != houseNumber);

    }

    private void printReport(int houseNumber, Player player, int playerNumber, boolean draw) {
        System.out.printf("The house number is %d%n", houseNumber);

        if (draw) {
            System.out.println("It was a draw");
        } else {
            System.out.printf("The winner is %s with the number %d%n", player.getName(), playerNumber);
        }
    }
}
