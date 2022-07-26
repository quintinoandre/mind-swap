package academy.mindswap.exceptions;

import static academy.mindswap.utils.Messages.NOT_PAID_HOUSEKEEPER;

public class NotPaidHousekeeperException extends SimsException {
    public NotPaidHousekeeperException() {
        super(NOT_PAID_HOUSEKEEPER);
    }
}
