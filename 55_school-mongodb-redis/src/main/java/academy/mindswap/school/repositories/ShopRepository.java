package academy.mindswap.school.repositories;

import academy.mindswap.school.models.Shop;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShopRepository extends MongoRepository<Shop, Long> {
    Optional<Shop> findById(String id);

    List<Shop> findByTeachersIds(String teacherId);

    Boolean existsById(String id);

    Boolean existsByName(String name);

    void deleteById(String id);
}
