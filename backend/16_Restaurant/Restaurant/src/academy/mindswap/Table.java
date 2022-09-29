package academy.mindswap;

public class Table {
  private boolean free = true;
  private String order = "";


  public void cleanOrder() {
    order = "";
  }

  public String getOrder() {
    return order;
  }

  public boolean isFree() {
    return free;
  }

  public void occupy() {
    free = false;
  }

  public void saveOrder(String order) {
    this.order = order;
  }

  public void unoccupy() {
    free = true;

    cleanOrder();
  }
}
