package academy.mindswap;

public abstract class Print {

    public static final String NO_BANK = "You are not a client of this bank. Please open a new account with us.";
    public static final String EXISTING_DEBIT_ACCOUNT = "You already have a debit account here. Please choose another bank.";
    public static final String EXISTING_CREDIT_ACCOUNT = "You already have a credit account here. Please choose another bank.";
    public static final String NON_EXISTING_DEBIT_ACCOUNT = "You don't have a debit account here. Please create a new one.";
    public static final String NON_EXISTING_CREDIT_ACCOUNT = "Youn don't have a credit account here. Please create a new one.";
    public static final String NO_DEBIT_CARD = "You don't have a debit card for this account. Please ask for one.";
    public static final String EXISTING_DEBIT_CARD = "You already have a debit card for this account.";
    public static final String NO_CREDIT_CARD = "You don't have a credit card for this account. Please ask for one.";

    public static final String EXISTING_CREDIT_CARD = "You already have a credit card for this account.";

    public static final String NO_DEBIT_BALANCE = "You don't have enough balance for this transaction.";
    public static final String NO_CREDIT_BALANCE = "You don't have enough credit balance for this transaction.";

    public static final String NO_CREDIT_WITHRAW = "You can't make a withdraw with the credit card.";

    public static void message(String message) {
        System.out.println(message);
    }
}
