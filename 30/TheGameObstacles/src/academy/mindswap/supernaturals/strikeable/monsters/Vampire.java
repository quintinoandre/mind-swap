package academy.mindswap.supernaturals.strikeable.monsters;

import static academy.mindswap.supernaturals.strikeable.monsters.MonsterType.VAMPIRE;
import static academy.mindswap.util.Messages.VAMPIRE_BITE;
import static academy.mindswap.util.RandomGenerator.generateRandom;

public class Vampire extends Monster {
    private final float biteChance = 0.3f;
    private final int healthRecovery = 10;

    public Vampire(int damage) {
        super(damage, VAMPIRE);
    }

    @Override
    public int attack() {
        if (generateRandom(0, 1) <= biteChance) {
            bite();
        }

        return super.attack();
    }

    private void bite() {
        if (getHealth() + healthRecovery >= 100) {
            setHealth(100);

            System.out.printf(VAMPIRE_BITE, getType(), getHealth());

            return;
        }

        setHealth(getHealth() + healthRecovery);

        System.out.printf(VAMPIRE_BITE, getType(), getHealth());
    }
}
