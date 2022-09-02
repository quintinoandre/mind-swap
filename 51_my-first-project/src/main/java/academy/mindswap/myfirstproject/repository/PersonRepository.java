package academy.mindswap.myfirstproject.repository;

import academy.mindswap.myfirstproject.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private final List<Person> persons;

    public PersonRepository() {
        persons = new ArrayList<>(List.of(Person.builder()
                .name("John")
                .surname("Doe")
                .age(30)
                .city("New York")
                .country("USA")
                .email("aluno@swap.pt")
                .phone("+1-212-555-1234")
                .address("123 Main Street")
                .zip("10001")
                .password("password")
                .confirmPassword("password")
                .build()));
    }

    public List<Person> findByName(String name) {
        return persons.stream().filter(person -> person.getName().equals(name)).toList();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public Person createPerson(Person person) {
        persons.add(person);

        return person;
    }
}
