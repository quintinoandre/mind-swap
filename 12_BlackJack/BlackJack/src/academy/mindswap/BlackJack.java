package academy.mindswap;

public class BlackJack {
    public static Player dealer = new Player();
    public static Player player = new Player();
    private static int MAX_POINTS = 21;

    private BlackJack() {
    }

    private static int drawCard(int min, int max) {
        return (int) ((Math.random() * (max - min + 1) + min));
    }

    private static void sumScore(int drawCard, Player player) {
        player.setScore(player.getScore() + drawCard);
    }

    public static void startGame() {
        int drawCard = 0;

        while (dealer.getScore() < MAX_POINTS && player.getScore() < MAX_POINTS) {
            drawCard = drawCard(1, 13);

            System.out.printf("Draw card was: %d %n", drawCard);

            sumScore(drawCard, dealer);

            System.out.printf("%s score: %d %n%n", dealer.getName(), dealer.getScore());

            if (isWinner(dealer, player)) {
                return;
            }

            drawCard = drawCard(1, 13);

            System.out.printf("Draw card was: %d %n", drawCard);

            sumScore(drawCard, player);

            System.out.printf("%s score: %d %n%n", player.getName(), player.getScore());

            if (isWinner(player, dealer)) {
                return;
            }
        }
    }

    private static boolean isWinner(Player player1, Player player2) {
        if (player1.getScore() == MAX_POINTS) {
            System.out.printf("The winner is %s with the score %d %n", player1.getName(), player1.getScore());

            return true;
        }

        if (player1.getScore() > MAX_POINTS) {
            System.out.printf("The winner is %s because %s was burst with the score %d %n", player2.getName(),
                    player1.getName(), player1.getScore());

            return true;
        }

        return false;
    }
}
