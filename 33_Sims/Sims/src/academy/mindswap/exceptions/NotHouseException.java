package academy.mindswap.exceptions;

import static academy.mindswap.utils.Messages.NOT_HOUSE;

public class NotHouseException extends SimsException {
    public NotHouseException() {
        super(NOT_HOUSE);
    }
}
