package KleidungsKlassen;

import java.util.ArrayList;

public abstract class Einteiler extends Kleidungsstueck{
    private String AuschnitArt;
    private String Weite;
    private int Laenge;
    private boolean HatAermel;

    public Einteiler(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String bildDateiPfad, String auschnitArt, String weite, int laenge, boolean hatAermel) {
        super(name, farbe, groesse, material, marke, anlass, wetter, bildDateiPfad);
        AuschnitArt = auschnitArt;
        Weite = weite;
        Laenge = laenge;
        HatAermel = hatAermel;
    }

    public Einteiler(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String bildDateiPfad, int kleidungsID, String auschnitArt, String weite, int laenge, boolean hatAermel) {
        super(name, farbe, groesse, material, marke, anlass, wetter, bildDateiPfad, kleidungsID);
        AuschnitArt = auschnitArt;
        Weite = weite;
        Laenge = laenge;
        HatAermel = hatAermel;
    }

    public Einteiler(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String bildDateiPfad, String auschnitArt,int laenge, boolean hatAermel) {
        super(name, farbe, groesse, material, marke, anlass, wetter, bildDateiPfad);
        AuschnitArt = auschnitArt;
        Laenge = laenge;
        HatAermel = hatAermel;
    }

    public Einteiler(String name, String[] farbe, String groesse, String[] material, String marke, String anlass, String wetter, String bildDateiPfad, int kleidungsID, String auschnitArt,int laenge, boolean hatAermel) {
        super(name, farbe, groesse, material, marke, anlass, wetter, bildDateiPfad, kleidungsID);
        AuschnitArt = auschnitArt;
        Laenge = laenge;
        HatAermel = hatAermel;
    }

    public String getAuschnitArt() {
        return AuschnitArt;
    }

    public void setAuschnitArt(String auschnitArt) {
        AuschnitArt = auschnitArt;
    }

    public String getWeite() {
        return Weite;
    }

    public void setWeite(String weite) {
        Weite = weite;
    }

    public int getLaenge() {
        return Laenge;
    }

    public void setLaenge(int laenge) {
        Laenge = laenge;
    }

    public boolean isHatAermel() {
        return HatAermel;
    }

    public void setHatAermel(boolean hatAermel) {
        HatAermel = hatAermel;
    }
}
