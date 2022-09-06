package academy.mindswap.personscars.services;

import academy.mindswap.personscars.models.Person;
import academy.mindswap.personscars.repositories.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person findById(Integer id) {
        Optional<Person> person = personRepository.findById(id);

        if (person.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person not found");
        }

        return person.get();
    }

    public List<Person> findAllByName(String name) {
        return personRepository.findAllByName(name);
    }

    public List<Person> findByIdGreaterThan(Integer id) {
        return personRepository.findByIdGreaterThan(id);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person updateById(Integer id, Person person) {
        Optional<Person> oldPerson = personRepository.findById(id);

        if (oldPerson.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person not found");
        }

        person.setId(id);

        return personRepository.save(person);
    }

    public void deleteById(Integer id) {
        Optional<Person> personOptional = personRepository.findById(id);

        if (personOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "person not found");
        }

        personRepository.deleteById(id);
    }
}
