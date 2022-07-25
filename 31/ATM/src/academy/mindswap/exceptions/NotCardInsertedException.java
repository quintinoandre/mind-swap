package academy.mindswap.exceptions;

import static academy.mindswap.Util.Messages.NOT_CARD_INSERTED;

public class NotCardInsertedException extends ATMException {
    public NotCardInsertedException() {
        super(NOT_CARD_INSERTED);
    }
}
