package academy.mindswap;

public abstract class Account {
    protected float balance;

    private final int CLIENT_ID;


    protected float minLimit = 0;

    private boolean hasCard;

    protected Account(int clientId) {
        CLIENT_ID = clientId;
        balance = 0;
    }

    public void increaseBalance(float amount) {
        balance += amount;
    }

    public void decreaseBalance(float amount) {
        balance -= amount;
    }

    public int getCLIENT_ID() {
        return CLIENT_ID;
    }

    public float getBalance() {
        return balance;
    }

    public float getMinLimit() {
        return minLimit;
    }

    public boolean getHasCard() {
        return hasCard;
    }

    public void setHasCard() {
        hasCard = true;
    }
}
