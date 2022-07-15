package academy.mindswap;

public class Restaurant {
  private boolean fullCapacity = false;
  private int numberOfOccupiedTables = 0;
  private Table[] tables;

  public Restaurant(int numberOfTables) {
    this.tables = new Table[numberOfTables];
  }

  public int findTable() {
    if (!fullCapacity) {
      for (int i = 0; i < tables.length; i++) {
        if (tables[i] == null) {
          tables[i] = new Table();
        }

        if (tables[i] == null || tables[i].isFree()) {
          occupyTable(i);

          return i + 1;
        }
      }
    }

    int tableNumber = checkIfTableCanBeFreed();

    if (tableNumber > 0) {
      freeTable(tableNumber);

      fullCapacity = false;

      return tableNumber;
    }

    Print.message("We're full, sorry. Kindly go away.");

    return 0;
  }

  public boolean freeTable(int tableNumber) {
    if (tables[tableNumber - 1].getOrder().equals("")) {
      Print.message("Sorry, but you need to order before you leave.");

      return false;
    }

    tables[tableNumber - 1].unoccupy();

    numberOfOccupiedTables -= 1;

    if (fullCapacity) {
      fullCapacity = false;
    }

    Print.message("Don't forget to tip us your way out!");

    return true;
  }

  public void order(String order, int tableNumber) {
    if (!tables[tableNumber - 1].getOrder().equals("")) {
      Print.message("This table already has an order. You can't place a new one.");

      return;
    }

    tables[tableNumber - 1].saveOrder(order);

    System.out.printf("Here's a hot plate of %s%n", order);
  }

  private int checkIfTableCanBeFreed() {
    for (int i = 0; i < tables.length; i++) {
      if (tables[i].isFree()) {
        return i + 1;
      }
    }

    return 0;
  }

  private void occupyTable(int tableNumber) {
    tables[tableNumber].occupy();

    numberOfOccupiedTables += 1;

    if (numberOfOccupiedTables == tables.length) {
      fullCapacity = true;
    }

    System.out.printf("Welcome! Here's your table number: %d%n", tableNumber + 1);
  }
}
