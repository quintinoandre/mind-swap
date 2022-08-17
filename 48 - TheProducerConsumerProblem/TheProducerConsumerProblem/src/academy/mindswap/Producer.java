package academy.mindswap;

import academy.mindswap.container.Container;

public class Producer implements Runnable {
  private final Container container;
  private final int platesToProduce;
  private int cookedPlates;

  public Producer(Container container, int plates) {
    this.container = container;
    this.platesToProduce = plates;
  }

  @Override
  public void run() {
    while (cookedPlates < platesToProduce) {
      synchronized (container) {
        container.offer(cookedPlates + 1);

        cookedPlates++;

        System.out.println(container);
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    System.out.println("producer finished his job");
  }
}
