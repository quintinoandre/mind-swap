package academy.mindswap.springbootwithmongodb.repositories;

import academy.mindswap.springbootwithmongodb.models.BitcoinAvgPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitcoinAvgPriceRepository extends MongoRepository<BitcoinAvgPrice, String> {
}
