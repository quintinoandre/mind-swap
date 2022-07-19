package academy.mindswap;

public class CreditAccount extends Account {

    public CreditAccount(int clientId) {
        super(clientId);

        minLimit = -100;
    }
}
