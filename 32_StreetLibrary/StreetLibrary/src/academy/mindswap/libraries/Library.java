package academy.mindswap.libraries;

import academy.mindswap.books.Book;
import academy.mindswap.books.BookType;
import academy.mindswap.exceptions.NotDonationException;
import academy.mindswap.exceptions.NotEnoughStockException;
import academy.mindswap.exceptions.NotExistingBookException;

import java.util.UUID;

import static academy.mindswap.utils.Messages.*;

public abstract class Library implements ILibrary {

    protected Book[] books;

    protected Library() {
        BookType[] bookTypes = BookType.values();

        books = new Book[bookTypes.length];

        for (int i = 0; i < books.length; i++) {
            books[i] = new Book(bookTypes[i].getAuthor(), bookTypes[i].getName(), 1);
        }
    }

    @Override
    public void borrowBookByName(String name, UUID clientId) throws NotDonationException, NotEnoughStockException,
            NotExistingBookException {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                if (book.getStock() < 1) {
                    System.out.printf(CLIENT_TRY_BORROW_BOOK, book.getName(), book.getAuthor());

                    throw new NotEnoughStockException();
                }

                book.decreaseStock(1);

                System.out.printf(CLIENT_BORROW_BOOK, book.getName(), book.getAuthor());

                System.out.printf(LIBRARY_STOCK, book.getStock());
            }

        }

        throw new NotExistingBookException();
    }

    @Override
    public void borrowBookByAuthor(String author, UUID clientId) throws NotDonationException, NotEnoughStockException,
            NotExistingBookException {
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                if (book.getStock() < 1) {
                    System.out.printf(CLIENT_TRY_BORROW_BOOK, book.getName(), book.getAuthor());

                    throw new NotEnoughStockException();
                }

                book.decreaseStock(1);

                System.out.printf(CLIENT_BORROW_BOOK, book.getName(), book.getAuthor());

                System.out.printf(LIBRARY_STOCK, book.getStock());
            }

        }

        throw new NotExistingBookException();
    }

    @Override
    public void returnBookByName(String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                book.increaseStock(1);

                System.out.printf(CLIENT_RETURN_BOOK, book.getName(), book.getAuthor());

                System.out.printf(LIBRARY_STOCK, book.getStock());
            }
        }
    }

    @Override
    public void returnBookByAuthor(String author) {
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                book.increaseStock(1);

                System.out.printf(CLIENT_RETURN_BOOK, book.getName(), book.getAuthor());

                System.out.printf(LIBRARY_STOCK, book.getStock());
            }
        }
    }
}
