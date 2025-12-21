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

    // Methoden zum Parsen der JSON-Datei
    public boolean BooleanAusJSON(String line)
    {
        String[] parts = line.split(":");
        return Boolean.parseBoolean(parts[1].trim().replace(",", "").replace("\"", ""));
    }

    public String StringAusJSON(String line) {
        String[] parts = line.split(":");
        return parts[1].trim().replace(",", "").replace("\"", "");
    }

    public String[] StringArrayAusJSON(String line)
    {
        String[] parts = line.split(":");
        String arrayInJSON = parts[1].trim().replace(",", "").replace("[", "").replace("]", "").replace("\"", "");
        return arrayInJSON.split(",");
    }

    public Integer IntegerAusJSON(String line)
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
            int AnzahlOberteile = (ZeileAnzahl-2) / 11; // Jede Oberteil hat 11 Zeilen in der JSON-Datei
            Oberteil[] Oberteile = new Oberteil[AnzahlOberteile];
            String[] AlleZeilen = Content.toString().split("\n");
            int JSONIndex = 1;
            for (int OberteilIndex = 0; OberteilIndex < AnzahlOberteile; OberteilIndex++)
            {
                Oberteile[OberteilIndex] = new Oberteil(
                        StringAusJSON(AlleZeilen[JSONIndex+1]),
                        StringArrayAusJSON(AlleZeilen[JSONIndex+2]),
                        StringAusJSON(AlleZeilen[JSONIndex+3]),
                        StringArrayAusJSON(AlleZeilen[JSONIndex+4]),
                        StringAusJSON(AlleZeilen[JSONIndex+5]),
                        StringAusJSON(AlleZeilen[JSONIndex+6]),
                        StringAusJSON(AlleZeilen[JSONIndex+7]),
                        StringAusJSON(AlleZeilen[JSONIndex+8]),
                        IntegerAusJSON(AlleZeilen[JSONIndex+9]),
                        StringAusJSON(AlleZeilen[JSONIndex+10])
                );
                JSONIndex += 11;
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


}


