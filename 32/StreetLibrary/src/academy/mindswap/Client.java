package academy.mindswap;


import academy.mindswap.books.BookType;
import academy.mindswap.exceptions.NotDonationException;
import academy.mindswap.exceptions.NotEnoughStockException;
import academy.mindswap.exceptions.NotExistingBookException;
import academy.mindswap.factory.LibraryFactory;
import academy.mindswap.libraries.DonationLibrary;
import academy.mindswap.libraries.FreeLibrary;
import academy.mindswap.libraries.Library;
import academy.mindswap.libraries.LibraryType;
import academy.mindswap.utils.RandomGenerator;

import java.util.UUID;

import static academy.mindswap.libraries.LibraryType.DONATION_LIBRARY;
import static academy.mindswap.libraries.LibraryType.FREE_LIBRARY;

public class Client {
    private final UUID id;
    private final String name;

    private LibraryType[] libraryTypes;
    private Library[] libraries;

    public Client(String name) {
        id = UUID.randomUUID();
        this.name = name;
        libraryTypes = LibraryType.values();
        libraries = new Library[libraryTypes.length];
    }

    public void setLibraries() {
        for (int i = 0; i < libraries.length; i++) {
            libraries[i] = LibraryFactory.create(libraryTypes[i]);
        }
    }

    public BookType chooseBook() {
        BookType[] books = BookType.values();

        int randomIndex = RandomGenerator.generateRandom(0, books.length - 1);

        return books[randomIndex];
    }

    public void borrowBookByName(String name, LibraryType libraryType) {
        for (Library library : libraries) {
            if (libraryType == FREE_LIBRARY && library instanceof FreeLibrary) {
                try {
                    library.borrowBookByName(name, id);
                } catch (NotDonationException error) {
                    System.out.println(error.getMessage());
                } catch (NotEnoughStockException error) {
                    System.out.println(error.getMessage());
                } catch (NotExistingBookException error) {
                    System.out.println(error.getMessage());
                }
            }

            if (libraryType == DONATION_LIBRARY && library instanceof DonationLibrary) {
                try {
                    library.borrowBookByName(name, id);
                } catch (NotDonationException error) {
                    System.out.println(error.getMessage());
                } catch (NotEnoughStockException error) {
                    System.out.println(error.getMessage());
                } catch (NotExistingBookException error) {
                    System.out.println(error.getMessage());
                }
            }
        }
    }

    public void borrowBookByAuthor(String author, LibraryType libraryType) {
        for (Library library : libraries) {
            if (libraryType == FREE_LIBRARY && library instanceof FreeLibrary) {
                try {
                    library.borrowBookByAuthor(author, id);
                } catch (NotDonationException error) {
                    System.out.println(error.getMessage());
                } catch (NotEnoughStockException error) {
                    System.out.println(error.getMessage());
                } catch (NotExistingBookException error) {
                    System.out.println(error.getMessage());
                }
            }

            if (libraryType == DONATION_LIBRARY && library instanceof DonationLibrary) {
                try {
                    library.borrowBookByAuthor(author, id);
                } catch (NotDonationException error) {
                    System.out.println(error.getMessage());
                } catch (NotEnoughStockException error) {
                    System.out.println(error.getMessage());
                } catch (NotExistingBookException error) {
                    System.out.println(error.getMessage());
                }
            }
        }
    }

    public void returnBookByName(String name, LibraryType libraryType) {
        for (Library library : libraries) {
            if (libraryType == FREE_LIBRARY && library instanceof FreeLibrary) {
                library.returnBookByName(name);
            }

            if (libraryType == DONATION_LIBRARY && library instanceof DonationLibrary) {
                library.returnBookByName(name);
            }
        }
    }

    public void returnBookByAuthor(String author, LibraryType libraryType) {
        for (Library library : libraries) {
            if (libraryType == FREE_LIBRARY && library instanceof FreeLibrary) {
                library.returnBookByAuthor(author);
            }

            if (libraryType == DONATION_LIBRARY && library instanceof DonationLibrary) {
                library.returnBookByAuthor(author);
            }
        }
    }

    public void madeDonation() {
        for (Library library : libraries) {
            if (library instanceof DonationLibrary) {
                ((DonationLibrary) library).madeDonation(id);
            }
        }
    }
}
