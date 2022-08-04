package academy.mindswap.exceptions;

import static academy.mindswap.utils.Messages.WRONG_TYPE_OF_VALUES;

public class WrongTypeOfValuesException extends IllegalArgumentException {
    public WrongTypeOfValuesException() {
        super(WRONG_TYPE_OF_VALUES);
    }
}
