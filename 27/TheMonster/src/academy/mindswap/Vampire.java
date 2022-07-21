package academy.mindswap;

public class Vampire extends Monster {

    public Vampire(int attackDamage, MonsterType type) {
        super(attackDamage, type);
    }

    @Override
    public int attack() {
        int random = (int) ((Math.random() * 6) + 1);

        if (random == 3) {
            super.increaseHealth(10);

            System.out.printf("Take a bite motherfucker! My health now id %d.%n", getHealth());
        }

        return super.attack();
    }

}
