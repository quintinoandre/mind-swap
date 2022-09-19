package academy.mindswap.springbootwithmongodb.commands;

import java.io.Serializable;

public class GetBitcoinAvgPriceDto implements Serializable {
    private Integer mins;
    private String price;

    public Integer getMins() {
        return mins;
    }

    public String getPrice() {
        return price;
    }
}
