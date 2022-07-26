package academy.mindswap.libraries;

import academy.mindswap.exceptions.NotDonationException;
import academy.mindswap.exceptions.NotEnoughStockException;
import academy.mindswap.exceptions.NotExistingBookException;

import java.util.ArrayList;
import java.util.UUID;

public class DonationLibrary extends Library {
    private ArrayList<UUID> donationClients = new ArrayList<>();

    @Override
    public void borrowBookByName(String name, UUID clientId) throws NotEnoughStockException, NotDonationException,
            NotExistingBookException {
        if (!donationClients.contains(clientId)) {
            throw new NotDonationException();
        }

        super.borrowBookByName(name, clientId);
    }

    @Override
    public void borrowBookByAuthor(String author, UUID clientId) throws NotDonationException, NotEnoughStockException,
            NotExistingBookException {
        if (!donationClients.contains(clientId)) {
            throw new NotDonationException();
        }

        super.borrowBookByAuthor(author, clientId);
    }

    public void madeDonation(UUID clientId) {
        donationClients.add(clientId);
    }
}
