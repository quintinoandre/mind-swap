package academy.mindswap.supernaturals.strikeable.monsters;

import static academy.mindswap.util.CapitalizeString.capitalize;

public enum MonsterType {
    WEREWOLF,
    VAMPIRE,
    MUMMY;

    @Override
    public String toString() {
        return capitalize(super.toString());
    }
}
