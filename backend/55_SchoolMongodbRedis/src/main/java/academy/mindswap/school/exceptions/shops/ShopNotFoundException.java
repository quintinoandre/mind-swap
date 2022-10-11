package academy.mindswap.school.exceptions.shops;

import academy.mindswap.school.exceptions.NotFoundException;

import static academy.mindswap.school.exceptions.shops.ShopExceptionMessages.SHOP_NOT_FOUND;

public class ShopNotFoundException extends NotFoundException {
    public ShopNotFoundException() {
        super(SHOP_NOT_FOUND);
    }
}
