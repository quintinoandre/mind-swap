package academy.mindswap;

public abstract class CentralBank {
    public static ATM createATM() {
        return new ATM();
    }

    public static Bank createBank(String name, ATM[] atms) {
        Bank bank = new Bank(name);

        for (ATM atm : atms) {
            atm.addBank(bank);
        }

        return bank;
    }
}
