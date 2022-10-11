package academy.mindswap.personscars.controller;

import academy.mindswap.personscars.models.Person;
import academy.mindswap.personscars.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Integer id) {
        return personService.findById(id);
    }

    @GetMapping("/byname/{name}")
    public List<Person> findAllByName(@PathVariable String name) {
        return personService.findAllByName(name);
    }

    @GetMapping("/byidgreaterthan/{id}")
    public List<Person> findByIdGreaterThan(@PathVariable Integer id) {
        return personService.findByIdGreaterThan(id);
    }

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @PutMapping("/{id}")
    public Person updateById(@PathVariable Integer id, @RequestBody Person person) {
        return personService.updateById(id, person);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        personService.deleteById(id);
    }
}
