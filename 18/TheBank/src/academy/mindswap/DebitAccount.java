package academy.mindswap;

import static academy.mindswap.Print.NO_DEBIT_BALANCE;

public class DebitAccount extends Account {
    public DebitAccount(int clientId) {
        super(clientId);
    }

    public void makeWithraw(float amount) {
        if (balance < amount) {
            Print.message(NO_DEBIT_BALANCE);

            return;
        }

        decreaseBalance(amount);
    }

}
