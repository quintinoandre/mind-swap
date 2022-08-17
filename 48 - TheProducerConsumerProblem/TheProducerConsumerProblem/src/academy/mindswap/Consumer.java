package academy.mindswap;

import academy.mindswap.container.Container;

public class Consumer implements Runnable {
  private final Container container;
  private final int platesToConsumer;
  private int eatenPlates;

  public Consumer(Container container, int plates) {
    this.container = container;
    this.platesToConsumer = plates;
  }

  @Override
  public void run() {
    while (eatenPlates < platesToConsumer) {
      synchronized (container) {
        container.poll();

        eatenPlates++;

        System.out.println(container + " - " + Thread.currentThread().getName());
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    System.out.println("consumer finished his job");
  }
}
