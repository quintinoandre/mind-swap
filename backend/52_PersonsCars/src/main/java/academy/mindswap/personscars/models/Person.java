package academy.mindswap.personscars.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private String password;
}
