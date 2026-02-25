package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.KleidungsContainer;
import KleidungsKlassen.Stiefel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

import static Logik.ProgramSpeicher.AddKleidungsstueckToSchrank;

public class StiefelController extends BasisController {

    @FXML private ComboBox<String> artDerStiefelComboBox;
    @FXML private ComboBox<String> musterComboBox;
    @FXML private Button           speichernButton;

    private BasisVorauswahl basisVorauswahl;
    private String          absatzHoehe;
    private String          verschlussArt;

    @FXML
    public void initialize() {
        befuelleComboBox(artDerStiefelComboBox,
                "Chelsea Boot", "Cowboy Stiefel", "Schnürstiefel", "Gummistiefel", "Plateaustiefel"
        );
        befuelleComboBox(musterComboBox,
                "Einfarbig", "Kariert", "Gestreift", "Floral", "Camouflage"
        );
    }

    public void setVorauswahl(BasisVorauswahl basisVorauswahl, String absatzHoehe, String verschlussArt) {
        this.basisVorauswahl = basisVorauswahl;
        this.absatzHoehe     = absatzHoehe;
        this.verschlussArt   = verschlussArt;
    }

    @FXML
    private void handleSpeichern() {
        if (!validiereBildPfad(basisVorauswahl.getBildPfad())) return;
        if (!validiereComboBoxen(artDerStiefelComboBox, musterComboBox)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }

        Stiefel neuerStiefel = new Stiefel(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                basisVorauswahl.getMarke(),
                absatzHoehe,
                verschlussArt,
                artDerStiefelComboBox.getValue(),
                musterComboBox.getValue()
        );

        // Optionale Felder setzen
        neuerStiefel.setAnmerkung(basisVorauswahl.getAnmerkung());
        neuerStiefel.setMaterial(basisVorauswahl.getMaterial());
        neuerStiefel.setStyle(basisVorauswahl.getStyle());

        AddKleidungsstueckToSchrank(neuerStiefel);
        MainController main = ladeFxmlMitController("/GUI/FXML/Main.fxml", speichernButton);
    }
}
