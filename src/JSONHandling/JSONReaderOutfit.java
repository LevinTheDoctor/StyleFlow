package JSONHandling;


import KleidungsKlassen.KleidungsContainer;
import Outfit.Outfit;

import java.util.ArrayList;

import static JSONHandling.JSONReaderHelper.LesenSafe;
public class JSONReaderOutfit {
    public ArrayList<Outfit> OutfitReader(KleidungsContainer kleidungsContainer) {
        String[][] OutfitList = LesenSafe("Outfit");
        ArrayList<Outfit> OutfitArrayList = new ArrayList<Outfit>();
        if (OutfitList != null) {
            if(OutfitList.length !=0)

            {
                for (String[] OutfitS : OutfitList) {
                    OutfitArrayList.add(new Outfit(OutfitS,kleidungsContainer));
                }
                return OutfitArrayList;
            }else

            {
                return null;
            }
        }else{
            return null;
        }
    }
}
