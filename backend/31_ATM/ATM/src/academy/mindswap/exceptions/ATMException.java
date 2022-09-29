package academy.mindswap.exceptions;

public abstract class ATMException extends Exception {
    protected ATMException(String message) {
        super(message);
    }
}
