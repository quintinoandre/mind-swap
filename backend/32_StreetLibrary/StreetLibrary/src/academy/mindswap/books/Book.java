package academy.mindswap.books;

public class Book {
    private final String author;
    private final String name;
    private int stock;

    public Book(String author, String name, int stock) {
        this.author = author;
        this.name = name;
        this.stock = stock;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public void decreaseStock(int quantity) {
        stock -= quantity;
    }

    public void increaseStock(int quantity) {
        stock += quantity;
    }
}
