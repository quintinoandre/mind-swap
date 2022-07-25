package academy.mindswap;


import academy.mindswap.exceptions.NotCardCreatedException;
import academy.mindswap.exceptions.NotCardInsertedException;
import academy.mindswap.exceptions.NotEnoughFundsException;
import academy.mindswap.exceptions.NotEnoughPermissionsException;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();

        atm.createCard();

        try {
            atm.withdraw(10);
        } catch (NotCardCreatedException | NotCardInsertedException | NotEnoughFundsException error) {
            System.out.println(error.getMessage());
        }

        try {
            atm.insertCard(0000);
        } catch (NotCardCreatedException | NotEnoughPermissionsException error) {
            System.out.println(error.getMessage());
        }

        try {
            atm.insertCard(1234);
        } catch (NotCardCreatedException | NotEnoughPermissionsException error) {
            System.out.println(error.getMessage());
        }

        try {
            atm.withdraw(110);
        } catch (NotCardCreatedException | NotCardInsertedException | NotEnoughFundsException error) {
            System.out.println(error.getMessage());
        }

        try {
            atm.deposit(10);
        } catch (NotCardCreatedException | NotCardInsertedException error) {
            System.out.println(error.getMessage());
        }

        try {
            atm.withdraw(110);
        } catch (NotCardCreatedException | NotCardInsertedException | NotEnoughFundsException error) {
            System.out.println(error.getMessage());
        }
    }
}
