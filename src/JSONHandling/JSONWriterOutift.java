package JSONHandling;

import Nutzer.Nutzer;
import Outfit.Outfit;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Logger;

import static JSONHandling.JSONWriterHelper.*;

public class JSONWriterOutift {
    public void  OutfitWriter(ArrayList<Outfit> Outfit)
    {
        try
        {
            File OutfitFile = new File("Outfit.json");
            PrintWriter writer = new PrintWriter(OutfitFile);
            writer.println("[");
            int i = 0;
            for (Outfit indexOutfit : Outfit)
            {
                writer.println("{");
                WriteInteger(writer,"ID", indexOutfit.getId(), false);
                if (indexOutfit.getKopfbedeckung() != null){
                    WriteInteger(writer,"KopfbeckungID",indexOutfit.getKopfbedeckung().getKleidungsID(), false);
                }else{
                    WriteInteger(writer,"KopfbeckungID",0, false);
                }
                if (indexOutfit.getOberteil() != null && indexOutfit.getUnterteil() != null){
                    WriteInteger(writer,"OberteilID", indexOutfit.getOberteil().getKleidungsID(), false);
                    WriteInteger(writer,"UnterteilID", indexOutfit.getUnterteil().getKleidungsID(), false);
                }else{
                    WriteInteger(writer,"EinteilerID",indexOutfit.getEinteiler().getKleidungsID(), false);
                }
                WriteInteger(writer,"SchuheID",indexOutfit.getSchuhe().getKleidungsID(),true);
                if (i == Outfit.size()-1)
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
