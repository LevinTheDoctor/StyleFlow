package JSONHandling;
import static JSONHandling.JSONWriterHelper.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Logger;
import Nutzer.Nutzer;

public class JSONWriterNutzer {
    public void  NutzerWriter(ArrayList<Nutzer> nutzer)
    {
        try
        {
            File NutzerFile = new File("Nutzer.json");
            PrintWriter writer = new PrintWriter(NutzerFile);
            writer.println("[");
            int i = 0;
            for (Nutzer indexnutzer : nutzer)
            {
                writer.println("{");
                WriteInteger(writer,"NutzerID",indexnutzer.getNutzerID(),false);
                WriteString(writer,"nutzername",indexnutzer.getNutzername(),false);
                WriteString(writer,"pfadZumBild",indexnutzer.getPfadZumBild(),false);
                WriteString(writer,"Standort",indexnutzer.getStandort(),false);
                WriteStringArray(writer,"LieblingsFarbe",indexnutzer.getLieblingsFarbe().toArray(new String[0]), true);

                if (i == nutzer.size()-1)
                {
                    writer.println("}");
                } else
                {
                    writer.println("},");
                }
                i++;
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
