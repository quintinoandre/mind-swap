package academy.mindswap;

import academy.mindswap.books.BookType;

import static academy.mindswap.libraries.LibraryType.DONATION_LIBRARY;
import static academy.mindswap.libraries.LibraryType.FREE_LIBRARY;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("André");
        Client client2 = new Client("Diogo");

        client1.setLibraries();
        client2.setLibraries();

        client1.borrowBookByName(BookType.CLEAN_CODE.getName(), FREE_LIBRARY);
        client1.borrowBookByName(BookType.CLEAN_CODE.getName(), FREE_LIBRARY);
        client1.returnBookByName(BookType.CLEAN_CODE.getName(), FREE_LIBRARY);
        client1.borrowBookByName(BookType.CLEAN_CODE.getName(), FREE_LIBRARY);
        client1.borrowBookByAuthor(client1.chooseBook().getAuthor(), FREE_LIBRARY);
        client1.returnBookByAuthor(BookType.CLEAN_CODE.getAuthor(), FREE_LIBRARY);
        client1.madeDonation();
        client1.borrowBookByName(BookType.THE_CHECKLIST_MANIFESTO.getName(), DONATION_LIBRARY);
        client1.borrowBookByAuthor(BookType.THE_CHECKLIST_MANIFESTO.getAuthor(), DONATION_LIBRARY);
        client1.returnBookByAuthor(BookType.THE_CHECKLIST_MANIFESTO.getAuthor(), DONATION_LIBRARY);
        client1.borrowBookByAuthor(BookType.THE_CHECKLIST_MANIFESTO.getAuthor(), DONATION_LIBRARY);

        client2.borrowBookByAuthor(BookType.THE_CHECKLIST_MANIFESTO.getAuthor(), DONATION_LIBRARY);

        client1.borrowBookByName("null", FREE_LIBRARY);
        client2.borrowBookByAuthor("null", FREE_LIBRARY);

        client1.borrowBookByName("null", DONATION_LIBRARY);
        client2.madeDonation();
        client2.borrowBookByAuthor("null", DONATION_LIBRARY);
    }
}
