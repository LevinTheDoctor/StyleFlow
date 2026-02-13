package Exception;

public class KeineJsonGefunden extends RuntimeException {
    public KeineJsonGefunden(String message) {
        super(message);
    }
}
