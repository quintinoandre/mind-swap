package academy.mindswap.school.exceptions.shops;

import academy.mindswap.school.exceptions.BadRequestException;

public class ShopBadRequestException extends BadRequestException {
    public ShopBadRequestException(String message) {
        super(message);
    }
}
