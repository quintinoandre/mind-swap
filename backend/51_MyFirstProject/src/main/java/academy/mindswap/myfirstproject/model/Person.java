package academy.mindswap.myfirstproject.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String name;
    private String surname;
    private int age;
    private String city;
    private String country;
    private String email;
    private String phone;
    private String address;
    private String zip;
    private String password;
    private String confirmPassword;
}
