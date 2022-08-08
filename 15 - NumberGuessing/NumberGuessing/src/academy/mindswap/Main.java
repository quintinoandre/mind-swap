package academy.mindswap;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Miguel");
        Player player2 = new Player("Pedro");
        int[] range = {0, 100};

        NumberGuessing numberGuessing = new NumberGuessing(range, player1, player2);

        numberGuessing.playGame();
    }
}
