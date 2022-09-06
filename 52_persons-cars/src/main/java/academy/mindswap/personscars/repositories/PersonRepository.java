package academy.mindswap.personscars.repositories;

import academy.mindswap.personscars.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    @Query(value = "SELECT * FROM persons WHERE name LIKE %:name%", nativeQuery = true)
    List<Person> findAllByName(String name);

    List<Person> findByIdGreaterThan(Integer id);
}
