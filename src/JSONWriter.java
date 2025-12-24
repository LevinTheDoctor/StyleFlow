import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
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
    public void KleidungsstueckWriter(Kleidungsstueck[] kleidungsstuecke) {
        try
        {
            File KleidungstueckeFile = new File("Kleidungsstuecke.json");
            PrintWriter writer = new PrintWriter(KleidungstueckeFile);
            writer.println("[");
            Kleidungsstueck LetzesKleidungsstück = kleidungsstuecke[kleidungsstuecke.length -1];
            for (Kleidungsstueck kleidungsstueck : kleidungsstuecke) {
                writer.println("{");
                WriteString(writer,"Name",kleidungsstueck.getAnlass(),false);
                WriteStringArray(writer,"Farbe",kleidungsstueck.getFarbe(),false);
                WriteString(writer,"Groesse",kleidungsstueck.getGroesse(),false);;
                WriteStringArray(writer,"Material",kleidungsstueck.getMaterial(),false);
                WriteString(writer,"Marke",kleidungsstueck.getMarke(),false);
                WriteString(writer,"Anlass",kleidungsstueck.getAnlass(),false);
                WriteString(writer,"Wetter",kleidungsstueck.getWetter(),false);
                WriteString(writer,"BildDateiPfad",kleidungsstueck.getBildDateiPfad(),false);
                WriteInteger(writer,"KleidungsID",kleidungsstueck.getKleidungsID(),true);
                if (kleidungsstueck.equals(LetzesKleidungsstück))
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
        } catch (Exception e)
        {
            // Logger da e.printStackTrace() Warungen ausgeworfen hat
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }
    public void OberteilWriter(Oberteil[] oberteile) {
        try
        {
            File OberteilFile = new File("Oberteil.json");
            PrintWriter writer = new PrintWriter(OberteilFile);
            writer.println("[");
            Oberteil LetzeKopfbedeckung = oberteile[oberteile.length -1];
            for (Oberteil oberteil : oberteile) {
                writer.println("{");
                WriteInteger(writer,"KleidungsID",oberteil.getKleidungsID(),false);
                WriteInteger(writer,"AermelLaenge",oberteil.getAermelLaenge(),false); ;
                WriteString(writer,"Schnitt",oberteil.getSchnitt(),true); ;
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
        } catch (Exception e)
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
                WriteBoolean(writer,"HatSchirm",kopfbedeckung.getHatSchirm(),false); ;
                WriteBoolean(writer,"BedecktGesicht",kopfbedeckung.getBedecktGesicht(),true); ;
                if (kopfbedeckung.equals(LetzeKopfbedeckung))
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
        } catch (Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

    public void unterteilWriter(Unterteil[] unterteile) {
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
                } else
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
                } else
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





}
