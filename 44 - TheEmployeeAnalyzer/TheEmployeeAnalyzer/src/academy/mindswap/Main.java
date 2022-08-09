package academy.mindswap;

import academy.mindswap.employee.Employee;

import java.util.List;

import static academy.mindswap.db.DB.getDevelopmentDepartment;
import static academy.mindswap.db.DB.getMarketingDepartment;

public class Main {
  public static void main(String[] args) {
    List<Employee> employeeList1 = getDevelopmentDepartment();

    List<Employee> employeeList2 = getMarketingDepartment();

    System.out.println("number of employees that having been working at that department for more than n years:");

    System.out.println(EmployeeAnalyzer.checkNumberOfEmployeesWorkingSinceNYears(employeeList1, 3));

    System.out.println("\nname of the employees that have a salary over n:");

    EmployeeAnalyzer.checkEmployeesWithSalaryOverN(employeeList1, 1400f).forEach(System.out::println);

    System.out.println("\noldest n employees");

    EmployeeAnalyzer.checkTheOldestNEmployees(employeeList1, 3).forEach(System.out::println);

    System.out.println("\nfirst employee older than n");

    try {
      System.out.println(EmployeeAnalyzer.checkTheFirstEmployeeOlderThanN(employeeList1, 35));
    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("\naverage salary in a department");

    System.out.println(EmployeeAnalyzer.calculateTheAverageSalary(employeeList1));

    System.out.println("\ncommon first names between the employees of two departments");

    EmployeeAnalyzer.checkCommonFirstNamesBetweenTheEmployeesOfTwoDepartments(employeeList1, employeeList2)
        .forEach(System.out::println);
  }
}
