package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.KleidungsContainer;
import KleidungsKlassen.Top;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

import static Logik.ProgramSpeicher.AddKleidungsstueckToSchrank;

public class TopController extends BasisController {

    @FXML private ComboBox<String> ausschnittArtComboBox;
    @FXML private ComboBox<String> traegerArtComboBox;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;
    private int aermelLaenge;
    private String schnitt;

    @FXML
    public void initialize() {
        befuelleComboBox(ausschnittArtComboBox,
                "Rundhals", "V-Ausschnitt", "Boatneck", "Square"
        );
        befuelleComboBox(traegerArtComboBox,
                "Spaghetti", "Breit", "Halter", "Ohne Träger"
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
        if (!validiereComboBoxen(ausschnittArtComboBox, traegerArtComboBox)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }

        Top neuesTop = new Top(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                aermelLaenge,
                schnitt,
                ausschnittArtComboBox.getValue(),
                traegerArtComboBox.getValue()
        );

        neuesTop.setMarke(basisVorauswahl.getMarke());
        neuesTop.setAnmerkung(basisVorauswahl.getAnmerkung());
        neuesTop.setMaterial(basisVorauswahl.getMaterial());
        neuesTop.setStyle(basisVorauswahl.getStyle());

        AddKleidungsstueckToSchrank(neuesTop);
        MainController main = ladeFxmlMitController("/GUI/FXML/Main.fxml", speichernButton);
    }
}
