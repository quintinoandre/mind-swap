package academy.mindswap.supernaturals.strikeable.monsters;

import academy.mindswap.supernaturals.Supernatural;
import academy.mindswap.supernaturals.strikeable.Strikeable;

import static academy.mindswap.util.Messages.MONSTER_DEFEND;
import static academy.mindswap.util.Messages.MONSTER_IS_DEAD;

public abstract class Monster extends Supernatural implements Strikeable {
    private MonsterType type;

    protected Monster(int damage, MonsterType type) {
        super(damage);

        this.type = type;
    }

    @Override
    public void defend(int damage) {
        if (getHealth() - damage <= 0) {
            setHealth(0);

            setDead();

            System.out.printf(MONSTER_IS_DEAD, getType());

            return;
        }

        setHealth(getHealth() - damage);

        System.out.printf(MONSTER_DEFEND, getType(), damage, getHealth());
    }

    public MonsterType getType() {
        return type;
    }
}
