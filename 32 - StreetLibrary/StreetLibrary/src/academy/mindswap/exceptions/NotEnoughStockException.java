package academy.mindswap.exceptions;

import static academy.mindswap.utils.Messages.NOT_STOCK;

public final class NotEnoughStockException extends LibraryException {
    public NotEnoughStockException() {
        super(NOT_STOCK);
    }
}
