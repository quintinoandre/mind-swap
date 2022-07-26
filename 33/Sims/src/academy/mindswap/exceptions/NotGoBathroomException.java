package academy.mindswap.exceptions;

import static academy.mindswap.utils.Messages.NOT_GO_BATHROOM;

public class NotGoBathroomException extends SimsException {
    public NotGoBathroomException() {
        super(NOT_GO_BATHROOM);
    }
}
