package Nutzer;

import java.util.ArrayList;
import java.util.Arrays;

public class Nutzer implements INutzer {
    private String nutzername;
    private String pfadZumBild;
    private ArrayList<String> LieblingsFarbe;
    private String Standort;
    private static int NutzerAnzahl;
    private final int NutzerID;


    public Nutzer(String nutzername, String pfadZumBild, String[] lieblingsFarbe, String standort) {
        this.nutzername = nutzername;
        this.pfadZumBild = pfadZumBild;
        LieblingsFarbe = new ArrayList<>(Arrays.asList(lieblingsFarbe));
        Standort = standort;
        NutzerAnzahl += 1;
        NutzerID = NutzerAnzahl;
    }

    public Nutzer(String[] NutzerStringArray){
        this.NutzerID = Integer.parseInt(NutzerStringArray[0]);
        this.nutzername = NutzerStringArray[1];
        this.pfadZumBild = NutzerStringArray[2];
        this.Standort = NutzerStringArray[3];
        this.LieblingsFarbe = new ArrayList<>(Arrays.asList(NutzerStringArray[4].split(",")));;
        NutzerAnzahl += 1;
    }
    // Konstruktor für Speicher
    public Nutzer() {
        NutzerAnzahl += 1;
        NutzerID = NutzerAnzahl;
    }

    public static void setNutzerAnzahl(int nutzerAnzahl) {
        NutzerAnzahl = nutzerAnzahl;
    }

    public void setNutzername(String nutzername) {
        this.nutzername = nutzername;
    }

    public String getNutzername() {
        return nutzername;
    }

    public static int getNutzerAnzahl() {
        return NutzerAnzahl;
    }

    public int getNutzerID() {
        return NutzerID;
    }

    public String getPfadZumBild() {
        return pfadZumBild;
    }

    public void setPfadZumBild(String pfadZumBild) {
        this.pfadZumBild = pfadZumBild;
    }
    // Lieblingsfarbe wird durch Interface hinzugefügt
    @Override
    public void addLieblingsFarbe(String Farbe){
        LieblingsFarbe.add(Farbe);
    }

    @Override
    public void removeLieblingsFarbe(String Farbe){
        LieblingsFarbe.remove(Farbe);
    }

    public ArrayList<String> getLieblingsFarbe() {
        return LieblingsFarbe;
    }

    public void setLieblingsFarbe(ArrayList<String> lieblingsFarbe) {
        LieblingsFarbe = lieblingsFarbe;
    }

    @Override
    public void addStandort(String standort) {
        setStandort(standort);
    }
    @Override
    public void removeStandort(String standort) {
        // Durch Null setzen wird die Variable wieder leer – vorher wollte ich das mit "" machen, aber auf Weg ist es sauberer
        setStandort(null);
    }

    public String getStandort() {
        return Standort;
    }

    public void setStandort(String standort) {
        Standort = standort;
    }
}
