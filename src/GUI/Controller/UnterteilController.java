package GUI.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class UnterteilController extends BasisController {

    @FXML private TextField laengeTextField;
    @FXML private TextField anzahlTaschenTextField;
    @FXML private ComboBox<String> artUnterteilComboBox;
    @FXML private Button weiterButton;

    private BasisVorauswahl basisVorauswahl;

    @FXML
    public void initialize() {
        befuelleComboBox(artUnterteilComboBox,
                "Hose", "Rock"
        );
    }

    public void setBasisVorauswahl(BasisVorauswahl vorauswahl) {
        this.basisVorauswahl = vorauswahl;
    }

    @FXML
    private void handleWeiter() {
        if (!validiereComboBoxen(artUnterteilComboBox)) {
            zeigeDialog("Bitte Art des Unterteils auswählen.");
            return;
        }
        if (!validiereTextFelder(laengeTextField, anzahlTaschenTextField)) {
            zeigeDialog("Bitte Länge und Anzahl Taschen eingeben.");
            return;
        }

        int laenge;
        int anzahlTaschen;
        try {
            laenge = Integer.parseInt(laengeTextField.getText().trim());
            anzahlTaschen = Integer.parseInt(anzahlTaschenTextField.getText().trim());
        } catch (NumberFormatException e) {
            zeigeDialog("Bitte gültige Zahlen eingeben.");
            return;
        }

        String fxmlPfad = switch (artUnterteilComboBox.getValue()) {
            case "Hose" -> "/GUI/FXML/Hose.fxml";
            case "Rock"  -> "/GUI/FXML/Rock.fxml";
            default -> null;
        };

        if (fxmlPfad == null) return;

        switch (artUnterteilComboBox.getValue()) {
            case "Hose" -> {
                HoseController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setVorauswahl(basisVorauswahl, laenge, anzahlTaschen);
            }
            case "Rock" -> {
                RockController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setVorauswahl(basisVorauswahl, laenge, anzahlTaschen);
            }
        }
    }


}
