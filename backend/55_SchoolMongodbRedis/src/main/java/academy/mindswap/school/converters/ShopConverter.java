package academy.mindswap.school.converters;

import academy.mindswap.school.commands.shop.SaveShopDto;
import academy.mindswap.school.commands.shop.ShopDto;
import academy.mindswap.school.commands.shop.UpdateShopDto;
import academy.mindswap.school.models.Shop;

public final class ShopConverter {
    private ShopConverter() {
    }

    public static ShopDto convertToDto(Shop shop) {
        if (shop.getTeachersIds() != null) {
            return ShopDto.builder()
                    .id(shop.getId())
                    .name(shop.getName())
                    .rating(shop.getRating())
                    .teachersIds(shop.getTeachersIds())
                    .build();
        }

        return ShopDto.builder()
                .id(shop.getId())
                .name(shop.getName())
                .rating(shop.getRating())
                .build();
    }

    public static Shop convertSaveShopDtoToEntity(SaveShopDto saveShopDto) {
        return Shop.builder()
                .name(saveShopDto.getName())
                .rating(saveShopDto.getRating())
                .teachersIds(saveShopDto.getTeachersIds())
                .build();
    }

    public static Shop convertUpdateShopDtoToEntity(UpdateShopDto updateShopDto) {
        return Shop.builder()
                .name(updateShopDto.getName())
                .rating(updateShopDto.getRating())
                .teachersIds(updateShopDto.getTeachersIds())
                .build();
    }
}
