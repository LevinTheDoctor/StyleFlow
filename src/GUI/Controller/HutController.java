package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.Hut;
import KleidungsKlassen.KleidungsContainer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static Logik.ProgramSpeicher.AddKleidungsstueckToSchrank;

public class HutController extends BasisController {

    @FXML private ComboBox<String> artHutComboBox;
    @FXML private TextField hoeheTextField;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;

    @FXML
    public void initialize() {
        befuelleComboBox(artHutComboBox,
                "Fedora", "Homburg", "Strohhut", "Top Hat", "Baseball Cap"
        );
    }

    public void setVorauswahl(BasisVorauswahl vorauswahl) {
        this.basisVorauswahl = vorauswahl;
    }

    @FXML
    private void handleSpeichern() {
        if (!validiereBildPfad(basisVorauswahl.getBildPfad())) return;
        if (!validiereComboBoxen(artHutComboBox)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }
        if (!validiereTextFelder(hoeheTextField)) {
            zeigeDialog("Bitte Höhe eingeben.");
            return;
        }

        int hoehe;
        try {
            hoehe = Integer.parseInt(hoeheTextField.getText().trim());
        } catch (NumberFormatException e) {
            zeigeDialog("Bitte eine gültige Zahl für die Höhe eingeben.");
            return;
        }

        Hut neuerHut = new Hut(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                hoehe,
                artHutComboBox.getValue()
        );

        neuerHut.setMarke(basisVorauswahl.getMarke());
        neuerHut.setAnmerkung(basisVorauswahl.getAnmerkung());
        neuerHut.setMaterial(basisVorauswahl.getMaterial());
        neuerHut.setStyle(basisVorauswahl.getStyle());

        AddKleidungsstueckToSchrank(neuerHut);
        MainController main = ladeFxmlMitController("/GUI/FXML/Main.fxml", speichernButton);
    }
}
