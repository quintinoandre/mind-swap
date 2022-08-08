package academy.mindswap.exceptions;

import static academy.mindswap.utils.Messages.VALUES_NOT_THE_SAME_TYPE;

public class ValuesNotTheSameTypeException extends IllegalArgumentException {
    public ValuesNotTheSameTypeException() {
        super(VALUES_NOT_THE_SAME_TYPE);
    }
}
