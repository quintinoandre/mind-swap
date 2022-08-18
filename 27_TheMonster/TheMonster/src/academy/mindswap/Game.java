package academy.mindswap;

public class Game {

    Player player1;
    Player player2;
    int numberOfMonsters;

    public Game(Player player1, Player player2, int numberOfMonsters) {
        this.player1 = player1;
        this.player2 = player2;
        this.numberOfMonsters = numberOfMonsters;
    }

    public void play() {
        player1.pickMonsters(numberOfMonsters);
        player2.pickMonsters(numberOfMonsters);

        determineWinner();
    }

    public void determineWinner() {
        if (haveWinner()) {
            printWinner();

            return;
        }

        player1.defend(player2.attack());
        player2.defend(player1.attack());

        determineWinner();
    }

    private void printWinner() {
        if (player1.canPlay()) {
            System.out.println("p1 wins");

            return;
        }

        System.out.println("p2 wins");
    }

    private boolean haveWinner() {
        return !player1.canPlay() || !player2.canPlay();
    }
}
