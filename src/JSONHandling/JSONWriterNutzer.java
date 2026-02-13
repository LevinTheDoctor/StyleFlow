package JSONHandling;
import static JSONHandling.JSONWriterHelper.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.logging.Logger;
import Nutzer.Nutzer;

public class JSONWriterNutzer {
    public void  NutzerWriter(Nutzer[] nutzer)
    {
        try
        {
            File NutzerFile = new File("Nutzer.json");
            PrintWriter writer = new PrintWriter(NutzerFile);
            writer.println("[");
            Nutzer LetzerNutzer = nutzer[nutzer.length-1];
            for (Nutzer indexnutzer : nutzer)
            {
                writer.println("{");
                WriteString(writer,"nutzername",indexnutzer.getNutzername(),false);
                WriteString(writer,"pfadZumBild",indexnutzer.getPfadZumBild(),false);
                WriteStringArray(writer,"LeiblingsFarbe",indexnutzer.getLeiblingsFarbe().toArray(new String[0]), false);
                WriteString(writer,"Standort",indexnutzer.getStandort(),false);
                WriteInteger(writer,"NutzerID",indexnutzer.getNutzerID(),true);
                if (indexnutzer.equals(LetzerNutzer))
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
        catch ( Exception e)
        {
            Logger LOGGER = Logger.getLogger(JSONWriterKleidungstuecke.class.getName());
            LOGGER.severe(e.getMessage());
        }
    }

}
