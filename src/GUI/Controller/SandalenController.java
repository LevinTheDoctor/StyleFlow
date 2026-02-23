package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.KleidungsContainer;
import KleidungsKlassen.Sandalen;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class SandalenController extends BasisController {

    @FXML private CheckBox istOffenCheckBox;
    @FXML private TextField almanFaktorTextField;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;
    private String absatzHoehe;
    private String verschlussArt;

    @FXML
    public void initialize() {
        // Sandalen haben istOffen und almanFaktor
    }

    public void setVorauswahl(BasisVorauswahl basisVorauswahl, String absatzHoehe, String verschlussArt) {
        this.basisVorauswahl = basisVorauswahl;
        this.absatzHoehe = absatzHoehe;
        this.verschlussArt = verschlussArt;
    }

    @FXML
    private void handleSpeichern() {
        if (!validiereBildPfad(basisVorauswahl.getBildPfad())) return;
        if (!validiereTextFelder(almanFaktorTextField)) {
            zeigeDialog("Bitte Alman-Faktor eingeben.");
            return;
        }

        int almanFaktor;
        try {
            almanFaktor = Integer.parseInt(almanFaktorTextField.getText().trim());
        } catch (NumberFormatException e) {
            zeigeDialog("Bitte eine gültige Zahl für den Alman-Faktor eingeben.");
            return;
        }

        Sandalen neueSandalen = new Sandalen(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                absatzHoehe,
                verschlussArt,
                istOffenCheckBox.isSelected(),
                almanFaktor
        );

        neueSandalen.setMarke(basisVorauswahl.getMarke());
        neueSandalen.setAnmerkung(basisVorauswahl.getAnmerkung());
        neueSandalen.setMaterial(basisVorauswahl.getMaterial());
        neueSandalen.setStyle(basisVorauswahl.getStyle());

        KleidungsContainer container = new KleidungsContainer();
        ArrayList<Sandalen> sandalenListe = new ArrayList<>();
        sandalenListe.add(neueSandalen);
        container.setSandalen(sandalenListe);

        new JSONWriterKleidungstuecke().JSONWrite(container);
        zeigeDialog("Sandalen wurden erfolgreich gespeichert!");
    }
}
