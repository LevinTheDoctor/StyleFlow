package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.KleidungsContainer;
import KleidungsKlassen.Muetze;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

import static Logik.ProgramSpeicher.AddKleidungsstueckToSchrank;

public class MuetzeController extends BasisController {

    @FXML private ComboBox<String> stilComboBox;
    @FXML private ComboBox<String> strickArtComboBox;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;

    @FXML
    public void initialize() {
        befuelleComboBox(stilComboBox,
                "Sport", "Klassisch", "Streetwear", "Winter"
        );
        befuelleComboBox(strickArtComboBox,
                "Glatt", "Rippen", "Zopf", "Noppen"
        );
    }

    public void setVorauswahl(BasisVorauswahl vorauswahl) {
        this.basisVorauswahl = vorauswahl;
    }

    @FXML
    private void handleSpeichern() {
        if (!validiereBildPfad(basisVorauswahl.getBildPfad())) return;
        if (!validiereComboBoxen(stilComboBox, strickArtComboBox)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }

        Muetze neueMuetze = new Muetze(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                stilComboBox.getValue(),
                strickArtComboBox.getValue()
        );

        neueMuetze.setMarke(basisVorauswahl.getMarke());
        neueMuetze.setAnmerkung(basisVorauswahl.getAnmerkung());
        neueMuetze.setMaterial(basisVorauswahl.getMaterial());
        neueMuetze.setStyle(basisVorauswahl.getStyle());

        AddKleidungsstueckToSchrank(neueMuetze);
        MainController main = ladeFxmlMitController("/GUI/FXML/Main.fxml", speichernButton);
    }
}
