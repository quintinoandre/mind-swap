package academy.mindswap.springbootwithmongodb.services;

import academy.mindswap.springbootwithmongodb.api.ApiHandler;
import academy.mindswap.springbootwithmongodb.commands.GetBitcoinAvgPriceDto;
import academy.mindswap.springbootwithmongodb.models.BitcoinAvgPrice;
import academy.mindswap.springbootwithmongodb.repositories.BitcoinAvgPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BitcoinAvgPriceService {
    private final BitcoinAvgPriceRepository bitcoinAvgPriceRepository;
    private final ApiHandler apiHandler;

    @Autowired
    public BitcoinAvgPriceService(BitcoinAvgPriceRepository bitcoinAvgPriceRepository, ApiHandler apiHandler) {
        this.bitcoinAvgPriceRepository = bitcoinAvgPriceRepository;
        this.apiHandler = apiHandler;
    }

    public BitcoinAvgPrice saveBitcoinAvgPriceDto() {
        GetBitcoinAvgPriceDto getBitcoinAvgPrice = apiHandler.getBitcoinAvgPrice();

        return bitcoinAvgPriceRepository.save(new BitcoinAvgPrice(getBitcoinAvgPrice.getMins(), getBitcoinAvgPrice.getPrice()));
    }
}
