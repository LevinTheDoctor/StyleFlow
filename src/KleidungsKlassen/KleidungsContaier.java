package KleidungsKlassen;
import java.util.ArrayList;
// Klasse ist nur zum Returen der anderen kallsen von den JSON Reader so kann man in eine funktion alle daten returnen
public class KleidungsContaier {
    private ArrayList<Kleidungsstueck> kleidungsstuecks;
    // Alle kopfbedckunegn
    private ArrayList<Kopfbedeckung> kopfbedeckungs;
    private ArrayList<Muetze> muetze;
    private ArrayList<Hut> huts;
    private ArrayList<Cappe> Caps;
    // Alle Untertele
    private ArrayList<Unterteil>  unterteils;
    private ArrayList<Hose> hoses;
    private ArrayList<Rock> rocks;
    // Alle einteiler
    private ArrayList<Einteiler>  einteilers;
    private ArrayList<Kleid>  kleids;
    private ArrayList<Overall>  overalls;
    private ArrayList<Anzug> anzugs;
    // Alle Schuhe
    private ArrayList<Schuhe> schuhe;
    private ArrayList<HighHeel> highHeels;
    private ArrayList<Sneaker> sneakers;
    private ArrayList<Stiefel> stiefels;
    private ArrayList<Sandalen> sandalens;
    private ArrayList<Halbschuhe> halbschuhes;
    // Alle Obereteile
    private ArrayList<Oberteil> oberteils;
    private ArrayList<Hemd> hemds;
    private  ArrayList<Polo> polos;
    private ArrayList<Pullover> pullovers;
    private ArrayList<Hoodie> hoodies;
    private ArrayList<TShirt> tshirts;
    private ArrayList<Top>  tops;
    // Jacken gesamt Jacker erbt zwar von oberteil aber ist trozdem abstract
    private ArrayList<Jacke> jackes;
    private ArrayList<Mantel> mantels;
    private ArrayList<WinterJacke> winterJackes;
    private ArrayList<RegenJacke> regenJackes;
    private ArrayList<SweatshirtJacke> sweatshirtJackes;
    private ArrayList<UebergangsJacke> uebergangsJackes;

    public KleidungsContaier(ArrayList<Kleidungsstueck> kleidungsstuecks, ArrayList<Kopfbedeckung> kopfbedeckungs, ArrayList<Muetze> muetze, ArrayList<Hut> huts, ArrayList<Cappe> caps, ArrayList<Unterteil> unterteils, ArrayList<Hose> hoses, ArrayList<Rock> rocks, ArrayList<Einteiler> einteilers, ArrayList<Kleid> kleids, ArrayList<Overall> overalls, ArrayList<Anzug> anzugs, ArrayList<Schuhe> schuhe, ArrayList<HighHeel> highHeels, ArrayList<Sneaker> sneakers, ArrayList<Stiefel> stiefels, ArrayList<Sandalen> sandalens, ArrayList<Halbschuhe> halbschuhes, ArrayList<Oberteil> oberteils, ArrayList<Hemd> hemds, ArrayList<Polo> polos, ArrayList<Pullover> pullovers, ArrayList<Hoodie> hoodies, ArrayList<TShirt> tshirts, ArrayList<Top> tops, ArrayList<Jacke> jackes, ArrayList<Mantel> mantels, ArrayList<WinterJacke> winterJackes, ArrayList<RegenJacke> regenJackes, ArrayList<SweatshirtJacke> sweatshirtJackes, ArrayList<UebergangsJacke> uebergangsJackes) {
        this.kleidungsstuecks = kleidungsstuecks;
        this.kopfbedeckungs = kopfbedeckungs;
        this.muetze = muetze;
        this.huts = huts;
        Caps = caps;
        this.unterteils = unterteils;
        this.hoses = hoses;
        this.rocks = rocks;
        this.einteilers = einteilers;
        this.kleids = kleids;
        this.overalls = overalls;
        this.anzugs = anzugs;
        this.schuhe = schuhe;
        this.highHeels = highHeels;
        this.sneakers = sneakers;
        this.stiefels = stiefels;
        this.sandalens = sandalens;
        this.halbschuhes = halbschuhes;
        this.oberteils = oberteils;
        this.hemds = hemds;
        this.polos = polos;
        this.pullovers = pullovers;
        this.hoodies = hoodies;
        this.tshirts = tshirts;
        this.tops = tops;
        this.jackes = jackes;
        this.mantels = mantels;
        this.winterJackes = winterJackes;
        this.regenJackes = regenJackes;
        this.sweatshirtJackes = sweatshirtJackes;
        this.uebergangsJackes = uebergangsJackes;
    }

    public ArrayList<Kleidungsstueck> getKleidungsstuecks() {
        return kleidungsstuecks;
    }

    public void setKleidungsstuecks(ArrayList<Kleidungsstueck> kleidungsstuecks) {
        this.kleidungsstuecks = kleidungsstuecks;
    }

    public ArrayList<Kopfbedeckung> getKopfbedeckungs() {
        return kopfbedeckungs;
    }

    public void setKopfbedeckungs(ArrayList<Kopfbedeckung> kopfbedeckungs) {
        this.kopfbedeckungs = kopfbedeckungs;
    }

    public ArrayList<Muetze> getMuetze() {
        return muetze;
    }

    public void setMuetze(ArrayList<Muetze> muetze) {
        this.muetze = muetze;
    }

    public ArrayList<Hut> getHuts() {
        return huts;
    }

    public void setHuts(ArrayList<Hut> huts) {
        this.huts = huts;
    }

    public ArrayList<Cappe> getCaps() {
        return Caps;
    }

    public void setCaps(ArrayList<Cappe> caps) {
        Caps = caps;
    }

    public ArrayList<Unterteil> getUnterteils() {
        return unterteils;
    }

    public void setUnterteils(ArrayList<Unterteil> unterteils) {
        this.unterteils = unterteils;
    }

    public ArrayList<Hose> getHoses() {
        return hoses;
    }

    public void setHoses(ArrayList<Hose> hoses) {
        this.hoses = hoses;
    }

    public ArrayList<Rock> getRocks() {
        return rocks;
    }

    public void setRocks(ArrayList<Rock> rocks) {
        this.rocks = rocks;
    }

    public ArrayList<Einteiler> getEinteilers() {
        return einteilers;
    }

    public void setEinteilers(ArrayList<Einteiler> einteilers) {
        this.einteilers = einteilers;
    }

    public ArrayList<Kleid> getKleids() {
        return kleids;
    }

    public void setKleids(ArrayList<Kleid> kleids) {
        this.kleids = kleids;
    }

    public ArrayList<Overall> getOveralls() {
        return overalls;
    }

    public void setOveralls(ArrayList<Overall> overalls) {
        this.overalls = overalls;
    }

    public ArrayList<Anzug> getAnzugs() {
        return anzugs;
    }

    public void setAnzugs(ArrayList<Anzug> anzugs) {
        this.anzugs = anzugs;
    }

    public ArrayList<Schuhe> getSchuhe() {
        return schuhe;
    }

    public void setSchuhe(ArrayList<Schuhe> schuhe) {
        this.schuhe = schuhe;
    }

    public ArrayList<HighHeel> getHighHeels() {
        return highHeels;
    }

    public void setHighHeels(ArrayList<HighHeel> highHeels) {
        this.highHeels = highHeels;
    }

    public ArrayList<Sneaker> getSneakers() {
        return sneakers;
    }

    public void setSneakers(ArrayList<Sneaker> sneakers) {
        this.sneakers = sneakers;
    }

    public ArrayList<Stiefel> getStiefels() {
        return stiefels;
    }

    public void setStiefels(ArrayList<Stiefel> stiefels) {
        this.stiefels = stiefels;
    }

    public ArrayList<Sandalen> getSandalens() {
        return sandalens;
    }

    public void setSandalens(ArrayList<Sandalen> sandalens) {
        this.sandalens = sandalens;
    }

    public ArrayList<Halbschuhe> getHalbschuhes() {
        return halbschuhes;
    }

    public void setHalbschuhes(ArrayList<Halbschuhe> halbschuhes) {
        this.halbschuhes = halbschuhes;
    }

    public ArrayList<Oberteil> getOberteils() {
        return oberteils;
    }

    public void setOberteils(ArrayList<Oberteil> oberteils) {
        this.oberteils = oberteils;
    }

    public ArrayList<Hemd> getHemds() {
        return hemds;
    }

    public void setHemds(ArrayList<Hemd> hemds) {
        this.hemds = hemds;
    }

    public ArrayList<Polo> getPolos() {
        return polos;
    }

    public void setPolos(ArrayList<Polo> polos) {
        this.polos = polos;
    }

    public ArrayList<Pullover> getPullovers() {
        return pullovers;
    }

    public void setPullovers(ArrayList<Pullover> pullovers) {
        this.pullovers = pullovers;
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

    public ArrayList<Jacke> getJackes() {
        return jackes;
    }

    public void setJackes(ArrayList<Jacke> jackes) {
        this.jackes = jackes;
    }

    public ArrayList<Mantel> getMantels() {
        return mantels;
    }

    public void setMantels(ArrayList<Mantel> mantels) {
        this.mantels = mantels;
    }

    public ArrayList<WinterJacke> getWinterJackes() {
        return winterJackes;
    }

    public void setWinterJackes(ArrayList<WinterJacke> winterJackes) {
        this.winterJackes = winterJackes;
    }

    public ArrayList<RegenJacke> getRegenJackes() {
        return regenJackes;
    }

    public void setRegenJackes(ArrayList<RegenJacke> regenJackes) {
        this.regenJackes = regenJackes;
    }

    public ArrayList<SweatshirtJacke> getSweatshirtJackes() {
        return sweatshirtJackes;
    }

    public void setSweatshirtJackes(ArrayList<SweatshirtJacke> sweatshirtJackes) {
        this.sweatshirtJackes = sweatshirtJackes;
    }

    public ArrayList<UebergangsJacke> getUebergangsJackes() {
        return uebergangsJackes;
    }

    public void setUebergangsJackes(ArrayList<UebergangsJacke> uebergangsJackes) {
        this.uebergangsJackes = uebergangsJackes;
    }
}
