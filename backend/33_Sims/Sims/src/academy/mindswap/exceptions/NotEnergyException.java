package academy.mindswap.exceptions;

import static academy.mindswap.utils.Messages.NOT_ENERGY;

public class NotEnergyException extends SimsException {
    public NotEnergyException() {
        super(NOT_ENERGY);
    }
}
