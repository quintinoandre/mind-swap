package academy.mindswap;

public class Main {
    public static void main(String[] args) {
        ATM atm = CentralBank.createATM();

        ATM[] atms = {atm};

        Bank bank = CentralBank.createBank("ActivoBank", atms);

        Client client = new Client("andre", 123);

        client.addBank(bank);

        client.createDebitAccount("ActivoBank");

        DebitCard debitCard1 = client.askForDebitCard("ActivoBank");
        DebitCard debitCard2 = client.askForDebitCard("ActivoBank");

        client.createCreditAccount("ActivoBank");

        CreditCard creditCard1 = client.askForCreditCard("ActivoBank");
        CreditCard creditCard2 = client.askForCreditCard("ActivoBank");

        client.payWithDebitCard(10, "ActivoBank", atm);

        client.depositWithDebitCard(20, "ActivoBank", atm);

        client.payWithDebitCard(10, "ActivoBank", atm);

        client.depositWithCreditCard(10, "ActivoBank", atm);

        client.payWithCreditCard(100, "ActivoBank", atm);

        client.makeWithraw(10, "ActivoBank", debitCard1, atm);
    }
}
