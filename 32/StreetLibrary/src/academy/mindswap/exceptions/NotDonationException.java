package academy.mindswap.exceptions;

import static academy.mindswap.utils.Messages.NOT_DONATION;

public final class NotDonationException extends LibraryException {
    public NotDonationException() {
        super(NOT_DONATION);
    }
}
