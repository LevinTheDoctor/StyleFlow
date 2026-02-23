package GUI.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class KopfbedeckungController extends BasisController {

    @FXML private ComboBox<String> artDerKopfbedeckungComboBox;
    @FXML private Button weiterButton;

    private BasisVorauswahl basisVorauswahl;

    @FXML
    public void initialize() {
        befuelleComboBox(artDerKopfbedeckungComboBox,
                "Hut", "Mütze", "Cap"
        );
    }

    public void setBasisVorauswahl(BasisVorauswahl vorauswahl) {
        this.basisVorauswahl = vorauswahl;
    }

    @FXML
    private void handleWeiter() {
        if (!validiereComboBoxen(artDerKopfbedeckungComboBox)) {
            zeigeDialog("Bitte Art der Kopfbedeckung auswählen.");
            return;
        }

        String fxmlPfad = switch (artDerKopfbedeckungComboBox.getValue()) {
            case "Hut"   -> "/GUI/FXML/Hut.fxml";
            case "Mütze" -> "/GUI/FXML/Muetze.fxml";
            case "Cap"   -> "/GUI/FXML/Cap.fxml";
            default -> null;
        };

        if (fxmlPfad == null) return;

        switch (artDerKopfbedeckungComboBox.getValue()) {
            case "Hut" -> {
                HutController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setVorauswahl(basisVorauswahl);
            }
            case "Mütze" -> {
                MuetzeController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setVorauswahl(basisVorauswahl);
            }
            case "Cap" -> {
                CapController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setVorauswahl(basisVorauswahl);
            }
        }
    }
}
