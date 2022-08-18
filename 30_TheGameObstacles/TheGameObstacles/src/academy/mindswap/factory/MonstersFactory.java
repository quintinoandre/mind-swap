package academy.mindswap.factory;


import academy.mindswap.supernaturals.strikeable.monsters.*;

public final class MonstersFactory {
    private MonstersFactory() {
    }

    public static Monster create(MonsterType type) {
        switch (type) {
            case WEREWOLF:
                return new Werewolf(30);
            case MUMMY:
                return new Mummy(10);
            default:
                return new Vampire(20);
        }
    }
}
