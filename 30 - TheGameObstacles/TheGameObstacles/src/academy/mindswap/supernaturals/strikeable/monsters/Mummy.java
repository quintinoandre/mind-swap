package academy.mindswap.supernaturals.strikeable.monsters;

import static academy.mindswap.supernaturals.strikeable.monsters.MonsterType.MUMMY;
import static academy.mindswap.util.Messages.MUMMY_UNROLL;

public class Mummy extends Monster {
    private final int MAX_CONSECUTIVE_ATTACKS = 2;
    private final int UNROLL_DAMAGE = 10;
    private int consecutivesAttacks;

    public Mummy(int damage) {
        super(damage, MUMMY);

        consecutivesAttacks = 0;
    }

    @Override
    public void defend(int damage) {
        consecutivesAttacks = 0;

        super.defend(damage);
    }

    @Override
    public int attack() {
        consecutivesAttacks++;

        if (consecutivesAttacks == MAX_CONSECUTIVE_ATTACKS) {
            consecutivesAttacks = 0;

            return unroll();
        }

        return super.attack();
    }

    private int unroll() {
        setHealth(getHealth() - UNROLL_DAMAGE);

        System.out.printf(MUMMY_UNROLL, UNROLL_DAMAGE);

        return 0;
    }
}
