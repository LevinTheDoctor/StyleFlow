import java.io.File;
import java.io.PrintWriter;
import java.util.logging.Logger;
public class JSONWriter {
    public void Komma(PrintWriter writer, Boolean LetztesElement)
    {
        if (LetztesElement)
        {
            writer.println(",");
        }
        else
        {
            writer.println("");
        }
    }
    public void WriteBoolean (PrintWriter writer,String name, Boolean Wert,Boolean LetztesElement)
    {
        writer.print("\""+ name +"\":" + Wert);
        Komma(writer,LetztesElement);
    }

    public void WriteInteger (PrintWriter writer,String name, Integer Wert, Boolean LetztesElement)
    {
        writer.print("\""+ name +"\":" + Wert);
        Komma(writer,LetztesElement);
    }
    public void WriteString (PrintWriter writer,String name, String Wert, Boolean LetztesElement)
    {
        writer.print("\""+ name +"\": \"" + Wert + "\"");
        Komma(writer,LetztesElement);
    }

    public void WriteStringArray (PrintWriter writer,String name, String[] Werte, Boolean LetztesElementBool)
    {
        String LetztesElement = Werte[Werte.length -1];
        writer.print("\""+ name + "[");
        for (String Wert : Werte)
        {
            writer.print("\"" + Wert + "\"");
            if (!Wert.equals(LetztesElement))
            {
                writer.print(", ");
            }
        }
        writer.print("]");
        Komma(writer,LetztesElementBool);
    }
    // Wirklich Schreibfunktionen für die jeweiligen Kleidungsstücke
    public void KleidungsstueckWriter(Kleidungsstueck[] kleidungsstuecke)
    {
        try
        {
            File KleidungstueckeFile = new File("Kleidungsstuecke.json");
            PrintWriter writer = new PrintWriter(KleidungstueckeFile);
            writer.println("[");
            Kleidungsstueck LetzesKleidungsstueck = kleidungsstuecke[kleidungsstuecke.length -1];
            for (Kleidungsstueck kleidungsstueck : kleidungsstuecke) {
                writer.println("{");
                WriteString(writer,"Name",kleidungsstueck.getAnlass(),false);
                WriteStringArray(writer,"Farbe",kleidungsstueck.getFarbe(),false);
                WriteString(writer,"Groesse",kleidungsstueck.getGroesse(),false);
                WriteStringArray(writer,"Material",kleidungsstueck.getMaterial(),false);
                WriteString(writer,"Marke",kleidungsstueck.getMarke(),false);
                WriteString(writer,"Anlass",kleidungsstueck.getAnlass(),false);
                WriteString(writer,"Wetter",kleidungsstueck.getWetter(),false);
                WriteString(writer,"BildDateiPfad",kleidungsstueck.getBildDateiPfad(),false);
                WriteInteger(writer,"KleidungsID",kleidungsstueck.getKleidungsID(),true);
                if (kleidungsstueck.equals(LetzesKleidungsstueck))
                {
                    writer.println("}");
                } else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            // Logger da e.printStackTrace() Warungen ausgeworfen hat
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    // Oberteil Writer
    public void OberteilWriter(Oberteil[] oberteile)
    {
        try
        {
            File OberteilFile = new File("Oberteil.json");
            PrintWriter writer = new PrintWriter(OberteilFile);
            writer.println("[");
            Oberteil LetzeKopfbedeckung = oberteile[oberteile.length -1];
            for (Oberteil oberteil : oberteile) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",oberteil.getKleidungsID(),false);
                WriteInteger(writer,"AermelLaenge",oberteil.getAermelLaenge(),false);
                WriteString(writer,"Schnitt",oberteil.getSchnitt(),true);
                if (oberteil.equals(LetzeKopfbedeckung))
                {
                    writer.println("}");
                } else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }
    //Writer für die Ausprägungen von Oberteil
    public void hemdWriter(Hemd[] hemden)
    {
        try
        {
            File HemdFile = new File("Hemden.json");
            PrintWriter writer = new PrintWriter(HemdFile);
            writer.println("[");
            Hemd LetztesHemd = hemden[hemden.length -1];
            for (Hemd hemd : hemden) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",hemd.getKleidungsID(),false);
                WriteString(writer,"KragenArt",hemd.getKragenArt(),false);
                WriteString(writer,"KnopfMaterial",hemd.getKnopfMaterial(),true);
                if (hemd.equals(LetztesHemd))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        } catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void pulloverWriter(Pullover[] pullover)
    {
        try
        {
            File PulloverFile = new File("Pullover.json");
            PrintWriter writer = new PrintWriter(PulloverFile);
            writer.println("[");
            Pullover LetzterPullover = pullover[pullover.length -1];
            for (Pullover pulli : pullover) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",pulli.getKleidungsID(),false);
                WriteString(writer,"AusschnitArt",pulli.getAusschnitArt(),false);
                WriteString(writer,"Muster",pulli.getMuster(),false);
                WriteString(writer,"Strickart",pulli.getStrickArt(),true);
                if (pulli.equals(LetzterPullover))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        } catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void TShirtWriter(TShirt[] tShirts)
    {
        try
        {
            File TShirtFile = new File("TShirts.json");
            PrintWriter writer = new PrintWriter(TShirtFile);
            writer.println("[");
            TShirt LetztesTShirt = tShirts[tShirts.length -1];
            for (TShirt tShirt : tShirts) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",tShirt.getKleidungsID(),false);
                WriteString(writer,"AusschnitArt",tShirt.getAusschnitArt(),false);
                WriteString(writer,"Motiv",tShirt.getMotiv(),true);
                if (tShirt.equals(LetztesTShirt))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void SweatShirtWriter(SweatShirt[] sweatShirts)
    {
        try
        {
            File SweatShirtFile = new File("SweatShirts.json");
            PrintWriter writer = new PrintWriter(SweatShirtFile);
            writer.println("[");
            SweatShirt LetztesSweatShirt = sweatShirts[sweatShirts.length -1];
            for (SweatShirt sweatShirt : sweatShirts) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",sweatShirt.getKleidungsID(),false);
                WriteBoolean(writer,"HatKapuzen",sweatShirt.isHatKaputze(),false);
                WriteBoolean(writer,"HatTasche",sweatShirt.isHatTasche(),true);
                if (sweatShirt.equals(LetztesSweatShirt))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void PoloWriter(Polo[] polos)
    {
        try
        {
            File PoloFile = new File("Polos.json");
            PrintWriter writer = new PrintWriter(PoloFile);
            writer.println("[");
            Polo LetztesPolo = polos[polos.length -1];
            for (Polo polo : polos) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",polo.getKleidungsID(),false);
                WriteString(writer,"AusschnitArt",polo.getAusschnitArt(),false);
                WriteInteger(writer,"AnzahlKnopfe",polo.getAnzahlKnopfe(),false);
                WriteString(writer,"Muster",polo.getMuster(),true);

                if (polo.equals(LetztesPolo))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void topWriter(Top[] tops)
    {
        try
        {
            File TopFile = new File("Tops.json");
            PrintWriter writer = new PrintWriter(TopFile);
            writer.println("[");
            Top LetztesTop = tops[tops.length -1];
            for (Top top : tops) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",top.getKleidungsID(),false);
                WriteString(writer,"AusschnitArt",top.getAusschnitArt(),false);
                WriteString(writer,"TraegerArt",top.getTraegerArt(),true);
                if (top.equals(LetztesTop))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void kopfbedeckungWriter(Kopfbedeckung[] kopfbedeckungen) {
        try
        {
            File KopfbedeckungFile = new File("Kopfbedeckungen.json");
            PrintWriter writer = new PrintWriter(KopfbedeckungFile);
            writer.println("[");
            Kopfbedeckung LetzeKopfbedeckung = kopfbedeckungen[kopfbedeckungen.length -1];
            for (Kopfbedeckung kopfbedeckung : kopfbedeckungen) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",kopfbedeckung.getKleidungsID(),false);
                WriteBoolean(writer,"HatSchirm",kopfbedeckung.getHatSchirm(),false);
                WriteBoolean(writer,"BedecktGesicht",kopfbedeckung.getBedecktGesicht(),true);
                if (kopfbedeckung.equals(LetzeKopfbedeckung))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void unterteilWriter(Unterteil[] unterteile)
    {
        try
        {
            File UnterteilFile = new File("Unterteile.json");
            PrintWriter writer = new PrintWriter(UnterteilFile);
            writer.println("[");
            Unterteil LetzesUnterteil = unterteile[unterteile.length -1];
            for (Unterteil unterteil : unterteile) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",unterteil.getKleidungsID(),false);
                WriteInteger(writer,"AnzahlTaschen",unterteil.getAnzahlTaschen(),false);
                WriteInteger(writer,"Laenge",unterteil.getLaenge(),true);
                if (unterteil.equals(LetzesUnterteil))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void schuheWriter(Schuhe[] schuhe) {
        try
        {
            File SchuheFile = new File("Schuhe.json");
            PrintWriter writer = new PrintWriter(SchuheFile);
            writer.println("[");
            Schuhe LetzerSchuh = schuhe[schuhe.length -1];
            for (Schuhe Schuh : schuhe) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",Schuh.getKleidungsID(),false);
                WriteString(writer,"SolenMaterial",Schuh.getSolenMaterial(),false);
                WriteString(writer,"VerschlussTyp",Schuh.getVerschlussTyp(),true);
                if (Schuh.equals(LetzerSchuh))
                {
                    writer.println("}");
                }
                else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

public void kleidWriter(Kleid[] kleider) {
        try
        {
            File KleidFile = new File("Kleid.json");
            PrintWriter writer = new PrintWriter(KleidFile);
            writer.println("[");
            Kleid LetzesKleide = kleider[kleider.length -1];
            for (Kleid kleid : kleider) {
                writer.println("{");
                WriteString(writer,"AuschnittArt",kleid.getAuschnitArt(),false);
                WriteString(writer,"Schnitt",kleid.getSchnitt(),false);
                WriteInteger(writer,"LangeInCM",kleid.getLangeInCM(),false);
                WriteBoolean(writer,"HatArmel",kleid.isHatAermel(),true);
                if (kleid.equals(LetzesKleide))
                {
                    writer.println("}");
                } else
                {
                    writer.println("},");
                }
            }
            writer.println("]");
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
}




}
