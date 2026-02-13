package JSONHandling;

import static JSONHandling.JSONReaderHelper.*;
import Nutzer.Nutzer;

public class JSONReaderNutzer {
    public Nutzer[] NutzerStartReader()
    {
       if (LesenMoeglich("Nutzer"))
       {
           //Stand in werte
           Nutzer[] nutzer = new Nutzer[2];
          return nutzer;
       }
       else
       {
           return null;
       }

    }
}
