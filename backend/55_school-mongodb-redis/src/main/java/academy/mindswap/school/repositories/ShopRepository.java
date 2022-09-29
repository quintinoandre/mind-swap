package academy.mindswap.school.repositories;

import academy.mindswap.school.models.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends MongoRepository<Shop, String> {
    List<Shop> findByTeachersIds(String teacherId);

    Boolean existsByName(String name);
}
