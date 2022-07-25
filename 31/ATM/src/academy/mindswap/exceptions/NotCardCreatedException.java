package academy.mindswap.exceptions;

import static academy.mindswap.Util.Messages.NOT_CARD_CREATED;

public class NotCardCreatedException extends ATMException {
    public NotCardCreatedException() {
        super(NOT_CARD_CREATED);
    }
}
