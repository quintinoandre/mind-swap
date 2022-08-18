package academy.mindswap;

import academy.mindswap.supernaturals.Supernatural;
import academy.mindswap.supernaturals.fairies.Fairy;
import academy.mindswap.supernaturals.strikeable.Witch;
import academy.mindswap.util.RandomGenerator;

import static academy.mindswap.util.Messages.*;
import static academy.mindswap.util.RandomGenerator.generateRandom;

public class Game {
    private Player player1;
    private Player player2;
    private Supernatural[] obstacles;
    private final int NUMBER_OF_OBSTACLES = 2;
    private final int FAIRY = 1;
    private final int WITCH = 2;

    private Player attacker;
    private Player defender;

    private final float OBSTACLES_CHANCE = 0.2f;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.obstacles = new Supernatural[NUMBER_OF_OBSTACLES];
    }

    public void begin() {
        pickObstacles();

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
        if (generateRandom(0, 1) <= OBSTACLES_CHANCE) {
            System.out.printf(GAME_ATTACKED, getClassName());

            Supernatural obstacle = chooseObstacle();

            defender.defend(obstacle.attack());
            attacker.defend(obstacle.attack());

            if (obstacle instanceof Witch) {
                System.out.printf(PLAYER_ATTACKED, getClassName(), defender.getName());

                ((Witch) obstacle).defend(defender.attack());

                if (!obstacle.isDead()) {
                    System.out.printf(PLAYER_ATTACKED, getClassName(), attacker.getName());

                    ((Witch) obstacle).defend(attacker.attack());
                }
            }
        } else {
            System.out.printf(PLAYER_ATTACKED, getClassName(), attacker.getName());

            System.out.printf(PLAYER_DEFENDED, getClassName(), defender.getName());

            defender.defend(attacker.attack());

            this.attacker = defender;
            this.defender = attacker;
        }

        if (defender.isLost()) {
            System.out.printf(PLAYER_LOSE, defender.getName());

            return;
        }

        System.out.printf(NEXT_ROUND, getClassName());

        playRounds(this.attacker, this.defender);
    }

    public void pickObstacles() {
        obstacles[0] = new Fairy(10);
        obstacles[1] = new Witch(20);

        System.out.printf(CREATE_SUPERNATURAL, getClassName(),
                ((Fairy) obstacles[0]).getClassName());

        System.out.printf(CREATE_SUPERNATURAL, getClassName(),
                ((Witch) obstacles[1]).getClassName());

        if (NUMBER_OF_OBSTACLES > 2) {
            for (int i = 2; i < obstacles.length; i++) {
                int obstacleType = RandomGenerator.generateRandom(1, 2);

                if (obstacleType == FAIRY) {
                    obstacles[i] = new Fairy(10);

                    System.out.printf(CREATE_SUPERNATURAL, getClassName(),
                            ((Fairy) obstacles[i]).getClassName());
                }

                if (obstacleType == WITCH) {
                    obstacles[i] = new Witch(20);

                    System.out.printf(CREATE_SUPERNATURAL, getClassName(),
                            ((Witch) obstacles[i]).getClassName());
                }
            }
        }
    }

    private Supernatural chooseObstacle() {
        Supernatural obstacle = obstacles[RandomGenerator.generateRandom(0, obstacles.length - 1)];

        if (obstacle.isDead()) {
            obstacle = chooseObstacle();
        }

        if (obstacle instanceof Fairy) {
            System.out.printf(CHOSEN_OBSTACLE, getClassName(), ((Fairy) obstacle).getClassName());
        }

        if (obstacle instanceof Witch) {
            System.out.printf(CHOSEN_OBSTACLE, getClassName(), ((Witch) obstacle).getClassName());
        }

        return obstacle;
    }

    private String getClassName() {
        return this.getClass().getSimpleName();
    }
}
