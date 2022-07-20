package academy.mindswap;

public class RockPaperScissors {
    public static Player player1 = new Player("Luís");
    public static Player player2 = new Player("Pedro");
    private static final String DRAW = "draw";
    private static int totalDraws = 0;

    private RockPaperScissors() {
    }

    private static Player verifyWinner(Player player1, Player player2) {
        if (player1.getTool() == player2.getTool()) return null;

        switch (player1.getTool()) {
            case ROCK:
                return Tool.SCISSORS == player2.getTool() ? player1 : player2;
            case PAPER:
                return Tool.ROCK == player2.getTool() ? player1 : player2;
            default:
                return Tool.PAPER == player2.getTool() ? player1 : player2;
        }
    }

    private static String getFinalReport(Player winner, Player loser) {
        return "Final result: \n - The winner is ".concat(winner.getName().concat(" with the score "))
                + winner.getScore() + "\n - The loser is ".concat(loser.getName().concat(" with the score "))
                + loser.getScore() + "\n - The total number of plays was "
                + (winner.getScore() + loser.getScore() + totalDraws)
                + "\n - The total number of draws was " + totalDraws;
    }

    public static String playGame(int numberOfWins) {
        if (numberOfWins % 2 == 0) return "The number of wins must be odd";

        Player winnerPlayer;

        do {
            player1.pickRandomTool();

            player2.pickRandomTool();

            winnerPlayer = verifyWinner(player1, player2);

            if (player1.equals(winnerPlayer)) {
                player1.setScore(player1.getScore() + 1);

                System.out.printf("Result: the winner is %s (score: %d)%n%n", player1.getName(), player1.getScore());
            } else if (player2.equals(winnerPlayer)) {
                player2.setScore(player2.getScore() + 1);

                System.out.printf("Result: the winner is %s (score: %d)%n%n", player2.getName(), player2.getScore());
            } else {
                totalDraws += 1;

                System.out.printf("Result: %s%n%n", DRAW);
            }
        } while (winnerPlayer == null || (player1.getScore() < numberOfWins && player2.getScore() < numberOfWins));

        Player winner = player1.getScore() > player2.getScore() ? player1 : player2;

        Player loser = player1.getScore() > player2.getScore() ? player2 : player1;

        return getFinalReport(winner, loser);
    }
}
