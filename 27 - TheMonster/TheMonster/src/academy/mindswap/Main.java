package academy.mindswap;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("John");
        Player player2 = new Player("David");

        Game game = new Game(player2, player1, 5);

        game.play();
    }
}
