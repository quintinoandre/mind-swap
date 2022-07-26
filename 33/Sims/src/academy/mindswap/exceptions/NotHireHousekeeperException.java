package academy.mindswap.exceptions;

import static academy.mindswap.utils.Messages.NOT_HIRE_HOUSEKEEPER;

public class NotHireHousekeeperException extends SimsException {
    public NotHireHousekeeperException() {
        super(NOT_HIRE_HOUSEKEEPER);
    }
}
