package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.Kleid;
import KleidungsKlassen.KleidungsContainer;
import KleidungsKlassen.Overall;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static Logik.ProgramSpeicher.AddKleidungsstueckToSchrank;

public class EinteilerController extends BasisController {

    @FXML private ComboBox<String> artEinteilerComboBox;
    @FXML private ComboBox<String> ausschnittArtComboBox;
    @FXML private ComboBox<String> weiteComboBox;
    @FXML private TextField laengeTextField;
    @FXML private CheckBox hatAermelCheckBox;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;

    @FXML
    public void initialize() {
        befuelleComboBox(artEinteilerComboBox,
                "Kleid", "Overall"
        );
        befuelleComboBox(ausschnittArtComboBox,
                "Rundhals", "V-Ausschnitt", "Boatneck", "Träger"
        );
        befuelleComboBox(weiteComboBox,
                "Eng", "Normalfit", "Weit", "Oversized"
        );
    }

    public void setBasisVorauswahl(BasisVorauswahl vorauswahl) {
        this.basisVorauswahl = vorauswahl;
    }

    @FXML
    private void handleSpeichern() {
        if (!validiereBildPfad(basisVorauswahl.getBildPfad())) return;
        if (!validiereComboBoxen(artEinteilerComboBox, ausschnittArtComboBox, weiteComboBox)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }
        if (!validiereTextFelder(laengeTextField)) {
            zeigeDialog("Bitte Länge eingeben.");
            return;
        }

        int laenge;
        try {
            laenge = Integer.parseInt(laengeTextField.getText().trim());
        } catch (NumberFormatException e) {
            zeigeDialog("Bitte eine gültige Zahl für die Länge eingeben.");
            return;
        }

        String ausschnittArt = ausschnittArtComboBox.getValue();
        String weite = weiteComboBox.getValue();
        boolean hatAermel = hatAermelCheckBox.isSelected();

        switch (artEinteilerComboBox.getValue()) {
            case "Kleid" -> {
                Kleid neuesKleid = new Kleid(
                        basisVorauswahl.getBezeichnung(),
                        basisVorauswahl.getFarben(),
                        basisVorauswahl.getBedecktesKoerperteil(),
                        basisVorauswahl.getWetterLage(),
                        basisVorauswahl.getBildPfad(),
                        basisVorauswahl.getMarke(),
                        ausschnittArt,
                        weite,
                        laenge,
                        hatAermel
                );
                neuesKleid.setMarke(basisVorauswahl.getMarke());
                neuesKleid.setAnmerkung(basisVorauswahl.getAnmerkung());
                neuesKleid.setMaterial(basisVorauswahl.getMaterial());
                neuesKleid.setStyle(basisVorauswahl.getStyle());

                AddKleidungsstueckToSchrank(neuesKleid);
                MainController main = ladeFxmlMitController("/GUI/FXML/Main.fxml", speichernButton);
            }
            case "Overall" -> {
                Overall neuerOverall = new Overall(
                        basisVorauswahl.getBezeichnung(),
                        basisVorauswahl.getFarben(),
                        basisVorauswahl.getBedecktesKoerperteil(),
                        basisVorauswahl.getWetterLage(),
                        basisVorauswahl.getBildPfad(),
                        basisVorauswahl.getMarke(),
                        ausschnittArt,
                        weite,
                        laenge,
                        hatAermel
                );
                neuerOverall.setAnmerkung(basisVorauswahl.getAnmerkung());
                neuerOverall.setMaterial(basisVorauswahl.getMaterial());
                neuerOverall.setStyle(basisVorauswahl.getStyle());

                AddKleidungsstueckToSchrank(neuerOverall);
                MainController main = ladeFxmlMitController("/GUI/FXML/Main.fxml", speichernButton);
            }
        }
    }
}
