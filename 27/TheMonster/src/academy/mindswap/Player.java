package academy.mindswap;

public class Player {
    private String name;
    private Monster[] monsters;

    private int numberOfMonstersAlive;

    public Player(String name) {
        this.name = name;
    }

    public void pickMonsters(int numberOfMonsters) {
        monsters = MonsterFactory.createMonsters(numberOfMonsters);

        numberOfMonstersAlive = monsters.length;
    }

    public int attack() {
        Monster attacker = chooseMonster();

        if (attacker != null) {
            return chooseMonster().attack();
        }

        return 0;
    }

    public void defend(int attackPower) {
        Monster defender = chooseMonster();

        if (defender == null) {
            return;
        }

        defender.loseHealth(attackPower);

        if (!defender.isAlive()) {
            numberOfMonstersAlive--;
        }

        System.out.println("received " + defender.getType().toString() + " " + "health " + defender.getHealth());
    }

    public Monster chooseMonster() {
        Monster chosenMonsterRandom = monsters[Util.randomNumber(0, monsters.length - 1)];

        if (numberOfMonstersAlive == 0) {
            return null;
        }

        if (!chosenMonsterRandom.isAlive() && numberOfMonstersAlive > 0) {
            chooseMonster();
        }

        return chosenMonsterRandom;
    }

    public String getName() {
        return name;
    }

    public boolean canPlay() {
        return numberOfMonstersAlive > 0;
    }
}
