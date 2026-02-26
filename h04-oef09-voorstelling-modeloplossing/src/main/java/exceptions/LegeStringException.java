package exceptions;

public class LegeStringException extends Exception {
    public LegeStringException() {
        this("Alles moet ingevuld zijn");
    }

    public LegeStringException(String message) {
        super(message);
    }
}