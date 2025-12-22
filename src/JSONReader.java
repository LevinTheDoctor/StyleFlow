import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Logger;
public class JSONReader {

    // Überprüft, ob das Lesen der JSON-Datei Existirt wichtig für den Ersten Start
    public boolean LesenMoeglich(String filename)
    {
        File File = new File(filename + ".json");
        return File.exists();
    }

    // Methoden zum Parsen der Daten aus der JSON-Datei
    public boolean ReadBoolean(String line)
    {
        String[] parts = line.split(":");
        return Boolean.parseBoolean(parts[1].trim().replace(",", "").replace("\"", ""));
    }

    public String ReadString(String line) {
        String[] parts = line.split(":");
        return parts[1].trim().replace(",", "").replace("\"", "");
    }

    public String[] ReadStringArray(String line)
    {
        String[] parts = line.split(":");
        String arrayInJSON = parts[1].trim().replace(",", "").replace("[", "").replace("]", "").replace("\"", "");
        return arrayInJSON.split(",");
    }

    public Integer ReadInteger(String line)
    {
        String[] parts = line.split(":");
        return Integer.parseInt(parts[1].trim().replace(",", "").replace("\"", ""));
    }

    // Methode zum Lesen der Oberteile aus der JSON-Datei zur Liste
    public Oberteil[] readOberteileJSON()
    {
        try(BufferedReader Reader = new BufferedReader(new FileReader("Oberteil.json")))  // Reader wird automatisch geschlossen
        {
            String line;
            StringBuilder Content = new StringBuilder();
            int ZeileAnzahl = 0;
            while ((line = Reader.readLine()) != null)
            {
               Content.append(line).append("\n");
               ZeileAnzahl++;
            }
            int AnzahlOberteile = (ZeileAnzahl-2) / 12; // Jedes Oberteil hat 12 Zeilen in der JSON-Datei
            Oberteil[] Oberteile = new Oberteil[AnzahlOberteile];
            String[] AlleZeilen = Content.toString().split("\n");
            int JSONIndex = 1;
            for (int OberteilIndex = 0; OberteilIndex < AnzahlOberteile; OberteilIndex++)
            {
                Oberteile[OberteilIndex] = new Oberteil(
                        ReadString(AlleZeilen[JSONIndex+1]),
                        ReadStringArray(AlleZeilen[JSONIndex+2]),
                        ReadString(AlleZeilen[JSONIndex+3]),
                        ReadStringArray(AlleZeilen[JSONIndex+4]),
                        ReadString(AlleZeilen[JSONIndex+5]),
                        ReadString(AlleZeilen[JSONIndex+6]),
                        ReadString(AlleZeilen[JSONIndex+7]),
                        ReadString(AlleZeilen[JSONIndex+8]),
                        ReadInteger(AlleZeilen[JSONIndex+9]),
                        ReadString(AlleZeilen[JSONIndex+10])
                );
                JSONIndex += 12;
            }
            return Oberteile;
        }
        catch (Exception e)
        {
            // Logger da e.printStackTrace() Warungen ausgeworfen hat
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
            return null;
        }

    }

    public Unterteil[] readUnterteileJSON()
    {
        try(BufferedReader Reader = new BufferedReader(new FileReader("Unterteil.json")))  // Reader wird automatisch geschlossen
        {
            String line;
            StringBuilder Content = new StringBuilder();
            int ZeileAnzahl = 0;
            while ((line = Reader.readLine()) != null)
            {
                Content.append(line).append("\n");
                ZeileAnzahl++;
            }
            int AnzahlUnterteile = (ZeileAnzahl-2) / 12; // Jedes Unterteil hat 11 Zeilen in der JSON-Datei
            Unterteil[] Unterteil = new Unterteil[AnzahlUnterteile];
            String[] AlleZeilen = Content.toString().split("\n");
            int JSONIndex = 1;
            for (int UnterteilIndex = 0; UnterteilIndex < AnzahlUnterteile; UnterteilIndex++)
            {
                Unterteil[UnterteilIndex] = new Unterteil(
                        ReadString(AlleZeilen[JSONIndex+1]),
                        ReadStringArray(AlleZeilen[JSONIndex+2]),
                        ReadString(AlleZeilen[JSONIndex+3]),
                        ReadStringArray(AlleZeilen[JSONIndex+4]),
                        ReadString(AlleZeilen[JSONIndex+5]),
                        ReadString(AlleZeilen[JSONIndex+6]),
                        ReadString(AlleZeilen[JSONIndex+7]),
                        ReadString(AlleZeilen[JSONIndex+8]),
                        ReadInteger(AlleZeilen[JSONIndex+9]),
                        ReadInteger(AlleZeilen[JSONIndex+10])
                );
                JSONIndex += 12;
            }
            return Unterteil;
        }
        catch (Exception e)
        {
            // Logger da e.printStackTrace() Warungen ausgeworfen hat
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
            return null;
        }

    }

    public Kopfbedeckung[] readKopfbedckungJSON()
    {
        try(BufferedReader Reader = new BufferedReader(new FileReader("Kopfbedeckung.json")))  // Reader wird automatisch geschlossen
        {
            String line;
            StringBuilder Content = new StringBuilder();
            int ZeileAnzahl = 0;
            while ((line = Reader.readLine()) != null)
            {
                Content.append(line).append("\n");
                ZeileAnzahl++;
            }
            int AnzahlKopfbedckung = (ZeileAnzahl-2) / 12; // Jede Kopfbedeckung hat 12 Zeilen in der JSON-Datei
            Kopfbedeckung[] kopfbedeckung = new Kopfbedeckung[AnzahlKopfbedckung];
            String[] AlleZeilen = Content.toString().split("\n");
            int JSONIndex = 1;
            for (int KopfbedeckungIndex = 0; KopfbedeckungIndex < AnzahlKopfbedckung; KopfbedeckungIndex++)
            {
                kopfbedeckung[KopfbedeckungIndex] = new Kopfbedeckung(
                        ReadString(AlleZeilen[JSONIndex+1]),
                        ReadStringArray(AlleZeilen[JSONIndex+2]),
                        ReadString(AlleZeilen[JSONIndex+3]),
                        ReadStringArray(AlleZeilen[JSONIndex+4]),
                        ReadString(AlleZeilen[JSONIndex+5]),
                        ReadString(AlleZeilen[JSONIndex+6]),
                        ReadString(AlleZeilen[JSONIndex+7]),
                        ReadString(AlleZeilen[JSONIndex+8]),
                        ReadBoolean(AlleZeilen[JSONIndex+9]),
                        ReadBoolean(AlleZeilen[JSONIndex+10])
                );
                JSONIndex += 11;
            }
            return kopfbedeckung;
        }
        catch (Exception e)
        {
            // Logger da e.printStackTrace() Warungen ausgeworfen hat
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
            return null;
        }

    }

    public Schuhe[] readSchuheJSON()
    {
        try(BufferedReader Reader = new BufferedReader(new FileReader("Schuhe.json")))  // Reader wird automatisch geschlossen
        {
            String line;
            StringBuilder Content = new StringBuilder();
            int ZeileAnzahl = 0;
            while ((line = Reader.readLine()) != null)
            {
                Content.append(line).append("\n");
                ZeileAnzahl++;
            }
            int AnzahlSchuhe = (ZeileAnzahl-2) / 11; // Jeder Schuh hat 11 Zeilen in der JSON-Datei
            Schuhe[] schuhe = new Schuhe[AnzahlSchuhe];
            String[] AlleZeilen = Content.toString().split("\n");
            int JSONIndex = 1;
            for (int SchuheIndex = 0; SchuheIndex < AnzahlSchuhe; SchuheIndex++)
            {
                schuhe[SchuheIndex] = new Schuhe(
                        ReadString(AlleZeilen[JSONIndex+1]),
                        ReadStringArray(AlleZeilen[JSONIndex+2]),
                        ReadString(AlleZeilen[JSONIndex+3]),
                        ReadStringArray(AlleZeilen[JSONIndex+4]),
                        ReadString(AlleZeilen[JSONIndex+5]),
                        ReadString(AlleZeilen[JSONIndex+6]),
                        ReadString(AlleZeilen[JSONIndex+7]),
                        ReadString(AlleZeilen[JSONIndex+8]),
                        ReadString(AlleZeilen[JSONIndex+9]),
                        ReadString(AlleZeilen[JSONIndex+10])
                );
                JSONIndex += 11;
            }
            return schuhe;
        }
        catch (Exception e)
        {
            // Logger da e.printStackTrace() Warungen ausgeworfen hat
            Logger LOGGER = Logger.getLogger(JSONWriter.class.getName());
            LOGGER.severe(e.getMessage());
            return null;
        }

    }
}


