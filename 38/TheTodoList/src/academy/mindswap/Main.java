package academy.mindswap;

import java.util.PriorityQueue;

import static academy.mindswap.Importance.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<TodoItem> queue = new PriorityQueue<>();

        queue.add(new TodoItem(MEDIUM, 1, "Wash dishes"));
        queue.add(new TodoItem(LOW, 1, "Take the trash out"));
        queue.add(new TodoItem(HIGH, 2, "Finish homework"));
        queue.add(new TodoItem(HIGH, 1, "Feed the dog"));
        queue.add(new TodoItem(MEDIUM, 1, "Go grocery shopping"));
        queue.add(new TodoItem(LOW, 2, "Call the hair salon"));
        queue.add(new TodoItem(HIGH, 2, "Pay bills"));

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }
}
