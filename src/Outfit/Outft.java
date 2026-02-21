package Outfit;

import KleidungsKlassen.*;

public class Outft {
    private Kopfbedeckung kopfbedeckung;
    private Oberteil oberteil;
    private Unterteil unterteil;
    private Schuhe schuhe;
    private final int id;
    private static int gesamtAnzahl;

    public Outft(Schuhe schuhe, Unterteil unterteil, Oberteil oberteil, Kopfbedeckung kopfbedeckung) {
        this.schuhe = schuhe;
        this.unterteil = unterteil;
        this.oberteil = oberteil;
        this.kopfbedeckung = kopfbedeckung;
        gesamtAnzahl += 1;
        id = getGesamtAnzahl();
    }

    public static int getGesamtAnzahl() {
        return gesamtAnzahl;
    }

    public int getId() {
        return id;
    }

    public Kopfbedeckung getKopfbedeckung() {
        return kopfbedeckung;
    }

    public void setKopfbedeckung(Kopfbedeckung kopfbedeckung) {
        this.kopfbedeckung = kopfbedeckung;
    }

    public Oberteil getOberteil() {
        return oberteil;
    }

    public void setOberteil(Oberteil oberteil) {
        this.oberteil = oberteil;
    }

    public Unterteil getUnterteil() {
        return unterteil;
    }

    public void setUnterteil(Unterteil unterteil) {
        this.unterteil = unterteil;
    }

    public Schuhe getSchuhe() {
        return schuhe;
    }

    public void setSchuhe(Schuhe schuhe) {
        this.schuhe = schuhe;
    }
}
