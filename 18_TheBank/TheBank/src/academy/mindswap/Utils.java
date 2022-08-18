package academy.mindswap;

import java.util.ArrayList;

public abstract class Utils {
    public static int findBankIndex(String bankName, ArrayList<Bank> banks) {
        for (int i = 0; i < banks.size(); i++) {
            if (bankName.equals(banks.get(i).getNAME())) {
                return i;
            }
        }

        return -1;
    }

    public static int findDebitAccountIndex(int clientId, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i) instanceof DebitAccount && clientId == accounts.get(i).getCLIENT_ID()) {
                return i;
            }
        }

        return -1;
    }

    public static int findCreditAccountIndex(int clientId, ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i) instanceof CreditAccount && clientId == accounts.get(i).getCLIENT_ID()) {
                return i;
            }
        }

        return -1;
    }

    public static int findDebitCardIndex(String bankName, int clientId, ArrayList<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) instanceof DebitCard && bankName.equals(cards.get(i).getBANK_NAME())
                    && clientId == cards.get(i).getCLIENT_ID()) {
                return i;
            }
        }

        return -1;
    }

    public static int findCreditCardIndex(String bankName, int clientId, ArrayList<Card> cards) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) instanceof CreditCard && bankName.equals(cards.get(i).getBANK_NAME())
                    && clientId == cards.get(i).getCLIENT_ID()) {
                return i;
            }
        }

        return -1;
    }
}
