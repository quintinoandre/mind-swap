package academy.mindswap;

import java.util.ArrayList;

public class ATM {
    private ArrayList<Bank> banks = new ArrayList<>();

    public void addBank(Bank bank) {
        banks.add(bank);
    }

    public void payWithDebitCard(float amount, String bankName, int clientId) {
        int bankIndex = Utils.findBankIndex(bankName, banks);

        banks.get(bankIndex).payWithDebitCard(amount, clientId);
    }


    public void payWithCreditCard(float amount, String bankName, int clientId) {
        int bankIndex = Utils.findBankIndex(bankName, banks);

        banks.get(bankIndex).payWithCreditCard(amount, clientId);
    }

    public void depositWithDebitCard(float amount, String bankName, int clientId) {
        int bankIndex = Utils.findBankIndex(bankName, banks);

        banks.get(bankIndex).depositWithDebitCard(amount, clientId);
    }

    public void depositWithCreditCard(float amount, String bankName, int clientId) {
        int bankIndex = Utils.findBankIndex(bankName, banks);

        banks.get(bankIndex).depositWithCreditCard(amount, clientId);
    }

    public void makeWithraw(float amount, String bankName, int clientId) {
        int bankIndex = Utils.findBankIndex(bankName, banks);

        banks.get(bankIndex).makeWithraw(amount, clientId);
    }
}
