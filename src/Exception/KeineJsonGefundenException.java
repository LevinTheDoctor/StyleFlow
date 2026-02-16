package Exception;

public class KeineJsonGefundenException extends Exception {
    public KeineJsonGefundenException(String filename) {
        super("Die Datei '" + filename + ".json' existiert nicht.");
    }
}
