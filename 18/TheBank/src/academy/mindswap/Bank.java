package academy.mindswap;

import java.util.ArrayList;

import static academy.mindswap.Print.*;

public class Bank {

    private final String NAME;
    private final float CREDIT_FEE = 5;

    private ArrayList<Account> accounts = new ArrayList<>();

    public Bank(String name) {
        NAME = name;
    }

    public void createDebitAccount(int clientId) {
        int accountindex = Utils.findDebitAccountIndex(clientId, accounts);

        if (accountindex >= 0) {
            Print.message(EXISTING_DEBIT_ACCOUNT);

            return;
        }

        accounts.add(new DebitAccount(clientId));
    }

    public void createCreditAccount(int clientId) {
        int accountindex = Utils.findCreditAccountIndex(clientId, accounts);

        if (accountindex >= 0) {
            Print.message(EXISTING_CREDIT_ACCOUNT);

            return;
        }

        accounts.add(new CreditAccount(clientId));
    }

    public DebitCard createDebitCard(int clientId, String bankName) {
        int accountindex = Utils.findDebitAccountIndex(clientId, accounts);

        if (accountindex == -1) {
            Print.message(NON_EXISTING_DEBIT_ACCOUNT);

            return null;
        }

        if (accounts.get(accountindex).getHasCard()) {
            Print.message(EXISTING_DEBIT_CARD);

            return null;
        }

        accounts.get(accountindex).setHasCard();

        return new DebitCard(clientId, bankName);
    }

    public CreditCard createCreditCard(int clientId, String bankName) {
        int accountindex = Utils.findCreditAccountIndex(clientId, accounts);

        if (accountindex == -1) {
            Print.message(NON_EXISTING_CREDIT_ACCOUNT);

            return null;
        }

        if (accounts.get(accountindex).getHasCard()) {
            Print.message(EXISTING_CREDIT_CARD);

            return null;
        }

        accounts.get(accountindex).setHasCard();

        return new CreditCard(clientId, bankName);
    }

    public void payWithDebitCard(float amount, int clientId) {
        int accountindex = Utils.findDebitAccountIndex(clientId, accounts);

        if (accountindex == -1) {
            Print.message(NON_EXISTING_DEBIT_ACCOUNT);

            return;
        }

        if (accounts.get(accountindex).getBalance() - amount < accounts.get(accountindex).getMinLimit()) {
            Print.message(NO_DEBIT_BALANCE);

            return;
        }

        accounts.get(accountindex).decreaseBalance(amount);
    }

    public void payWithCreditCard(float amount, int clientId) {
        int accountindex = Utils.findCreditAccountIndex(clientId, accounts);

        if (accountindex == -1) {
            Print.message(NON_EXISTING_CREDIT_ACCOUNT);

            return;
        }

        float balanceAfterTransaction = accounts.get(accountindex).getBalance() - amount;

        if (balanceAfterTransaction < 0) {
            if (balanceAfterTransaction - CREDIT_FEE < accounts.get(accountindex).getMinLimit()) {
                Print.message(NO_CREDIT_BALANCE);

                return;
            }

            accounts.get(accountindex).decreaseBalance(amount + CREDIT_FEE);
        }

    }

    public void depositWithDebitCard(float amount, int clientId) {
        int accountindex = Utils.findDebitAccountIndex(clientId, accounts);

        if (accountindex == -1) {
            Print.message(NON_EXISTING_DEBIT_ACCOUNT);

            return;
        }

        accounts.get(accountindex).increaseBalance(amount);
    }

    public void depositWithCreditCard(float amount, int clientId) {
        int accountindex = Utils.findCreditAccountIndex(clientId, accounts);

        if (accountindex == -1) {
            Print.message(NON_EXISTING_CREDIT_ACCOUNT);

            return;
        }

        accounts.get(accountindex).increaseBalance(amount);
    }

    public void makeWithraw(float amount, int clientId) {
        int accountindex = Utils.findDebitAccountIndex(clientId, accounts);

        if (accountindex == -1) {
            Print.message(NON_EXISTING_DEBIT_ACCOUNT);

            return;
        }

        ((DebitAccount) accounts.get(accountindex)).makeWithraw(amount);
    }

    public String getNAME() {
        return NAME;
    }
}
