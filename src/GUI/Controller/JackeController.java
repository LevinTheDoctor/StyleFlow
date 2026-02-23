package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.Jacke;
import KleidungsKlassen.KleidungsContainer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class JackeController extends BasisController {

    @FXML private ComboBox<String> verschlussArtComboBox;
    @FXML private ComboBox<String> futterMaterialComboBox;
    @FXML private ComboBox<String> jackenArtComboBox;
    @FXML private CheckBox wasserdichtCheckBox;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;
    private int aermelLaenge;
    private String schnitt;

    @FXML
    public void initialize() {
        befuelleComboBox(verschlussArtComboBox,
                "Reißverschluss", "Knöpfe", "Klettverschluss"
        );
        befuelleComboBox(futterMaterialComboBox,
                "Polyester", "Fleece", "Baumwolle", "Kein Futter"
        );
        befuelleComboBox(jackenArtComboBox,
                "Mantel","WinterJacke","RegenJacke","SweatshirtJacke","UebergangsJacke"
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
        if (!validiereComboBoxen(verschlussArtComboBox, futterMaterialComboBox)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }




        zeigeDialog("Jacke wurde erfolgreich gespeichert!");
    }
}
