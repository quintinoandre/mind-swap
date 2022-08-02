package academy.mindswap;

public class TodoItem implements Comparable<TodoItem> {
    private final Importance IMPORTANCE;
    private final Integer PRIORITY;
    private final String DESCRIPTION;

    public TodoItem(Importance importance, Integer priority, String description) {
        IMPORTANCE = importance;
        PRIORITY = priority;
        DESCRIPTION = description;
    }

    @Override
    public int compareTo(TodoItem todoItem) {
        if (IMPORTANCE.equals(todoItem.IMPORTANCE)) {
            return PRIORITY < todoItem.PRIORITY ? -1 : 1;
        }

        return IMPORTANCE.compareTo(todoItem.IMPORTANCE);
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "IMPORTANCE=" + IMPORTANCE +
                ", PRIORITY=" + PRIORITY +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                '}';
    }
}
