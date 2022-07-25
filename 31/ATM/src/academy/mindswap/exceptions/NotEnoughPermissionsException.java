package academy.mindswap.exceptions;

import static academy.mindswap.Util.Messages.NOT_ENOUGH_PERMISSIONS;

public class NotEnoughPermissionsException extends ATMException {
    public NotEnoughPermissionsException() {
        super(NOT_ENOUGH_PERMISSIONS);
    }
}
