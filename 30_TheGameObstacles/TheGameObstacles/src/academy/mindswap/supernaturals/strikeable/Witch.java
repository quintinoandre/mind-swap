package academy.mindswap.supernaturals.strikeable;

import academy.mindswap.supernaturals.Supernatural;

import static academy.mindswap.util.Messages.MONSTER_DEFEND;
import static academy.mindswap.util.Messages.MONSTER_IS_DEAD;

public class Witch extends Supernatural implements Strikeable {

    public Witch(int damage) {
        super(damage);
    }

    @Override
    public void defend(int damage) {
        if (getHealth() - damage <= 0) {
            setHealth(0);

            setDead();

            System.out.printf(MONSTER_IS_DEAD, getClassName());

            return;
        }

        setHealth(getHealth() - damage / 2);

        System.out.printf(MONSTER_DEFEND, getClassName(), damage, getHealth());
    }

    public String getClassName() {
        return this.getClass().getSimpleName();
    }
}
