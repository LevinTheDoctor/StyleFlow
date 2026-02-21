package Outfit;

import KleidungsKlassen.*;
import static KleidungsKlassen.KleidungsHelper.*;

public class Outfit {
    private Kopfbedeckung kopfbedeckung;
    private Oberteil oberteil;
    private Unterteil unterteil;
    private Schuhe schuhe;
    private Einteiler einteiler;
    private final int id;
    private static int gesamtAnzahl;

    public Outfit(Schuhe schuhe, Unterteil unterteil, Oberteil oberteil, Kopfbedeckung kopfbedeckung) {
        this.schuhe = schuhe;
        this.unterteil = unterteil;
        this.oberteil = oberteil;
        this.kopfbedeckung = kopfbedeckung;
        gesamtAnzahl += 1;
        id = getGesamtAnzahl();
    }

    public Outfit(Einteiler einteiler, Schuhe schuhe) {
        this.einteiler = einteiler;
        this.schuhe = schuhe;
        gesamtAnzahl += 1;
        id = getGesamtAnzahl();
    }

    public Outfit(String [] JSONString,KleidungsContainer kleidungsContainer){
        this.id = Integer.parseInt(JSONString[0]);
        int i = 1;
        if (Integer.parseInt(JSONString[1]) != 0){
            this.kopfbedeckung = GetKopfbedeckungByID(Integer.parseInt(JSONString[1]),kleidungsContainer.getKopfbedeckungen());
        }
        if(JSONString.length == 5){
            this.oberteil = GetOberteilByID(Integer.parseInt(JSONString[2]),kleidungsContainer.getOberteile());
            this.unterteil = GetUnterteilByID(Integer.parseInt(JSONString[3]),kleidungsContainer.getUnterteile());
            this.schuhe = GetSchuheByID(Integer.parseInt(JSONString[4]),kleidungsContainer.getSchuhe());
        }else
        {
            this.einteiler = GetEinteilerByID(Integer.parseInt(JSONString[2]),kleidungsContainer.getEinteiler());
            this.schuhe = GetSchuheByID(Integer.parseInt(JSONString[3]),kleidungsContainer.getSchuhe());

        }
        gesamtAnzahl += 1;

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

    public Einteiler getEinteiler() {
        return einteiler;
    }

    public void setEinteiler(Einteiler einteiler) {
        this.einteiler = einteiler;
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
