package academy.mindswap.springbootwithmongodb.api;

import academy.mindswap.springbootwithmongodb.commands.GetBitcoinAvgPriceDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public final class ApiHandlerImpl implements ApiHandler {
    @Override
    public GetBitcoinAvgPriceDto getBitcoinAvgPrice() {
        final String API_RESOURCE_URL = "https://api.binance.com/api/v3/avgPrice?symbol=BTCUSDT";

        return new RestTemplate().getForObject(API_RESOURCE_URL, GetBitcoinAvgPriceDto.class);
    }
}
