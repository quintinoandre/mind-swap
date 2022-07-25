package academy.mindswap;

public class Card {
    private int pin;
    private float balance;

    public Card(int pin, float balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public float getBalance() {
        return balance;
    }

    public void increaseBalance(float amount) {
        balance += amount;
    }

    public void decreaseBalance(float amount) {
        balance -= amount;
    }
}
