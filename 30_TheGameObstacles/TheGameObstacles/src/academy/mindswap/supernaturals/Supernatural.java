package academy.mindswap.supernaturals;

public abstract class Supernatural {
    private int damage;
    private int health;
    private boolean isDead;

    protected Supernatural(int damage) {
        this.damage = damage;
        health = 100;
    }

    public int attack() {
        return damage;
    }

    protected int getHealth() {
        return health;
    }

    public boolean isDead() {
        return isDead;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    protected void setDead() {
        isDead = true;
    }
}
