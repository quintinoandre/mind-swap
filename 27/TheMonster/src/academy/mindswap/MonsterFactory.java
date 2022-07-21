package academy.mindswap;

public final class MonsterFactory {
    private static final int VAMPIRE = 2;
    private static final int MUMMY = 3;


    private MonsterFactory() {
    }

    public static Monster[] createMonsters(int numberOfMonsters) {
        Monster[] monsters = new Monster[numberOfMonsters];

        for (int i = 0; i < monsters.length; i++) {
            int randomMonsterType = (int) ((Math.random() * 4) + 1);

            switch (randomMonsterType) {
                case VAMPIRE:
                    monsters[i] = new Vampire(20, MonsterType.VAMPIRE);
                    break;
                case MUMMY:
                    monsters[i] = new Mummy(20, MonsterType.MUMMY);
                    break;
                default:
                    monsters[i] = new Werewolf(20, MonsterType.WEREWOLF);
                    break;
            }
        }

        return monsters;
    }
}
