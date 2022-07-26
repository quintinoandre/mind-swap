package academy.mindswap.exceptions;

import static academy.mindswap.utils.Messages.NOT_CLEAN_HOUSE;

public class NotCleanHouseException extends SimsException {
    public NotCleanHouseException() {
        super(NOT_CLEAN_HOUSE);
    }
}
