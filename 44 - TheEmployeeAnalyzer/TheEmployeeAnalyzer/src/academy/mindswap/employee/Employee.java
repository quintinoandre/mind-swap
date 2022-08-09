package academy.mindswap.employee;

import java.time.LocalDate;
import java.util.UUID;

public class Employee {
  private static int employeeNumber;
  private final UUID id;
  private String firstName;
  private String lastName;
  private float salary;
  private LocalDate birthDate;
  private LocalDate startingDate;

  public Employee(String firstName, String lastName, float salary, String birthDate, String startDate) {
    ++employeeNumber;
    id = UUID.randomUUID();
    this.firstName = firstName;
    this.lastName = lastName;
    this.salary = salary;
    this.birthDate = LocalDate.parse(birthDate);
    this.startingDate = LocalDate.parse(startDate);
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", salary=" + salary +
        ", birthDate=" + birthDate +
        ", startingDate=" + startingDate +
        '}';
  }

  public static int getEmployeeNumber() {
    return employeeNumber;
  }

  public UUID getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFullName() {
    return new StringBuilder()
        .append(getFirstName())
        .append(" ")
        .append(getLastName())
        .toString();
  }

  public Float getSalary() {
    return salary;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public LocalDate getStartingDate() {
    return startingDate;
  }
}
