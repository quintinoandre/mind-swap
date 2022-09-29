package academy.mindswap;

public class CreditCard extends Card {

    public CreditCard(int personalId, String bankName) {
        super(personalId, bankName);
    }

    public void payWithCreditCard(float amount, ATM atm) {
        atm.payWithCreditCard(amount, BANK_NAME, CLIENT_ID);
    }

    public void depositWithCreditCard(float amount, ATM atm) {
        atm.depositWithCreditCard(amount, BANK_NAME, CLIENT_ID);
    }
}
