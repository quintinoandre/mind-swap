package academy.mindswap;

public class Client {
  private int tableNumber = 0;
  private Restaurant restaurant = null;

  public void askForTable() {
    if (tableNumber > 0) {
      Print.message("I already have a table!");

      return;
    }

    tableNumber = restaurant.findTable();
  }

  public void order(String order) {
    boolean amIAtTheRestaurant = checkRestaurantPresence();

    if (amIAtTheRestaurant) {
      if (tableNumber > 0) {
        restaurant.order(order, tableNumber);

        return;
      }

      Print.message("You need a table before you can eat.");

      return;
    }

    Print.message("Oh wait... I need to go to a restaurant before I can do this...");
  }

  public void pay() {
    if (tableNumber > 0) {
      boolean tableWasFree = restaurant.freeTable(tableNumber);

      if (tableWasFree) {
        tableNumber = 0;
      }

      return;
    }

    Print.message("You don't even have a table... What are you doing?");
  }

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }

  private boolean checkRestaurantPresence() {
    return restaurant != null;
  }
}
