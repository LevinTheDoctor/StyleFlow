package Logik;

import java.util.ArrayList;
import KleidungsKlassen.*;

public class FilterLogik {

    private ArrayList<FilterEintrag> filterListe = new ArrayList<>();

    public void addFilter(String attribut, String wert) {
        filterListe.add(new FilterEintrag(attribut, wert));
    }

    public void removeFilter(String attribut) {
        filterListe.removeIf(f -> f.getAttributBezeichnung().equals(attribut));
    }

    public void clearFilter() {
        filterListe.clear();
    }

    public ArrayList<FilterEintrag> getFilterListe() {
        return filterListe;
    }

    public ArrayList<Kleidungsstueck> anwenden(ArrayList<Kleidungsstueck> kleidungsstuecke) {
        ArrayList<Kleidungsstueck> ergebnis = new ArrayList<>();

        for (Kleidungsstueck k : kleidungsstuecke) {
            boolean filterErfuellt = true;

            for (FilterEintrag filter : filterListe) {
                String attributName = filter.getAttributBezeichnung().toLowerCase();
                String wertVomFilter = filter.getAttributWert();

                // Prüfe ob es ein Array-Attribut ist (farben, material, style)
                if (attributName.equals("farben") || attributName.equals("material") || attributName.equals("style")) {
                    String[] array = getArrayAttributWert(k, attributName);
                    if (!arrayEnthaeltWert(array, wertVomFilter)) {
                        filterErfuellt = false;
                        break;
                    }
                } else {
                    String wertVomKleidungsstueck = getAttributWert(k, attributName);
                    if (wertVomKleidungsstueck == null || !wertVomKleidungsstueck.equalsIgnoreCase(wertVomFilter)) {
                        filterErfuellt = false;
                        break;
                    }
                }
            }

            if (filterErfuellt) {
                ergebnis.add(k);
            }
        }

        return ergebnis;
    }

    private String[] getArrayAttributWert(Kleidungsstueck k, String attributName) {
        switch (attributName) {
            case "farben":
                return k.getFarben();
            case "material":
                return k.getMaterial();
            case "style":
                return k.getStyle();
            default:
                return null;
        }
    }

    private boolean arrayEnthaeltWert(String[] array, String wert) {
        if (array == null) return false;
        for (String element : array) {
            if (element.equalsIgnoreCase(wert)) {
                return true;
            }
        }
        return false;
    }
    
    private String getAttributWert(Kleidungsstueck k, String attributName) {
        switch (attributName.toLowerCase()) {

            //Kleidungsstueck (Basis)
            case "bezeichnung":
                return k.getBezeichnung();
            case "wettereignung":
                return k.getWettereignung();
            case "bedeckteskoerperteil":
                return k.getBedecktesKoerperteil();
            case "marke":
                return k.getMarke();
            case "bilddateipfad":
                return k.getBildDateiPfad();
            case "anmerkung":
                return k.getAnmerkung();
            case "kleidungsid":
                return String.valueOf(k.getKleidungsID());

            //Einteiler
            case "ausschnittart":
                if (k instanceof Einteiler) {
                    return ((Einteiler) k).getAusschnittArt();
                }
                if (k instanceof Top) {
                    return ((Top) k).getAusschnittArt();
                }
                if (k instanceof TShirt) {
                    return ((TShirt) k).getAusschnittArt();
                }
                return null;
            case "weite":
                if (k instanceof Einteiler) {
                    return ((Einteiler) k).getWeite();
                }
                if (k instanceof Hose) {
                    return ((Hose) k).getWeite();
                }
                return null;
            case "laenge":
                if (k instanceof Einteiler) {
                    return String.valueOf(((Einteiler) k).getLaenge());
                }
                if (k instanceof Unterteil) {
                    return String.valueOf(((Unterteil) k).getLaenge());
                }
                return null;
            case "hataermel":
                if (k instanceof Einteiler) {
                    return String.valueOf(((Einteiler) k).isHatAermel());
                }
                return null;

            //Oberteil
            case "aermellaenge":
                if (k instanceof Oberteil) {
                    return String.valueOf(((Oberteil) k).getAermelLaenge());
                }
                return null;
            case "schnitt":
                if (k instanceof Oberteil) {
                    return ((Oberteil) k).getSchnitt();
                }
                return null;

            //Hemd
            case "kragenart":
                if (k instanceof Hemd) {
                    return ((Hemd) k).getKragenArt();
                }
                if (k instanceof Polo) {
                    return ((Polo) k).getKragenArt();
                }
                return null;
            case "muster":
                if (k instanceof Hemd) {
                    return ((Hemd) k).getMuster();
                }
                if (k instanceof Halbschuhe) {
                    return ((Halbschuhe) k).getMuster();
                }
                if (k instanceof Stiefel) {
                    return ((Stiefel) k).getMuster();
                }
                return null;
                
            //Hoodie
            case "hattaschen":
                if (k instanceof Hoodie) {
                    return String.valueOf(((Hoodie) k).isHatTasche());
                }
                return null;    
            
            //Polo
            case "anzahlknopfe":
                if (k instanceof Polo) {
                    return String.valueOf(((Polo) k).getAnzahlKnopfe());
                }
                return null; 
                
            //Pullover
            case "strickart":
                if (k instanceof Pullover) {
                    return ((Pullover) k).getStrickArt();
                }
                if (k instanceof Muetze) {
                    return ((Muetze) k).getStrickArt();
                }
                return null; 
                
            //Top
            case "traegerart":
                if (k instanceof Top) {
                    return ((Top) k).getTraegerArt();
                }
                return null;         
                
            //Jacke
            case "verschlussart":
                if (k instanceof Jacke) {
                    return ((Jacke) k).getVerschlussArt();
                }
                if (k instanceof Schuhe) {
                    return ((Schuhe) k).getVerschlussArt();
                }
                if (k instanceof Cap) {
                    return ((Cap) k).getVerschlussArt();
                }
                return null;   
            case "istwasserdicht":
                if (k instanceof Jacke) {
                    return String.valueOf(((Jacke) k).isIstWasserdicht());
                }
                return null;
            case "futtermaterial":
                if (k instanceof Jacke) {
                    return ((Jacke) k).getFutterMaterial();
                }
                return null; 
                
            //Unterteil
            case "anzahltaschen":
                if (k instanceof Unterteil) {
                    return String.valueOf(((Unterteil) k).getAnzahlTaschen());
                }
                return null;   
                
            //Hose
            case "hatloecher":
                if (k instanceof Hose) {
                    return String.valueOf(((Hose) k).isHatLoecher());
                }
                return null; 
            case "waschung":
                if (k instanceof Hose) {
                    return ((Hose) k).getWaschung();
                }
                return null; 
            case "besonderheiten":
                if (k instanceof Hose) {
                    return ((Hose) k).getBesonderheiten();
                }
                return null;
            case "arthose":
                if (k instanceof Hose) {
                    return ((Hose) k).getArtHose();
                }
                return null; 
                
            //Rock
            case "artrock":
                if (k instanceof Rock) {
                    return ((Rock) k).getArtRock();
                }
                return null;

            //Schuhe
            case "absatzhoehe":
                if (k instanceof Schuhe) {
                    return String.valueOf(((Schuhe) k).getAbsatzHoehe());
                }
                return null; 
              

            //Halbschuhe
            case "art":
                if (k instanceof Halbschuhe) {
                    return ((Halbschuhe) k).getArt();
                }
                if (k instanceof Stiefel) {
                    return ((Stiefel) k).getArt();
                }
                return null;
                
            //High Heels
            case "istoffen":
                if (k instanceof HighHeels) {
                    return String.valueOf(((HighHeels) k).isIstOffen());
                }
                if (k instanceof Sandalen) {
                    return String.valueOf(((Sandalen) k).isIstOffen());
                }
                return null; 
                
            //Sandalen
            case "almanfaktor":
                if (k instanceof Sandalen) {
                    return String.valueOf(((Sandalen) k).getAlmanFaktor());
                }
                return null;
                
            //Cap
            case "istschirmgekruemmt":
                if (k instanceof Cap) {
                    return String.valueOf(((Cap) k).isIstSchirmGekruemmt());
                }
                return null;
                
            //Hut
            case "arthut":
                if (k instanceof Hut) {
                    return ((Hut) k).getArtHut();
                }
                return null;
            case "hoehe":
                if (k instanceof Hut) {
                    return String.valueOf(((Hut) k).getHoehe());
                }
                return null;
                
            //Muetze
            case "stil":
                if (k instanceof Muetze) {
                    return ((Muetze) k).getStil();
                }
                return null;     
            
            default:
                return null;
        }
    }
}

//Beispiele
//FilterLogik filter = new FilterLogik();
//filter.addFilter("farbe", "rot");
//filter.addFilter("wettereignung", "Sommer");
//filter.clearFilter();  // alle Filter löschen