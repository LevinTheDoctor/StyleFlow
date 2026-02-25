package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.Hemd;
import KleidungsKlassen.KleidungsContainer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

import static Logik.ProgramSpeicher.AddKleidungsstueckToSchrank;

public class HemdController extends BasisController {

    @FXML private ComboBox<String> kragenArtComboBox;
    @FXML private ComboBox<String> musterComboBox;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;
    private int aermelLaenge;
    private String schnitt;

    @FXML
    public void initialize() {
        befuelleComboBox(kragenArtComboBox,
                "Stehkragen", "Kragen mit Krawatte", "Tab-Kragen"
        );
        befuelleComboBox(musterComboBox,
                "Einfarbig", "Gestreift", "Kariert", "Paisley"
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
        if (!validiereComboBoxen(kragenArtComboBox, musterComboBox)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }

        Hemd neuesHemd = new Hemd(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                basisVorauswahl.getMarke(),
                aermelLaenge,
                schnitt,
                kragenArtComboBox.getValue(),
                musterComboBox.getValue()
        );

        neuesHemd.setMarke(basisVorauswahl.getMarke());
        neuesHemd.setAnmerkung(basisVorauswahl.getAnmerkung());
        neuesHemd.setMaterial(basisVorauswahl.getMaterial());
        neuesHemd.setStyle(basisVorauswahl.getStyle());

        AddKleidungsstueckToSchrank(neuesHemd);
        MainController main = ladeFxmlMitController("/GUI/FXML/Main.fxml", speichernButton);
    }
}
