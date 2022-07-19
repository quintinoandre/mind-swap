package academy.mindswap;

import java.util.ArrayList;

import static academy.mindswap.Print.*;

public class Client {

    private final String NAME;
    private final int CLIENT_ID;

    private ArrayList<Bank> banks = new ArrayList<>();
    private ArrayList<Card> cards = new ArrayList<>();

    public Client(String name, int personalId) {
        NAME = name;
        CLIENT_ID = personalId;
    }

    public void createDebitAccount(String bankName) {
        int bankIndex = Utils.findBankIndex(bankName, banks);

        if (bankIndex == -1) {
            Print.message(NO_BANK);

            return;
        }

        banks.get(bankIndex).createDebitAccount(CLIENT_ID);
    }

    public void createCreditAccount(String bankName) {
        int bankIndex = Utils.findBankIndex(bankName, banks);

        if (bankIndex == -1) {
            Print.message(NO_BANK);

            return;
        }

        banks.get(bankIndex).createCreditAccount(CLIENT_ID);
    }

    public DebitCard askForDebitCard(String bankName) {
        int bankIndex = Utils.findBankIndex(bankName, banks);

        if (bankIndex == -1) {
            Print.message(NO_BANK);

            return null;
        }

        DebitCard debitCard = banks.get(bankIndex).createDebitCard(CLIENT_ID, bankName);

        if (debitCard != null) {
            addCard(debitCard);

            return debitCard;
        }

        return null;
    }

    public CreditCard askForCreditCard(String bankName) {
        int bankIndex = Utils.findBankIndex(bankName, banks);

        if (bankIndex == -1) {
            Print.message(NO_BANK);

            return null;
        }

        CreditCard creditCard = banks.get(bankIndex).createCreditCard(CLIENT_ID, bankName);

        if (creditCard != null) {
            addCard(creditCard);

            return creditCard;
        }

        return null;
    }

    public void payWithDebitCard(float amount, String bankName, ATM atm) {
        int bankIndex = Utils.findBankIndex(bankName, banks);

        if (bankIndex == -1) {
            Print.message(NO_BANK);

            return;
        }

        int cardIndex = Utils.findDebitCardIndex(bankName, CLIENT_ID, cards);

        if (cardIndex == -1) {
            Print.message(NO_DEBIT_CARD);

            return;
        }

        ((DebitCard) cards.get(cardIndex)).payWithDebitCard(amount, atm);
    }

    public void payWithCreditCard(float amount, String bankName, ATM atm) {
        int bankIndex = Utils.findBankIndex(bankName, banks);

        if (bankIndex == -1) {
            Print.message(NO_BANK);

            return;
        }

        int cardIndex = Utils.findCreditCardIndex(bankName, CLIENT_ID, cards);

        if (cardIndex == -1) {
            Print.message(NO_CREDIT_CARD);

            return;
        }

        ((CreditCard) cards.get(cardIndex)).payWithCreditCard(amount, atm);
    }

    public void depositWithDebitCard(float amount, String bankName, ATM atm) {
        int bankIndex = Utils.findBankIndex(bankName, banks);

        if (bankIndex == -1) {
            Print.message(NO_BANK);

            return;
        }

        int cardIndex = Utils.findDebitCardIndex(bankName, CLIENT_ID, cards);

        if (cardIndex == -1) {
            Print.message(NO_DEBIT_CARD);

            return;
        }

        ((DebitCard) cards.get(cardIndex)).depositWithDebitCard(amount, atm);
    }

    public void depositWithCreditCard(float amount, String bankName, ATM atm) {
        int bankIndex = Utils.findBankIndex(bankName, banks);

        if (bankIndex == -1) {
            Print.message(NO_BANK);

            return;
        }

        int cardIndex = Utils.findCreditCardIndex(bankName, CLIENT_ID, cards);

        if (cardIndex == -1) {
            Print.message(NO_CREDIT_CARD);

            return;
        }

        ((CreditCard) cards.get(cardIndex)).depositWithCreditCard(amount, atm);
    }

    public void makeWithraw(float amount, String bankName, Card card, ATM atm) {
        int bankIndex = Utils.findBankIndex(bankName, banks);

        if (bankIndex == -1) {
            Print.message(NO_BANK);

            return;
        }

        if (card instanceof CreditCard) {
            Print.message(NO_CREDIT_WITHRAW);

            return;
        }

        int cardIndex = Utils.findDebitCardIndex(bankName, CLIENT_ID, cards);

        if (cardIndex == -1) {
            Print.message(NO_DEBIT_CARD);

            return;
        }

        ((DebitCard) cards.get(cardIndex)).makeWithraw(amount, atm);
    }

    public void addBank(Bank bank) {
        banks.add(bank);
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
