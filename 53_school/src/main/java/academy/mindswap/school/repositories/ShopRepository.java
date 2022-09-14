package academy.mindswap.school.repositories;

import academy.mindswap.school.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    List<Shop> findByTeachersId(Long teacherId);

    Boolean existsByName(String name);
}
