package academy.mindswap.exceptions;

import static academy.mindswap.Util.Messages.NOT_ENOUGH_FUNDS;

public class NotEnoughFundsException extends ATMException {
    public NotEnoughFundsException() {
        super(NOT_ENOUGH_FUNDS);
    }
}
