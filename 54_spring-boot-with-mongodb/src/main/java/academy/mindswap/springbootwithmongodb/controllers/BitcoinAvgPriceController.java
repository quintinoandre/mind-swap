package academy.mindswap.springbootwithmongodb.controllers;

import academy.mindswap.springbootwithmongodb.models.BitcoinAvgPrice;
import academy.mindswap.springbootwithmongodb.services.BitcoinAvgPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bitcoin")
public class BitcoinAvgPriceController {
    private final BitcoinAvgPriceService bitcoinAvgPriceService;

    @Autowired
    public BitcoinAvgPriceController(BitcoinAvgPriceService bitcoinAvgPriceService) {
        this.bitcoinAvgPriceService = bitcoinAvgPriceService;
    }

    @GetMapping
    public BitcoinAvgPrice saveBitcoinAvgPriceDto() {
        return bitcoinAvgPriceService.saveBitcoinAvgPriceDto();
    }
}
