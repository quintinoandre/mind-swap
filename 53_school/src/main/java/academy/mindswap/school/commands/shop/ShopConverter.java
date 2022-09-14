package academy.mindswap.school.commands.shop;

import academy.mindswap.school.models.Shop;

public final class ShopConverter {
    private ShopConverter() {
    }

    public static ShopDto convertToDto(Shop shop) {
        return ShopDto.builder()
                .id(shop.getId())
                .name(shop.getName())
                .rating(shop.getRating())
                //.teachersDtos(shop.getTeachers().stream().map(ShopConverter::convertToDto).toList())
                .build();
    }

    public static Shop convertSaveShopDtoToEntity(SaveShopDto saveShopDto) {
        return Shop.builder()
                .name(saveShopDto.getName())
                .rating(saveShopDto.getRating())
                .build();
    }

    public static Shop convertUpdateShopDtoToEntity(UpdateShopDto updateShopDto) {
        return Shop.builder()
                .name(updateShopDto.getName())
                .rating(updateShopDto.getRating())
                .build();
    }
}
