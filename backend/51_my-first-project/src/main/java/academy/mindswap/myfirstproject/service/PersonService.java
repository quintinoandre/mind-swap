package academy.mindswap.myfirstproject.service;

import academy.mindswap.myfirstproject.model.Person;
import academy.mindswap.myfirstproject.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }

    public List<Person> getPersons() {
        return personRepository.getPersons();
    }

    public Person createPerson(Person person) {
        return personRepository.createPerson(person);
    }
}
