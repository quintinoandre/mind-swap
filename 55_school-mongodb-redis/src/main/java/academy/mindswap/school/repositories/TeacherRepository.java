package academy.mindswap.school.repositories;

import academy.mindswap.school.models.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends MongoRepository<Teacher, Long> {
    Optional<Teacher> findById(String id);

    Optional<Teacher> findByEmail(String email);

    Boolean existsByEmail(String email);

    Boolean existsById(String id);

    void deleteById(String id);
}
