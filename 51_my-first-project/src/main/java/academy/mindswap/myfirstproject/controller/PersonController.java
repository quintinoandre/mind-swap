package academy.mindswap.myfirstproject.controller;

import academy.mindswap.myfirstproject.model.Person;
import academy.mindswap.myfirstproject.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{name}")
    public List<Person> findByName(@PathVariable String name) {
        return personService.findByName(name);
    }

    @GetMapping("/all")
    public List<Person> getPersons() {
        return personService.getPersons();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
}
