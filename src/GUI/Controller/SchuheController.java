package GUI.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class SchuheController extends BasisController {

    @FXML private ComboBox<String> artDerSchuheComboBox;
    @FXML private ComboBox<String> absatzHoeheComboBox;
    @FXML private ComboBox<String> verschlussArtComboBox;
    @FXML private Button           weiterButton;

    private BasisVorauswahl basisVorauswahl;

    @FXML
    public void initialize() {
        befuelleComboBox(artDerSchuheComboBox,
                "Halbschuhe", "High Heels", "Sandalen", "Sneaker", "Stiefel"
        );
        befuelleComboBox(absatzHoeheComboBox,
                "Flach (0-2 cm)", "Niedrig (2-4 cm)", "Mittel (4-7 cm)", "Hoch (>7 cm)"
        );
        befuelleComboBox(verschlussArtComboBox,
                "Schnürsenkel", "Reißverschluss", "Klettverschluss", "Schnalle", "Slip-on"
        );
    }

    public void setBasisVorauswahl(BasisVorauswahl vorauswahl) {
        this.basisVorauswahl = vorauswahl;
    }

    @FXML
    private void handleWeiter() {
        if (!validiereComboBoxen(artDerSchuheComboBox)) {
            zeigeDialog("Bitte Art der Schuhe auswählen.");
            return;
        }

        String fxmlPfad = switch (artDerSchuheComboBox.getValue()) {
            case "Halbschuhe" -> "/GUI/FXML/Halbschuhe.fxml";
            case "High Heels" -> "/GUI/FXML/HighHeels.fxml";
            case "Sandalen"   -> "/GUI/FXML/Sandalen.fxml";
            case "Sneaker"    -> "/GUI/FXML/Sneaker.fxml";
            case "Stiefel"    -> "/GUI/FXML/Stiefel.fxml";
            default -> null;
        };

        if (fxmlPfad == null) return;

        StiefelController next = ladeFxmlMitController(fxmlPfad, weiterButton);
        if (next != null) {
            next.setVorauswahl(
                    basisVorauswahl,
                    absatzHoeheComboBox.getValue(),
                    verschlussArtComboBox.getValue()
            );
        }
    }
}
