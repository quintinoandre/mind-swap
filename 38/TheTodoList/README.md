```java
private final PriorityQueue<TodoItem> QUEUE=new PriorityQueue<>();
```

```java
enum Importance {
    HIGH,
    MEDIUM,
    LOW
}
```

```java
public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        todoList.add(Importance.MEDIUM, 1, "Wash dishes");
        todoList.add(Importance.LOW, 1, "Take the trash out");
        todoList.add(Importance.HIGH, 2, "Finish homework");
        todoList.add(Importance.HIGH, 1, "Feed the dog");
        todoList.add(Importance.MEDIUM, 1, "Go grocery shopping");
        todoList.add(Importance.LOW, 2, "Call the hair salon");
        todoList.add(Importance.HIGH, 2, "Pay bills");
/*int listSize = todoList.size();
for (int i = 0; i < listSize; i++) {
System.out.println(todoList.remove());
}*/
        while (!todoList.isEmpty()) {
            System.out.println(todoList.remove());
        }
    }
}
```

```java
private final Importance IMPORTANCE; //ENUM
private final Integer PRIORITY;
private final String DESCRIPTION;

public TodoItem(Importance importance,int priority,String description){
        this.IMPORTANCE=importance;
        this.PRIORITY=priority;
        this.DESCRIPTION=description;
        }
```

