package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.KleidungsContainer;
import KleidungsKlassen.Polo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static Logik.ProgramSpeicher.AddKleidungsstueckToSchrank;

public class PoloController extends BasisController {

    @FXML private ComboBox<String> kragenArtComboBox;
    @FXML private TextField anzahlKnopfeTextField;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;
    private int aermelLaenge;
    private String schnitt;

    @FXML
    public void initialize() {
        befuelleComboBox(kragenArtComboBox,
                "Stehkragen", "Umschlagkragen", "Button-Down"
        );
    }

    public void setVorauswahl(BasisVorauswahl basisVorauswahl, int aermelLaenge, String schnitt) {
        this.basisVorauswahl = basisVorauswahl;
        this.aermelLaenge = aermelLaenge;
        this.schnitt = schnitt;
    }

    @FXML
    private void handleSpeichern() {
        if (!validiereBildPfad(basisVorauswahl.getBildPfad())) return;
        if (!validiereComboBoxen(kragenArtComboBox) || !validiereTextFelder(anzahlKnopfeTextField)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }

        int anzahlKnopfe;
        try {
            anzahlKnopfe = Integer.parseInt(anzahlKnopfeTextField.getText().trim());
        } catch (NumberFormatException e) {
            zeigeDialog("Bitte eine gültige Zahl für die Knopfanzahl eingeben.");
            return;
        }

        Polo neuesPolo = new Polo(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                aermelLaenge,
                schnitt,
                kragenArtComboBox.getValue(),
                anzahlKnopfe
        );

        neuesPolo.setMarke(basisVorauswahl.getMarke());
        neuesPolo.setAnmerkung(basisVorauswahl.getAnmerkung());
        neuesPolo.setMaterial(basisVorauswahl.getMaterial());
        neuesPolo.setStyle(basisVorauswahl.getStyle());

        AddKleidungsstueckToSchrank(neuesPolo);
        zeigeDialog("Polo wurde erfolgreich gespeichert!");
    }
}
