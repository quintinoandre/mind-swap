package academy.mindswap.personscars.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String brand;
    private String model;
    @Column(name = "license_plate")
    private String licensePlate;
}
