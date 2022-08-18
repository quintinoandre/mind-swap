package academy.mindswap.factory;

import academy.mindswap.libraries.DonationLibrary;
import academy.mindswap.libraries.FreeLibrary;
import academy.mindswap.libraries.Library;
import academy.mindswap.libraries.LibraryType;

public final class LibraryFactory {
    private LibraryFactory() {
    }

    public static Library create(LibraryType type) {
        switch (type) {
            case DONATION_LIBRARY:
                return new DonationLibrary();
            default:
                return new FreeLibrary();
        }
    }
}
