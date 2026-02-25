package Logik;

import KleidungsKlassen.*;
import Nutzer.Nutzer;
import Outfit.Outfit;
import JSONHandling.JSONWriterKleidungstuecke;
import java.util.ArrayList;

public class ProgramSpeicher {
    private static KleidungsContainer Schrank = new KleidungsContainer();
    private static ArrayList<Outfit> outfitListe = new ArrayList<>();
    private static ArrayList<Nutzer> nutzerList = new ArrayList<>();

    private static Outfit AktivesOutfit;
    private static Nutzer AktiverNutzer;

    public static void AddKleidungsstueckeToOutfit(Kleidungsstueck ks)
    {
        if (ks == null) return;
        if (ks instanceof Kopfbedeckung kb)
        {
            AktivesOutfit.addKopfbeckung(kb);
        } else if (ks instanceof Oberteil ot)
        {
            AktivesOutfit.addOberteil(ot);
        }else if (ks instanceof Unterteil ut)
        {
            AktivesOutfit.addUnterteil(ut);
        } else if (ks instanceof Einteiler et)
        {
            AktivesOutfit.addEinteiler(et);
        } else if (ks instanceof Schuhe s)
        {
            AktivesOutfit.addSchuhe(s);
        }
    }


    public static void AddKleidungsstueckToSchrank(Kleidungsstueck ks) {
        if (ks == null) return;
        Schrank.getKleidungsstuecke().add(ks);
        if (ks instanceof Kopfbedeckung kb)
        {
            Schrank.getKopfbedeckungen().add(kb);
            if (kb instanceof Hut h)
            {
                Schrank.getHuete().add(h);
            }else if (kb instanceof Muetze m)
            {
                Schrank.getMuetzen().add(m);
            }else if (kb instanceof Cap c)
            {
                Schrank.getCaps().add(c);
            }
        }else if (ks instanceof Oberteil ot)
        {
            Schrank.getOberteile().add(ot);
            if  (ot instanceof Hemd h)
            {
                Schrank.getHemden().add(h);
            }else if (ot instanceof Polo p)
            {
                Schrank.getPolos().add(p);
            }else if (ot instanceof Pullover pu)
            {
                Schrank.getPullover().add(pu);
            }else if (ot instanceof Hoodie h){
                Schrank.getHoodies().add(h);
            }else if (ot instanceof TShirt ts)
            {
                Schrank.getTshirts().add(ts);
            }else if (ot instanceof Top t){
                Schrank.getTops().add(t);
            }else if (ot instanceof Jacke j){
                Schrank.getJacken().add(j);
                if (j instanceof Mantel M){
                    Schrank.getMaentel().add(M);
                }else if (j instanceof WinterJacke WJ)
                {
                    Schrank.getWinterJacken().add(WJ);
                }else if (j instanceof RegenJacke RJ)
                {
                    Schrank.getRegenJacken().add(RJ);
                }else if (j instanceof SweatshirtJacke SJ)
                {
                    Schrank.getSweatshirtJacken().add(SJ);
                }else if (j instanceof UebergangsJacke UJ){
                    Schrank.getUebergangsJacken().add(UJ);
                }
            }
        }else if (ks instanceof Unterteil ut)
        {
            Schrank.getUnterteile().add(ut);
            if (ut instanceof Hose Ho)
            {
                Schrank.getHosen().add(Ho);
            }else if(ut instanceof Rock Ro)
            {
                Schrank.getRoecke().add(Ro);
            }
        }else if (ks instanceof Einteiler et)
        {
            Schrank.getEinteiler().add(et);
            if (et instanceof Kleid K){
                Schrank.getKleider().add(K);
            }else if (et instanceof Overall O)
            {
                Schrank.getOveralls().add(O);
            }
        }else if (ks instanceof Schuhe s)
        {
            Schrank.getSchuhe().add(s);
            if (s instanceof HighHeels hi)
            {
                Schrank.getHighHeels().add(hi);
            } else if (s instanceof Sneaker sne)
            {
                Schrank.getSneakers().add(sne);
            } else if (s instanceof Stiefel Stief)
            {
                Schrank.getStiefel().add(Stief);
            } else if (s instanceof Sandalen AlmanLouboutin){
                Schrank.getSandalen().add(AlmanLouboutin);
            } else if (s instanceof Halbschuhe hsch)
            {
                Schrank.getHalbschuhe().add(hsch);
            }
        }
        // Sofort in JSON speichern
        JSONWriterKleidungstuecke.JSONWrite(Schrank);
    }

    public static KleidungsContainer getSchrank() {
        return Schrank;
    }

    public static void setSchrank(KleidungsContainer schrank) {
        Schrank = schrank;
    }

    public static ArrayList<Outfit> getOutfitListe() {
        return outfitListe;
    }

    public static ArrayList<Nutzer> getNutzerList() {
        return nutzerList;
    }

    public static Outfit getAktivesOutfit() {
        return AktivesOutfit;
    }

    public static Nutzer getAktiverNutzer() {
        return AktiverNutzer;
    }
}
