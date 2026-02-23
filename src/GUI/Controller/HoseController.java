package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.Hose;
import KleidungsKlassen.KleidungsContainer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static Logik.ProgramSpeicher.AddKleidungsstueckToSchrank;

public class HoseController extends BasisController {

    @FXML private CheckBox hatLoecherCheckBox;
    @FXML private ComboBox<String> weiteComboBox;
    @FXML private ComboBox<String> waschungComboBox;
    @FXML private TextField besonderheitenTextField;
    @FXML private ComboBox<String> artHoseComboBox;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;
    private int laenge;
    private int anzahlTaschen;

    @FXML
    public void initialize() {
        befuelleComboBox(weiteComboBox,
                "Slim", "Regular", "Wide", "Oversized"
        );
        befuelleComboBox(waschungComboBox,
                "Ungewaschen", "Stonewash", "Acid Wash", "Bleached"
        );
        befuelleComboBox(artHoseComboBox,
                "Jeans", "Chino", "Cargo", "Jogger", "Anzugshose"
        );
    }

    public void setVorauswahl(BasisVorauswahl basisVorauswahl, int laenge, int anzahlTaschen) {
        this.basisVorauswahl = basisVorauswahl;
        this.laenge = laenge;
        this.anzahlTaschen = anzahlTaschen;
    }

    @FXML
    private void handleSpeichern() {
        if (!validiereBildPfad(basisVorauswahl.getBildPfad())) return;
        if (!validiereComboBoxen(weiteComboBox, waschungComboBox, artHoseComboBox)) {
            zeigeDialog("Bitte alle Pflichtfelder ausfüllen.");
            return;
        }

        Hose neueHose = new Hose(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                laenge,
                anzahlTaschen,
                hatLoecherCheckBox.isSelected(),
                weiteComboBox.getValue(),
                waschungComboBox.getValue(),
                besonderheitenTextField.getText().trim().isEmpty() ? "" : besonderheitenTextField.getText().trim(),
                artHoseComboBox.getValue()
        );

        neueHose.setMarke(basisVorauswahl.getMarke());
        neueHose.setAnmerkung(basisVorauswahl.getAnmerkung());
        neueHose.setMaterial(basisVorauswahl.getMaterial());
        neueHose.setStyle(basisVorauswahl.getStyle());

        AddKleidungsstueckToSchrank(neueHose);
    }
}
