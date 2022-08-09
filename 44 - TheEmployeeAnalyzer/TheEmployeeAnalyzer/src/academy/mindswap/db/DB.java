package academy.mindswap.db;

import academy.mindswap.employee.Employee;

import java.util.Arrays;
import java.util.List;

public final class DB {
  private DB() {
  }

  private static final List<Employee> hrDepartment = Arrays.asList(
      new Employee("Edna", "Heller", 1450f, "1987-09-01", "2014-01-01"),
      new Employee("Reina", "Hopkins", 1500f, "1979-01-01", "2014-01-01"),
      new Employee("Frank", "Hoots", 1400f, "1987-01-01", "2016-01-01"),
      new Employee("Diana", "McCall", 1400f, "1992-01-01", "2016-01-01"),
      new Employee("Peter", "O'Brien", 1350f, "1993-01-01", "2017-01-01"),
      new Employee("Mary", "Singer", 1400f, "1990-01-01", "2017-01-01"),
      new Employee("Samuel", "Rhodes", 1350f, "1994-01-01", "2017-01-01"),
      new Employee("Rita", "Myers", 1250f, "1996-01-01", "2019-01-01"),
      new Employee("James", "Milne", 1350f, "1994-01-01", "2019-01-01"),
      new Employee("Petra", "Boyan", 1250f, "1994-01-01", "2019-01-01"),
      new Employee("Fred", "Zachary", 1350f, "1992-01-01", "2019-01-01"),
      new Employee("Diana", "Fuentes", 1350f, "1996-01-01", "2019-01-01"),
      new Employee("Katherine", "Mills", 1250f, "1998-01-01", "2019-01-01"),
      new Employee("Brian", "Ashby", 1450f, "1979-01-01", "2019-01-01"),
      new Employee("Tracy", "Forge", 1200f, "1999-01-01", "2020-01-01"),
      new Employee("Amir", "Ishaan", 1200f, "1998-01-01", "2020-01-01"),
      new Employee("Lucas", "Wright", 1200f, "1999-01-01", "2020-01-01"),
      new Employee("Mary", "Winston", 1200f, "1998-01-01", "2020-01-01")
  );

  private static final List<Employee> salesDepartment = Arrays.asList(
      new Employee("Melissa", "Ashby", 1600f, "1977-01-01", "2014-01-01"),
      new Employee("William", "Bourne", 1550f, "1987-01-01", "2015-01-01"),
      new Employee("Emily", "Walsh", 1550f, "1985-01-01", "2015-01-01"),
      new Employee("Luke", "Freedman", 1500f, "1988-01-01", "2015-01-01"),
      new Employee("Grace", "Sherman", 1550f, "1988-01-01", "2015-01-01"),
      new Employee("James", "Campbell", 1600f, "1979-01-01", "2016-01-01"),
      new Employee("Oliver", "Wallace", 1450f, "1988-01-01", "2016-01-01"),
      new Employee("Seth", "Geller", 1450f, "1990-01-01", "2017-01-01"),
      new Employee("Michaela", "Mendes", 1450f, "1992-01-01", "2017-01-01"),
      new Employee("Baron", "Margo", 1400f, "1991-01-01", "2018-01-01"),
      new Employee("Ariana", "McLoughlin", 1450f, "1989-01-01", "2018-01-01"),
      new Employee("Lou", "Sakamoto", 1400f, "1991-01-01", "2018-01-01"),
      new Employee("Luke", "Tanner", 1350f, "1991-01-01", "2019-01-01"),
      new Employee("Ursula", "Crane", 1500f, "1988-01-01", "2019-01-01"),
      new Employee("Mary", "Biggs", 1300f, "1997-01-01", "2019-01-01")
  );

  private static final List<Employee> marketingDepartment = Arrays.asList(
      new Employee("Patricia", "Hartley", 1500f, "1986-01-01", "2016-01-01"),
      new Employee("John", "Nguyen", 1500f, "1987-01-01", "2017-01-01"),
      new Employee("Janine", "Styles", 1450f, "1988-01-01", "2017-01-01"),
      new Employee("Alexandra", "Antero", 1400f, "1990-01-01", "2018-01-01"),
      new Employee("Holly", "Anderson", 1350f, "1995-01-01", "2019-01-01"),
      new Employee("Fred", "Amos", 1400f, "1992-01-01", "2019-01-01"),
      new Employee("Owen", "Brahim", 1350f, "1991-01-01", "2019-01-01"),
      new Employee("Ross", "Greene", 1400f, "1991-01-01", "2019-01-01"),
      new Employee("Sarah", "Bauer", 1300f, "1996-01-01", "2020-01-01"),
      new Employee("Theresa", "Thomsen", 1250f, "1997-01-01", "2020-01-01")
  );

  private static final List<Employee> developmentDepartment = Arrays.asList(
      new Employee("Roy", "Richardson", 1850f, "1969-01-01", "2014-01-01"),
      new Employee("George", "Tehran", 1850f, "1974-01-01", "2014-01-01"),
      new Employee("Ruth", "Robson", 1850f, "1974-01-01", "2014-01-01"),
      new Employee("Alina", "Hall", 1800f, "1979-01-01", "2015-01-01"),
      new Employee("George", "Tanner", 1800f, "1977-01-01", "2015-01-01"),
      new Employee("Peter", "Winchester", 1750f, "1984-01-01", "2016-01-01"),
      new Employee("Victor", "Sanchez", 1700f, "1987-01-01", "2016-01-01"),
      new Employee("Sarah", "Lopez", 1600f, "1987-01-01", "2017-01-01"),
      new Employee("Deirdre", "Finn", 1750f, "1986-01-01", "2017-01-01"),
      new Employee("Emily", "Young", 1600f, "1988-01-01", "2017-01-01"),
      new Employee("Zena", "Porter", 1600f, "1986-01-01", "2018-01-01"),
      new Employee("Tanner", "Clark", 1600f, "1988-01-01", "2018-01-01"),
      new Employee("Ava", "Kerr", 1550f, "1987-01-01", "2018-01-01"),
      new Employee("William", "Joyce", 1500f, "1991-01-01", "2018-01-01"),
      new Employee("Tristan", "Charlton", 1450f, "1995-01-01", "2019-01-01"),
      new Employee("Kirsten", "Trotter", 1400f, "1994-01-01", "2019-01-01"),
      new Employee("Tom", "Robertson", 1650f, "1991-01-01", "2019-01-01"),
      new Employee("Patricia", "Rooster", 1350f, "1997-01-01", "2019-01-01"),
      new Employee("Sarah", "Murphy", 1300f, "1996-01-01", "2019-01-01"),
      new Employee("Grant", "Hamilton", 1300f, "1997-01-01", "2019-01-01"),
      new Employee("Aaron", "Bell", 1400f, "1990-01-01", "2019-01-01"),
      new Employee("Adriana", "Barilski", 1300f, "1995-01-01", "2019-01-01"),
      new Employee("Georgina", "Ives", 1300f, "1998-01-01", "2019-01-01"),
      new Employee("Alex", "Nunes", 1350f, "1996-01-01", "2019-01-01"),
      new Employee("Winston", "Craig", 1500f, "1991-01-01", "2019-01-01"),
      new Employee("Oliver", "Styles", 1250f, "1997-01-01", "2019-01-01"),
      new Employee("John", "Heller", 1350f, "1995-01-01", "2020-01-01"),
      new Employee("Anna", "Vernon", 1300f, "1996-01-01", "2020-01-01"),
      new Employee("Riley", "Beischel", 1250f, "1997-01-01", "2020-01-01"),
      new Employee("Mary", "Forbes", 1400f, "1993-01-01", "2020-01-01"),
      new Employee("Liam", "Miller", 1250f, "1998-01-01", "2020-01-01"),
      new Employee("Reece", "Duckstein", 1250f, "1996-01-01", "2020-01-01"),
      new Employee("Laura", "Duckstein", 1250f, "1997-01-01", "2020-01-01"),
      new Employee("Reuben", "Stawarski", 1250f, "1998-01-01", "2020-01-01"),
      new Employee("Nathaniel", "Porter", 1300f, "1996-01-01", "2020-01-01"),
      new Employee("Fred", "Nichols", 1300f, "1996-01-01", "2020-01-01"),
      new Employee("Kevin", "Beardsley", 1450f, "1987-01-01", "2020-01-01"),
      new Employee("Emily", "Barnacle", 1250f, "1998-01-01", "2020-01-01"),
      new Employee("Brian", "Mills", 1250f, "1997-01-01", "2020-01-01")
  );

  public static List<Employee> getHrDepartment() {
    return hrDepartment;
  }

  public static List<Employee> getSalesDepartment() {
    return salesDepartment;
  }

  public static List<Employee> getMarketingDepartment() {
    return marketingDepartment;
  }

  public static List<Employee> getDevelopmentDepartment() {
    return developmentDepartment;
  }
}
