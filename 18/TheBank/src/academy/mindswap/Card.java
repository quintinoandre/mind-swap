package academy.mindswap;

public abstract class Card {

    protected final int CLIENT_ID;
    protected final String BANK_NAME;

    protected Card(int clientId, String bankName) {
        CLIENT_ID = clientId;
        BANK_NAME = bankName;
    }

    public String getBANK_NAME() {
        return BANK_NAME;
    }

    public int getCLIENT_ID() {
        return CLIENT_ID;
    }
}
