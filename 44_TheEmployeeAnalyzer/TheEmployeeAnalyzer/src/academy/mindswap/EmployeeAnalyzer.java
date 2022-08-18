package academy.mindswap;

import academy.mindswap.employee.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public final class EmployeeAnalyzer {
  private EmployeeAnalyzer() {
  }

  private static int checkEmployeeAge(Employee employee) {
    return Period
        .between(employee.getBirthDate(), LocalDate.now())
        .getYears();
  }

  public static long checkNumberOfEmployeesWorkingSinceNYears(List<Employee> employeeList, int years) {
    return employeeList.stream()
        .filter(employee ->
            (Period
                .between(employee.getStartingDate(), LocalDate.now())
                .getYears()) > years)
        .count();
  }

  public static List<String> checkEmployeesWithSalaryOverN(List<Employee> employeeList, float salary) {
    return employeeList.stream()
        .filter(employee -> employee.getSalary() > salary)
        .map(Employee::getFullName)
        .toList();
  }

  public static List<Employee> checkTheOldestNEmployees(List<Employee> employeeList, int numberOfEmployees) {
    return employeeList.stream()
        .sorted((o1, o2) -> (int) (o1.getBirthDate().toEpochDay() - o2.getBirthDate().toEpochDay()))
        .limit(numberOfEmployees)
        .toList();
  }

  public static Employee checkTheFirstEmployeeOlderThanN(List<Employee> employeeList, int years)
      throws ClassNotFoundException {
    Optional<Employee> optional = employeeList.stream()
        .filter(employee -> checkEmployeeAge(employee) > years)
        .findFirst();

    if (optional.isPresent()) {
      return optional.get();
    }

    throw new ClassNotFoundException("employee not found.");
  }

  public static double calculateTheAverageSalary(List<Employee> employeeList) {
    OptionalDouble optionalDouble = employeeList.stream()
        .mapToDouble(Employee::getSalary)
        .average();

    return optionalDouble.isPresent() ? optionalDouble.getAsDouble() : 0;
  }

  public static Set<String> checkCommonFirstNamesBetweenTheEmployeesOfTwoDepartments(
      List<Employee> employeeList1, List<Employee> employeeList2) {
    return new HashSet<>(employeeList1.stream()
        .map(Employee::getFirstName)
        .filter(firstName -> employeeList2.stream()
            .map(Employee::getFirstName)
            .toList()
            .contains(firstName))
        .toList());
  }
}
