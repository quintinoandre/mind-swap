package academy.mindswap;

public class DebitCard extends Card {

    public DebitCard(int personalId, String bankName) {
        super(personalId, bankName);
    }

    public void payWithDebitCard(float amount, ATM atm) {
        atm.payWithDebitCard(amount, BANK_NAME, CLIENT_ID);
    }

    public void depositWithDebitCard(float amount, ATM atm) {
        atm.depositWithDebitCard(amount, BANK_NAME, CLIENT_ID);
    }

    public void makeWithraw(float amount, ATM atm) {
        atm.makeWithraw(amount, BANK_NAME, CLIENT_ID);
    }
}
