package academy.mindswap;

import academy.mindswap.exceptions.NotCardCreatedException;
import academy.mindswap.exceptions.NotCardInsertedException;
import academy.mindswap.exceptions.NotEnoughFundsException;
import academy.mindswap.exceptions.NotEnoughPermissionsException;

import static academy.mindswap.Util.Messages.*;

public class ATM {
    private Card card;

    private boolean pinIsCorrect;

    public void createCard() {
        card = new Card(1234, 100);
    }
    
    public void insertCard(int pin) throws NotCardCreatedException, NotEnoughPermissionsException {
        if (card == null) {
            throw new NotCardCreatedException();
        }

        if (pin != card.getPin()) {
            pinIsCorrect = false;

            throw new NotEnoughPermissionsException();
        }

        pinIsCorrect = true;

        System.out.printf(ENOUGH_PERMISSIONS);
    }

    public void withdraw(float amount) throws NotCardCreatedException, NotCardInsertedException, NotEnoughFundsException {
        if (card == null) {
            throw new NotCardCreatedException();
        }

        if (!pinIsCorrect) {
            throw new NotCardInsertedException();
        }

        if (amount > card.getBalance()) {
            throw new NotEnoughFundsException();
        }

        card.decreaseBalance(amount);

        System.out.printf(SUCCESSFULLY_WITHDRAW);

        System.out.printf(SHOW_BALANCE, card.getBalance());
    }

    public void deposit(float amount) throws NotCardCreatedException, NotCardInsertedException {
        if (card == null) {
            throw new NotCardCreatedException();
        }

        if (!pinIsCorrect) {
            throw new NotCardInsertedException();
        }

        card.increaseBalance(amount);

        System.out.printf(SUCCESSFULLY_DEPOSIT);

        System.out.printf(SHOW_BALANCE, card.getBalance());
    }
}
