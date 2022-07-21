package academy.mindswap;

public abstract class Monster {


    private int health;
    private int attackDamage;
    private MonsterType type;
    private boolean isAlive;

    protected Monster(int attackDamage, MonsterType type) {
        this.health = 100;
        this.attackDamage = attackDamage;
        this.type = type;
        this.isAlive = true;
    }

    public int attack() {
        return attackDamage;
    }

    public void loseHealth(int attackDamage) {
        if (attackDamage >= health) {
            health = 0;

            die();

            return;
        }

        health -= attackDamage;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public MonsterType getType() {
        return type;
    }

    protected void die() {
        isAlive = false;

        System.out.println("I'm dead.");
    }

    protected void increaseHealth(int amount) {
        if (amount > 0) {
            health += amount;
        }

        health = Math.min(health, 100);
    }
}
