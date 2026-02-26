package exceptions;

public class BestellingException extends Exception {

    public BestellingException() {
        this("Er liep iets mis met de bestelling");
    }

    public BestellingException(String message) {
        super(message);
    }
}