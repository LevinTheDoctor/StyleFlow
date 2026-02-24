package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.KleidungsContainer;
import KleidungsKlassen.Rock;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

import static Logik.ProgramSpeicher.AddKleidungsstueckToSchrank;

public class RockController extends BasisController {

    @FXML private ComboBox<String> artRockComboBox;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;
    private int laenge;
    private int anzahlTaschen;

    @FXML
    public void initialize() {
        befuelleComboBox(artRockComboBox,
                "Maxi", "Midi", "Mini", "Bleistift", "A-Linie", "Wickelrock"
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
        if (!validiereComboBoxen(artRockComboBox)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }

        Rock neuerRock = new Rock(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                laenge,
                anzahlTaschen,
                artRockComboBox.getValue()
        );

        neuerRock.setMarke(basisVorauswahl.getMarke());
        neuerRock.setAnmerkung(basisVorauswahl.getAnmerkung());
        neuerRock.setMaterial(basisVorauswahl.getMaterial());
        neuerRock.setStyle(basisVorauswahl.getStyle());

        AddKleidungsstueckToSchrank(neuerRock);
        MainController main = ladeFxmlMitController("/GUI/FXML/Main.fxml", speichernButton);
    }
}
