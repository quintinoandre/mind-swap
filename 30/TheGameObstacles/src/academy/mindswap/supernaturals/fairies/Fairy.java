package academy.mindswap.supernaturals.fairies;

import academy.mindswap.supernaturals.Supernatural;

import static academy.mindswap.util.Messages.FAIRY_HEALTH;
import static academy.mindswap.util.Messages.KILL_FAIRY;

public class Fairy extends Supernatural {
    public Fairy(int damage) {
        super(damage);
    }

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void setHealth(int health) {
        System.out.printf(FAIRY_HEALTH);
    }

    @Override
    public void setDead() {
        System.out.printf(KILL_FAIRY);
    }
}
