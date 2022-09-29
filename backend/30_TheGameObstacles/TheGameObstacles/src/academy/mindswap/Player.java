package academy.mindswap;

import academy.mindswap.factory.MonstersFactory;
import academy.mindswap.supernaturals.strikeable.monsters.Monster;
import academy.mindswap.supernaturals.strikeable.monsters.MonsterType;
import academy.mindswap.util.Messages;
import academy.mindswap.util.RandomGenerator;

import static academy.mindswap.util.Messages.ALL_MONSTERS_DEAD;
import static academy.mindswap.util.Messages.CHOSEN_MONSTER;

public class Player {
    private final String name;
    private Monster[] monsters;
    private boolean lost;
    private int numberOfDeadMonsters;

    public Player(String name) {
        this.name = name;
        numberOfDeadMonsters = 0;
    }

    public void pickMonsters(int numberOfMonsters) {
        monsters = new Monster[numberOfMonsters];

        MonsterType[] monsterTypes = MonsterType.values();

        MonsterType type;

        for (int i = 0; i < monsters.length; i++) {
            type = monsterTypes[RandomGenerator.generateRandom(0, monsterTypes.length - 1)];

            monsters[i] = MonstersFactory.create(type);

            System.out.printf(Messages.CREATE_MONSTER, name, monsters[i].getType());
        }
    }

    private Monster chooseMonster() {
        if (numberOfDeadMonsters >= monsters.length) {
            return null;
        }

        Monster monster = monsters[RandomGenerator.generateRandom(0, monsters.length - 1)];

        if (monster.isDead()) {
            monster = chooseMonster();
        }

        return monster;
    }

    public int attack() {
        Monster monster = chooseMonster();

        if (monster == null) {

            System.out.printf(ALL_MONSTERS_DEAD, getName());

            return 0;
        }

        System.out.printf(CHOSEN_MONSTER, getName(), monster.getType());

        return monster.attack();
    }

    public void defend(int damage) {
        Monster monster = chooseMonster();

        if (monster == null) {
            System.out.printf(ALL_MONSTERS_DEAD, getName());

            return;
        }

        System.out.printf(CHOSEN_MONSTER, getName(), monster.getType());

        monster.defend(damage);

        if (monster.isDead()) {
            numberOfDeadMonsters++;
        }

        if (numberOfDeadMonsters == monsters.length) {
            setLost(true);
        }
    }

    public boolean isLost() {
        return lost;
    }

    public String getName() {
        return name;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }
}
