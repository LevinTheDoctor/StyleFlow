package JSONHandling;

import static JSONHandling.JSONReaderHelper.*;
import Nutzer.Nutzer;

import java.util.ArrayList;

public class JSONReaderNutzer {
    public ArrayList<Nutzer> NutzerStartReader()
    {
       String [][] NutzerList = LesenSafe("Nutzer");
       ArrayList<Nutzer> nutzerArrayList = new ArrayList<Nutzer>();
       if(NutzerList != null){
           if (NutzerList.length != 0)
           {
               for (String[] nutzer : NutzerList){
                   nutzerArrayList.add(new Nutzer(nutzer));
               }
               return nutzerArrayList;
           }else{
               return null;
           }
       }else{
           return null;
       }

    }
}
