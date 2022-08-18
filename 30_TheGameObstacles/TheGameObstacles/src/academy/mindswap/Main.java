package academy.mindswap;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Tânia");
        Player player2 = new Player("André");

        Game game = new Game(player1, player2);

        game.begin();
    }
}
