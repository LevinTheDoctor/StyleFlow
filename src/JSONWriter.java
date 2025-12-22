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
    public void oberteilWriter(Oberteil[] oberteile) {
        try
        {
            File OberteilFile = new File("Oberteile.json");
            PrintWriter writer = new PrintWriter(OberteilFile);
            writer.println("[");
            Oberteil LetzesOberteil = oberteile[oberteile.length -1];
            for (Oberteil oberteil : oberteile) {
                writer.println("{");
                writer.println("\"Name\": \"" + oberteil.getName() + "\",");
                writer.print("\"Farbe\": " + "[");
                String[] farben = oberteil.getFarbe();
                String LetzteFarbe = farben[farben.length -1];
                for (String farbe : farben)
                {
                    writer.print("\"" + farbe + "\"");
                    if (!farbe.equals(LetzteFarbe))
                    {
                        writer.print(", ");
                    }
                }
                writer.println("],");
                writer.println("\"Groesse\": \"" + oberteil.getGroesse() + "\",");
                writer.print("\"Material\": " + "[");
                String[] Material = oberteil.getMaterial();
                String LetztesMaterial = Material[Material.length -1];
                for (String material : Material)
                {
                    writer.print("\"" + material + "\"");
                    if (!material.equals(LetztesMaterial))
                    {
                        writer.print(", ");
                    }
                }
                writer.println("],");
                writer.println("\"Marke\": \"" + oberteil.getMarke() + "\"");
                writer.println("\"Anlass\": \"" + oberteil.getAnlass() + "\"");
                writer.println("\"Wetter\": \"" + oberteil.getWetter() + "\"");
                writer.println("\"BildDateiPfad\": \"" + oberteil.getBildDateiPfad() + "\"");
                writer.println("\"AermelLaenge\": \"" + oberteil.getAermelLaenge() + "\"");
                writer.println("\"Schnitt\": \"" + oberteil.getSchnitt() + "\"");
                if (oberteil.equals(LetzesOberteil))
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

    public void kopfbedeckungWriter(Kopfbedeckung[] kopfbedeckungen) {
        try
        {
            File KopfbedeckungFile = new File("Kopfbedeckungen.json");
            PrintWriter writer = new PrintWriter(KopfbedeckungFile);
            writer.println("[");
            Kopfbedeckung LetzeKopfbedeckung = kopfbedeckungen[kopfbedeckungen.length -1];
            for (Kopfbedeckung kopfbedeckung : kopfbedeckungen) {
                writer.println("{");
                writer.println("\"Name\": \"" + kopfbedeckung.getName() + "\",");
                writer.print("\"Farbe\": " + "[");
                String[] farben = kopfbedeckung.getFarbe();
                String LetzteFarbe = farben[farben.length -1];
                for (String farbe : farben)
                {
                    writer.print("\"" + farbe + "\"");
                    if (!farbe.equals(LetzteFarbe))
                    {
                        writer.print(", ");
                    }
                }
                writer.println("],");
                writer.println("\"Groesse\": \"" + kopfbedeckung.getGroesse() + "\",");
                writer.print("\"Material\": " + "[");
                String[] Material = kopfbedeckung.getMaterial();
                String LetztesMaterial = Material[Material.length -1];
                for (String material : Material)
                {
                    writer.print("\"" + material + "\"");
                    if (!material.equals(LetztesMaterial))
                    {
                        writer.print(", ");
                    }
                }
                writer.println("],");
                writer.println("\"Marke\": \"" + kopfbedeckung.getMarke() + "\"");
                writer.println("\"Anlass\": \"" + kopfbedeckung.getAnlass() + "\"");
                writer.println("\"Wetter\": \"" + kopfbedeckung.getWetter() + "\"");
                writer.println("\"BildDateiPfad\": \"" + kopfbedeckung.getBildDateiPfad() + "\"");
                writer.println("\"HatSchirm\": " + kopfbedeckung.getHatSchirm() );
                writer.println("\"Bedeckt\": " + kopfbedeckung.getBedecktGesicht() );
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
                writer.println("\"Name\": \"" + unterteil.getName() + "\",");
                writer.print("\"Farbe\": " + "[");
                String[] farben = unterteil.getFarbe();
                String LetzteFarbe = farben[farben.length -1];
                for (String farbe : farben)
                {
                    writer.print("\"" + farbe + "\"");
                    if (!farbe.equals(LetzteFarbe))
                    {
                        writer.print(", ");
                    }
                }
                writer.println("],");
                writer.println("\"Groesse\": \"" + unterteil.getGroesse() + "\",");
                writer.print("\"Material\": " + "[");
                String[] Material = unterteil.getMaterial();
                String LetztesMaterial = Material[Material.length -1];
                for (String material : Material)
                {
                    writer.print("\"" + material + "\"");
                    if (!material.equals(LetztesMaterial))
                    {
                        writer.print(", ");
                    }
                }
                writer.println("],");
                writer.println("\"Marke\": \"" + unterteil.getMarke() + "\"");
                writer.println("\"Anlass\": \"" + unterteil.getAnlass() + "\"");
                writer.println("\"Wetter\": \"" + unterteil.getWetter() + "\"");
                writer.println("\"BildDateiPfad\": \"" + unterteil.getBildDateiPfad() + "\"");
                writer.println("\"AnzahlTaschen\": " + unterteil.getAnzahlTaschen());
                writer.println("\"Laenge\": " + unterteil.getLaenge() );

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
                writer.println("\"Name\": \"" + Schuh.getName() + "\",");
                writer.print("\"Farbe\": " + "[");
                String[] farben = Schuh.getFarbe();
                String LetzteFarbe = farben[farben.length -1];
                for (String farbe : farben)
                {
                    writer.print("\"" + farbe + "\"");
                    if (!farbe.equals(LetzteFarbe))
                    {
                        writer.print(", ");
                    }
                }
                writer.println("],");
                writer.println("\"Groesse\": \"" + Schuh.getGroesse() + "\",");
                writer.print("\"Material\": " + "[");
                String[] Material = Schuh.getMaterial();
                String LetztesMaterial = Material[Material.length -1];
                for (String material : Material)
                {
                    writer.print("\"" + material + "\"");
                    if (!material.equals(LetztesMaterial))
                    {
                        writer.print(", ");
                    }
                }
                writer.println("],");
                writer.println("\"Marke\": \"" + Schuh.getMarke() + "\"");
                writer.println("\"Anlass\": \"" + Schuh.getAnlass() + "\"");
                writer.println("\"Wetter\": \"" + Schuh.getWetter() + "\"");
                writer.println("\"BildDateiPfad\": \"" + Schuh.getBildDateiPfad() + "\"");
                writer.println("\"SolenMaterial\": \"" + Schuh.getSolenMaterial() + "\"");
                writer.println("\"VerschlussTyp\": \"" + Schuh.getVerschlussTyp() + "\"");
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
