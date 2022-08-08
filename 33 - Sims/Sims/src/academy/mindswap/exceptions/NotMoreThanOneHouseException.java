package academy.mindswap.exceptions;

import static academy.mindswap.utils.Messages.NOT_MORE_THAN_ONE_HOUSE;

public class NotMoreThanOneHouseException extends SimsException {
    public NotMoreThanOneHouseException() {
        super(NOT_MORE_THAN_ONE_HOUSE);
    }
}
