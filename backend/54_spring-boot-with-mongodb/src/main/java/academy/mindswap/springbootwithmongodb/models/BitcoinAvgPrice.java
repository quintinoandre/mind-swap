package academy.mindswap.springbootwithmongodb.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("bitcoin_avg_price")
@Data
public class BitcoinAvgPrice {
    @Id
    private String id;

    private Integer mins;
    private String price;

    public BitcoinAvgPrice(Integer mins, String price) {
        this.mins = mins;
        this.price = price;
    }
}
