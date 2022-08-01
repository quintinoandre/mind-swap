package academy.mindswap.exceptions;

import static academy.mindswap.utils.Messages.NOT_EXISTING_ELEMENT;

public class NotExistingElementException extends ArrayIndexOutOfBoundsException {
    public NotExistingElementException() {
        super(NOT_EXISTING_ELEMENT);
    }
}

