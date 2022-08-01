package academy.mindswap.exceptions;

import static academy.mindswap.utils.Messages.NO_NULL_ELEMENT;

public class NotNullElementException extends ArrayIndexOutOfBoundsException {
    public NotNullElementException() {
        super(NO_NULL_ELEMENT);
    }
}

