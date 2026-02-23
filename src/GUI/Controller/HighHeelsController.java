package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.HighHeels;
import KleidungsKlassen.KleidungsContainer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;

public class HighHeelsController extends BasisController {

    @FXML private CheckBox istOffenCheckBox;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;
    private String absatzHoehe;
    private String verschlussArt;

    @FXML
    public void initialize() {
        // HighHeels hat nur die Checkbox für offen/geschlossen
    }

    public void setVorauswahl(BasisVorauswahl basisVorauswahl, String absatzHoehe, String verschlussArt) {
        this.basisVorauswahl = basisVorauswahl;
        this.absatzHoehe = absatzHoehe;
        this.verschlussArt = verschlussArt;
    }

    @FXML
    private void handleSpeichern() {
        if (!validiereBildPfad(basisVorauswahl.getBildPfad())) return;
        HighHeels neueHighHeels = new HighHeels(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                absatzHoehe,
                verschlussArt,
                istOffenCheckBox.isSelected()
        );

        neueHighHeels.setMarke(basisVorauswahl.getMarke());
        neueHighHeels.setAnmerkung(basisVorauswahl.getAnmerkung());
        neueHighHeels.setMaterial(basisVorauswahl.getMaterial());
        neueHighHeels.setStyle(basisVorauswahl.getStyle());

        KleidungsContainer container = new KleidungsContainer();
        ArrayList<HighHeels> highHeelsListe = new ArrayList<>();
        highHeelsListe.add(neueHighHeels);
        container.setHighHeels(highHeelsListe);

        new JSONWriterKleidungstuecke().JSONWrite(container);
        zeigeDialog("High Heels wurden erfolgreich gespeichert!");
    }
}
