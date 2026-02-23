package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.Cap;
import KleidungsKlassen.KleidungsContainer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class CapController extends BasisController {

    @FXML private ComboBox<String> verschlussArtComboBox;
    @FXML private CheckBox schirmGekruemmtCheckBox;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;

    @FXML
    public void initialize() {
        befuelleComboBox(verschlussArtComboBox,
                "Klettverschluss", "Gummi", "Schnalle", "Stellring"
        );
    }

    public void setVorauswahl(BasisVorauswahl vorauswahl) {
        this.basisVorauswahl = vorauswahl;
    }

    @FXML
    private void handleSpeichern() {
        if (!validiereBildPfad(basisVorauswahl.getBildPfad())) return;
        if (!validiereComboBoxen(verschlussArtComboBox)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }

        Cap neueCap = new Cap(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                schirmGekruemmtCheckBox.isSelected(),
                verschlussArtComboBox.getValue()
        );

        neueCap.setMarke(basisVorauswahl.getMarke());
        neueCap.setAnmerkung(basisVorauswahl.getAnmerkung());
        neueCap.setMaterial(basisVorauswahl.getMaterial());
        neueCap.setStyle(basisVorauswahl.getStyle());

        KleidungsContainer container = new KleidungsContainer();
        ArrayList<Cap> capsListe = new ArrayList<>();
        capsListe.add(neueCap);
        container.setCaps(capsListe);

        new JSONWriterKleidungstuecke().JSONWrite(container);
        zeigeDialog("Cap wurde erfolgreich gespeichert!");
    }
}
