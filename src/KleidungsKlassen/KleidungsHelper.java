package KleidungsKlassen;

import java.util.ArrayList;

public class KleidungsHelper {
    public static Oberteil GetOberteilByID(int ID, ArrayList<Oberteil> oberteile){
        Oberteil Gefunden = null;
        for (Oberteil o : oberteile){
            if(o.getKleidungsID() == ID){
                Gefunden = o;
                break;
            }
        }
        return Gefunden;
    }

    public static Unterteil GetUnterteilByID(int ID, ArrayList<Unterteil> Unterteile){
        Unterteil Gefunden = null;
        for (Unterteil u : Unterteile){
            if(u.getKleidungsID() == ID){
                Gefunden = u;
                break;
            }
        }
        return Gefunden;
    }

    public static Schuhe GetSchuheByID(int ID, ArrayList<Schuhe> Schuhe){
        Schuhe Gefunden = null;
        for (Schuhe s : Schuhe){
            if(s.getKleidungsID() == ID){
                Gefunden = s;
                break;
            }
        }
        return Gefunden;
    }

    public static Kopfbedeckung GetKopfbedeckungByID(int ID, ArrayList<Kopfbedeckung> kopfbedeckungs){
        Kopfbedeckung Gefunden = null;
        for ( Kopfbedeckung k : kopfbedeckungs){
            if(k.getKleidungsID() == ID){
                Gefunden = k;
                break;
            }
        }
        return Gefunden;
    }

    public static Einteiler GetEinteilerByID(int ID, ArrayList< Einteiler> Einteiler){
        Einteiler Gefunden = null;
        for ( Einteiler E : Einteiler){
            if(E.getKleidungsID() == ID){
                Gefunden = E;
                break;
            }
        }
        return Gefunden;
    }

    public static ArrayList<String> GetMarken(ArrayList<Kleidungsstueck> Kleidungstuecke){
        ArrayList<String> Marken = new ArrayList<>();
        for (Kleidungsstueck k : Kleidungstuecke){
            Marken.add(k.getMarke());
        }
        return Marken;
    }
}
