package Nutzer;

import java.util.ArrayList;
import java.util.Arrays;

public class Nutzer implements INutzer {
    private String nutzername;
    private String pfadZumBild;
    private ArrayList<String> LeiblingsFarbe;
    private String Standort;
    private static int NutzerAnzahl;
    private final int NutzerID;


    public Nutzer(String nutzername, String pfadZumBild, String[] leiblingsFarbe, String standort) {
        this.nutzername = nutzername;
        this.pfadZumBild = pfadZumBild;
        LeiblingsFarbe = new ArrayList<>(Arrays.asList(leiblingsFarbe));
        Standort = standort;
        NutzerAnzahl += 1;
        NutzerID = NutzerAnzahl;
    }

    public Nutzer(String[] NutzerStringArray){
        this.NutzerID = Integer.parseInt(NutzerStringArray[0]);
        this.nutzername = NutzerStringArray[1];
        this.pfadZumBild = NutzerStringArray[2];
        this.Standort = NutzerStringArray[3];
        this.LeiblingsFarbe = new ArrayList<>(Arrays.asList(NutzerStringArray[4].split(",")));;
        NutzerAnzahl += 1;
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
    // Leiblingsfarbe wird durch Interface hinzugefügt
    @Override
    public void addLeiblingsFarbe(String Farbe){
        LeiblingsFarbe.add(Farbe);
    }

    @Override
    public void removeLeiblingsFarbe(String Farbe){
        LeiblingsFarbe.remove(Farbe);
    }

    public ArrayList<String> getLeiblingsFarbe() {
        return LeiblingsFarbe;
    }

    public void setLeiblingsFarbe(ArrayList<String> leiblingsFarbe) {
        LeiblingsFarbe = leiblingsFarbe;
    }

    @Override
    public void addStandort(String standort) {
        setStandort(standort);
    }
    @Override
    public void removeStandort(String standort) {
        // Durch null setzen wird die Variable wieder leer vorher wollte ich das mit "" machen aber das war dumm
        setStandort(null);
    }

    public String getStandort() {
        return Standort;
    }

    public void setStandort(String standort) {
        Standort = standort;
    }
}
