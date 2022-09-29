package academy.mindswap.container;

import java.util.Deque;
import java.util.LinkedList;

public class Container<T> {
  private final int limit;
  private final Deque<T> queue;

  public Container(int limit) {
    this.limit = limit;
    queue = new LinkedList<>();
  }

  public void offer(T item) {
    while (queue.size() == limit) {
      try {
        wait(); // IF THE CONTAINER IS FULL, THIS THREAD WILL WAIT UNTIL AN ITEM IS REMOVED
      } catch (InterruptedException e) {
        // thread.interrupt called, no handling needed
      }
    }

    queue.add(item);

    notifyAll(); // AN ITEM WAS INTRODUCED, SO WE SHOULD NOTIFY THE THREADS THAT ARE WAITING FOR CONSUMPTION
  }

  public T poll() {
    while (queue.size() == 0) {
      try {
        wait(); // IF THE CONTAINER IS EMPTY, THIS THREAD WILL WAIT UNTIL AN ITEM IS PRODUCED
      } catch (InterruptedException e) {
        // thread.interrupt called, no handling needed
      }
    }

    T item = queue.removeFirst();

    notifyAll(); // AN ITEM WAS CONSUMED, SO WE SHOULD NOTIFY THE THREADS THAT ARE WAITING FOR PRODUCTION
    
    return item;
  }

  public int getSize() {
    return queue.size();
  }

  public int getLimit() {
    return limit;
  }

  @Override
  public String toString() {
    return "Container{" +
        "queue=" + queue +
        '}';
  }
}
