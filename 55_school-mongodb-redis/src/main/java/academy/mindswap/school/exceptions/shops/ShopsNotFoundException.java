package academy.mindswap.school.exceptions.shops;

import academy.mindswap.school.exceptions.NotFoundException;

import static academy.mindswap.school.exceptions.shops.ShopExceptionMessages.SHOPS_NOT_FOUND;

public class ShopsNotFoundException extends NotFoundException {
    public ShopsNotFoundException() {
        super(SHOPS_NOT_FOUND);
    }
}
