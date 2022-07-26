package academy.mindswap.exceptions;

import static academy.mindswap.utils.Messages.BOOK_NOT_EXIST;

public final class NotExistingBookException extends LibraryException {
    public NotExistingBookException() {
        super(BOOK_NOT_EXIST);
    }
}
