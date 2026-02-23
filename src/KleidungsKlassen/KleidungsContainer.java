package KleidungsKlassen;

import java.util.ArrayList;

/**
 * Container-Klasse zum Speichern aller Kleidungsstück-Listen.
 * Wird vom JSON Reader verwendet, um alle Daten in einer Funktion zurückzugeben.
 */
public class KleidungsContainer {
    
    // Basis
    private ArrayList<Kleidungsstueck> kleidungsstuecke;
    
    // Alle Kopfbedeckungen
    private ArrayList<Kopfbedeckung> kopfbedeckungen;
    private ArrayList<Muetze> muetzen;
    private ArrayList<Hut> huete;
    private ArrayList<Cap> caps;
    
    // Alle Unterteile
    private ArrayList<Unterteil> unterteile;
    private ArrayList<Hose> hosen;
    private ArrayList<Rock> roecke;
    
    // Alle Einteiler
    private ArrayList<Einteiler> einteiler;
    private ArrayList<Kleid> kleider;
    private ArrayList<Overall> overalls;
    
    // Alle Schuhe
    private ArrayList<Schuhe> schuhe;
    private ArrayList<HighHeels> highHeels;
    private ArrayList<Sneaker> sneakers;
    private ArrayList<Stiefel> stiefel;
    private ArrayList<Sandalen> sandalen;
    private ArrayList<Halbschuhe> halbschuhe;
    
    // Alle Oberteile
    private ArrayList<Oberteil> oberteile;
    private ArrayList<Hemd> hemden;
    private ArrayList<Polo> polos;
    private ArrayList<Pullover> pullover;
    private ArrayList<Hoodie> hoodies;
    private ArrayList<TShirt> tshirts;
    private ArrayList<Top> tops;
    
    // Alle Jacken
    private ArrayList<Jacke> jacken;
    private ArrayList<Mantel> maentel;
    private ArrayList<WinterJacke> winterJacken;
    private ArrayList<RegenJacke> regenJacken;
    private ArrayList<SweatshirtJacke> sweatshirtJacken;
    private ArrayList<UebergangsJacke> uebergangsJacken;

    /** Standard-Konstruktor für leere Container (z.B. beim Hinzufügen einzelner Kleidungsstücke). */
    public KleidungsContainer() {
        this.kleidungsstuecke = new ArrayList<>();
        this.kopfbedeckungen = new ArrayList<>();
        this.muetzen = new ArrayList<>();
        this.huete = new ArrayList<>();
        this.caps = new ArrayList<>();
        this.unterteile = new ArrayList<>();
        this.hosen = new ArrayList<>();
        this.roecke = new ArrayList<>();
        this.einteiler = new ArrayList<>();
        this.kleider = new ArrayList<>();
        this.overalls = new ArrayList<>();
        this.schuhe = new ArrayList<>();
        this.highHeels = new ArrayList<>();
        this.sneakers = new ArrayList<>();
        this.stiefel = new ArrayList<>();
        this.sandalen = new ArrayList<>();
        this.halbschuhe = new ArrayList<>();
        this.oberteile = new ArrayList<>();
        this.hemden = new ArrayList<>();
        this.polos = new ArrayList<>();
        this.pullover = new ArrayList<>();
        this.hoodies = new ArrayList<>();
        this.tshirts = new ArrayList<>();
        this.tops = new ArrayList<>();
        this.jacken = new ArrayList<>();
        this.maentel = new ArrayList<>();
        this.winterJacken = new ArrayList<>();
        this.regenJacken = new ArrayList<>();
        this.sweatshirtJacken = new ArrayList<>();
        this.uebergangsJacken = new ArrayList<>();
    }

    public KleidungsContainer(ArrayList<Kleidungsstueck> kleidungsstuecke, 
                             ArrayList<Kopfbedeckung> kopfbedeckungen, 
                             ArrayList<Muetze> muetzen, 
                             ArrayList<Hut> huete, 
                             ArrayList<Cap> caps, 
                             ArrayList<Unterteil> unterteile, 
                             ArrayList<Hose> hosen, 
                             ArrayList<Rock> roecke, 
                             ArrayList<Einteiler> einteiler, 
                             ArrayList<Kleid> kleider, 
                             ArrayList<Overall> overalls, 
                             ArrayList<Schuhe> schuhe, 
                             ArrayList<HighHeels> highHeels, 
                             ArrayList<Sneaker> sneakers, 
                             ArrayList<Stiefel> stiefel, 
                             ArrayList<Sandalen> sandalen, 
                             ArrayList<Halbschuhe> halbschuhe, 
                             ArrayList<Oberteil> oberteile, 
                             ArrayList<Hemd> hemden, 
                             ArrayList<Polo> polos, 
                             ArrayList<Pullover> pullover, 
                             ArrayList<Hoodie> hoodies, 
                             ArrayList<TShirt> tshirts, 
                             ArrayList<Top> tops, 
                             ArrayList<Jacke> jacken, 
                             ArrayList<Mantel> maentel, 
                             ArrayList<WinterJacke> winterJacken, 
                             ArrayList<RegenJacke> regenJacken, 
                             ArrayList<SweatshirtJacke> sweatshirtJacken, 
                             ArrayList<UebergangsJacke> uebergangsJacken) {
        this.kleidungsstuecke = kleidungsstuecke;
        this.kopfbedeckungen = kopfbedeckungen;
        this.muetzen = muetzen;
        this.huete = huete;
        this.caps = caps;
        this.unterteile = unterteile;
        this.hosen = hosen;
        this.roecke = roecke;
        this.einteiler = einteiler;
        this.kleider = kleider;
        this.overalls = overalls;
        this.schuhe = schuhe;
        this.highHeels = highHeels;
        this.sneakers = sneakers;
        this.stiefel = stiefel;
        this.sandalen = sandalen;
        this.halbschuhe = halbschuhe;
        this.oberteile = oberteile;
        this.hemden = hemden;
        this.polos = polos;
        this.pullover = pullover;
        this.hoodies = hoodies;
        this.tshirts = tshirts;
        this.tops = tops;
        this.jacken = jacken;
        this.maentel = maentel;
        this.winterJacken = winterJacken;
        this.regenJacken = regenJacken;
        this.sweatshirtJacken = sweatshirtJacken;
        this.uebergangsJacken = uebergangsJacken;
    }

    // Getter und Setter
    public ArrayList<Kleidungsstueck> getKleidungsstuecke() {
        return kleidungsstuecke;
    }

    public void setKleidungsstuecke(ArrayList<Kleidungsstueck> kleidungsstuecke) {
        this.kleidungsstuecke = kleidungsstuecke;
    }

    public ArrayList<Kopfbedeckung> getKopfbedeckungen() {
        return kopfbedeckungen;
    }

    public void setKopfbedeckungen(ArrayList<Kopfbedeckung> kopfbedeckungen) {
        this.kopfbedeckungen = kopfbedeckungen;
    }

    public ArrayList<Muetze> getMuetzen() {
        return muetzen;
    }

    public void setMuetzen(ArrayList<Muetze> muetzen) {
        this.muetzen = muetzen;
    }

    public ArrayList<Hut> getHuete() {
        return huete;
    }

    public void setHuete(ArrayList<Hut> huete) {
        this.huete = huete;
    }

    public ArrayList<Cap> getCaps() {
        return caps;
    }

    public void setCaps(ArrayList<Cap> caps) {
        this.caps = caps;
    }

    public ArrayList<Unterteil> getUnterteile() {
        return unterteile;
    }

    public void setUnterteile(ArrayList<Unterteil> unterteile) {
        this.unterteile = unterteile;
    }

    public ArrayList<Hose> getHosen() {
        return hosen;
    }

    public void setHosen(ArrayList<Hose> hosen) {
        this.hosen = hosen;
    }

    public ArrayList<Rock> getRoecke() {
        return roecke;
    }

    public void setRoecke(ArrayList<Rock> roecke) {
        this.roecke = roecke;
    }

    public ArrayList<Einteiler> getEinteiler() {
        return einteiler;
    }

    public void setEinteiler(ArrayList<Einteiler> einteiler) {
        this.einteiler = einteiler;
    }

    public ArrayList<Kleid> getKleider() {
        return kleider;
    }

    public void setKleider(ArrayList<Kleid> kleider) {
        this.kleider = kleider;
    }

    public ArrayList<Overall> getOveralls() {
        return overalls;
    }

    public void setOveralls(ArrayList<Overall> overalls) {
        this.overalls = overalls;
    }

    public ArrayList<Schuhe> getSchuhe() {
        return schuhe;
    }

    public void setSchuhe(ArrayList<Schuhe> schuhe) {
        this.schuhe = schuhe;
    }

    public ArrayList<HighHeels> getHighHeels() {
        return highHeels;
    }

    public void setHighHeels(ArrayList<HighHeels> highHeels) {
        this.highHeels = highHeels;
    }

    public ArrayList<Sneaker> getSneakers() {
        return sneakers;
    }

    public void setSneakers(ArrayList<Sneaker> sneakers) {
        this.sneakers = sneakers;
    }

    public ArrayList<Stiefel> getStiefel() {
        return stiefel;
    }

    public void setStiefel(ArrayList<Stiefel> stiefel) {
        this.stiefel = stiefel;
    }

    public ArrayList<Sandalen> getSandalen() {
        return sandalen;
    }

    public void setSandalen(ArrayList<Sandalen> sandalen) {
        this.sandalen = sandalen;
    }

    public ArrayList<Halbschuhe> getHalbschuhe() {
        return halbschuhe;
    }

    public void setHalbschuhe(ArrayList<Halbschuhe> halbschuhe) {
        this.halbschuhe = halbschuhe;
    }

    public ArrayList<Oberteil> getOberteile() {
        return oberteile;
    }

    public void setOberteile(ArrayList<Oberteil> oberteile) {
        this.oberteile = oberteile;
    }

    public ArrayList<Hemd> getHemden() {
        return hemden;
    }

    public void setHemden(ArrayList<Hemd> hemden) {
        this.hemden = hemden;
    }

    public ArrayList<Polo> getPolos() {
        return polos;
    }

    public void setPolos(ArrayList<Polo> polos) {
        this.polos = polos;
    }

    public ArrayList<Pullover> getPullover() {
        return pullover;
    }

    public void setPullover(ArrayList<Pullover> pullover) {
        this.pullover = pullover;
    }

    public ArrayList<Hoodie> getHoodies() {
        return hoodies;
    }

    public void setHoodies(ArrayList<Hoodie> hoodies) {
        this.hoodies = hoodies;
    }

    public ArrayList<TShirt> getTshirts() {
        return tshirts;
    }

    public void setTshirts(ArrayList<TShirt> tshirts) {
        this.tshirts = tshirts;
    }

    public ArrayList<Top> getTops() {
        return tops;
    }

    public void setTops(ArrayList<Top> tops) {
        this.tops = tops;
    }

    public ArrayList<Jacke> getJacken() {
        return jacken;
    }

    public void setJacken(ArrayList<Jacke> jacken) {
        this.jacken = jacken;
    }

    public ArrayList<Mantel> getMaentel() {
        return maentel;
    }

    public void setMaentel(ArrayList<Mantel> maentel) {
        this.maentel = maentel;
    }

    public ArrayList<WinterJacke> getWinterJacken() {
        return winterJacken;
    }

    public void setWinterJacken(ArrayList<WinterJacke> winterJacken) {
        this.winterJacken = winterJacken;
    }

    public ArrayList<RegenJacke> getRegenJacken() {
        return regenJacken;
    }

    public void setRegenJacken(ArrayList<RegenJacke> regenJacken) {
        this.regenJacken = regenJacken;
    }

    public ArrayList<SweatshirtJacke> getSweatshirtJacken() {
        return sweatshirtJacken;
    }

    public void setSweatshirtJacken(ArrayList<SweatshirtJacke> sweatshirtJacken) {
        this.sweatshirtJacken = sweatshirtJacken;
    }

    public ArrayList<UebergangsJacke> getUebergangsJacken() {
        return uebergangsJacken;
    }

    public void setUebergangsJacken(ArrayList<UebergangsJacke> uebergangsJacken) {
        this.uebergangsJacken = uebergangsJacken;
    }
}