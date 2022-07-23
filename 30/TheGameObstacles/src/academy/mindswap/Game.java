package academy.mindswap;

import static academy.mindswap.util.Messages.*;

public class Game {
    private Player player1;
    private Player player2;

    private Player attacker;
    private Player defender;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void begin() {
        System.out.printf(PLAYER_PICK_MONSTERS, getClassName(), player1.getName());
        player1.pickMonsters(3);

        System.out.printf(PLAYER_PICK_MONSTERS, getClassName(), player2.getName());
        player2.pickMonsters(3);

        System.out.printf(GAME_BEGIN, getClassName());

        attacker = player1;
        defender = player2;

        playRounds(attacker, defender);
    }

    private void playRounds(Player attacker, Player defender) {
        System.out.printf(PLAYER_ATTACKED, getClassName(), attacker.getName());

        System.out.printf(PLAYER_DEFENDED, getClassName(), defender.getName());

        defender.defend(attacker.attack());

        if (defender.isLost()) {
            System.out.printf(PLAYER_LOSE, defender.getName());

            return;
        }

        this.attacker = defender;
        this.defender = attacker;

        System.out.printf(NEXT_ROUND, getClassName());

        playRounds(this.attacker, this.defender);
    }

    private String getClassName() {
        return this.getClass().getSimpleName();
    }
}
