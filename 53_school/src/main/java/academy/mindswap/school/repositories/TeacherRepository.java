package academy.mindswap.school.repositories;

import academy.mindswap.school.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Optional<Teacher> findByEmail(String email);

    @Query(value = "SELECT * FROM teachers WHERE email = :email", nativeQuery = true)
    Optional<Teacher> findByEmailWithRoles(String email);

    Optional<Teacher> findByCarsId(Long id);

    List<Teacher> findByShopsId(Long id);

    Boolean existsByEmail(String email);
}
