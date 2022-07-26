package academy.mindswap.libraries;

import academy.mindswap.exceptions.NotDonationException;
import academy.mindswap.exceptions.NotEnoughStockException;
import academy.mindswap.exceptions.NotExistingBookException;

import java.util.UUID;

public interface ILibrary {
    void borrowBookByName(String name, UUID clientId) throws NotDonationException, NotEnoughStockException,
            NotExistingBookException;

    void borrowBookByAuthor(String author, UUID clientId) throws NotDonationException, NotEnoughStockException,
            NotExistingBookException;

    void returnBookByName(String name);

    void returnBookByAuthor(String author);
}
