package academy.mindswap.springbootwithmongodb.api;

import academy.mindswap.springbootwithmongodb.commands.GetBitcoinAvgPriceDto;

public interface ApiHandler {
    GetBitcoinAvgPriceDto getBitcoinAvgPrice();
}
