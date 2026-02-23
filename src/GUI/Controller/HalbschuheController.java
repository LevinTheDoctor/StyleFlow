package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.Halbschuhe;
import KleidungsKlassen.KleidungsContainer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class HalbschuheController extends BasisController {

    @FXML private ComboBox<String> artComboBox;
    @FXML private ComboBox<String> musterComboBox;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;
    private String absatzHoehe;
    private String verschlussArt;

    @FXML
    public void initialize() {
        befuelleComboBox(artComboBox,
                "Oxford", "Derby", "Brogues", "Monkstrap", "Loafers"
        );
        befuelleComboBox(musterComboBox,
                "Einfarbig", "Kariert", "Gestreift", "Lederoptik"
        );
    }

    public void setVorauswahl(BasisVorauswahl basisVorauswahl, String absatzHoehe, String verschlussArt) {
        this.basisVorauswahl = basisVorauswahl;
        this.absatzHoehe = absatzHoehe;
        this.verschlussArt = verschlussArt;
    }

    @FXML
    private void handleSpeichern() {
        if (!validiereBildPfad(basisVorauswahl.getBildPfad())) return;
        if (!validiereComboBoxen(artComboBox, musterComboBox)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }

        Halbschuhe neueHalbschuhe = new Halbschuhe(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                absatzHoehe,
                verschlussArt,
                artComboBox.getValue(),
                musterComboBox.getValue()
        );

        neueHalbschuhe.setMarke(basisVorauswahl.getMarke());
        neueHalbschuhe.setAnmerkung(basisVorauswahl.getAnmerkung());
        neueHalbschuhe.setMaterial(basisVorauswahl.getMaterial());
        neueHalbschuhe.setStyle(basisVorauswahl.getStyle());

        KleidungsContainer container = new KleidungsContainer();
        ArrayList<Halbschuhe> halbschuheListe = new ArrayList<>();
        halbschuheListe.add(neueHalbschuhe);
        container.setHalbschuhe(halbschuheListe);

        new JSONWriterKleidungstuecke().JSONWrite(container);
        zeigeDialog("Halbschuhe wurden erfolgreich gespeichert!");
    }
}
