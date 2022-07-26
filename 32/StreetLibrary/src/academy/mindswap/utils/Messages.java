package academy.mindswap.utils;

public final class Messages {
    private Messages() {
    }

    public static final String NOT_STOCK = "The library does not have enough stock for this book, please choose another book.";
    public static final String NOT_DONATION = "You need to make a donation first.";
    public static final String BOOK_NOT_EXIST = "That book does not exist in this library.";
    public static final String CLIENT_BORROW_BOOK = "You borrow the book: %s by %s.%n";
    public static final String CLIENT_RETURN_BOOK = "You return the book: %s by %s.%n";
    public static final String CLIENT_TRY_BORROW_BOOK = "You try to borrow the book: %s by %s.%n";
    public static final String LIBRARY_STOCK = "Library stock for this book now is %d.%n";
}
