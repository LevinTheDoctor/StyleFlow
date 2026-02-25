package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

import static Logik.ProgramSpeicher.AddKleidungsstueckToSchrank;

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
        String ArtDerJack = jackenArtComboBox.getValue();
        switch (ArtDerJack) {
            case "Mantel":
                Mantel neuerMantel = new Mantel(
                        basisVorauswahl.getBezeichnung(),
                        basisVorauswahl.getFarben(),
                        basisVorauswahl.getBedecktesKoerperteil(),
                        basisVorauswahl.getWetterLage(),
                        basisVorauswahl.getBildPfad(),
                        basisVorauswahl.getMarke(),
                        aermelLaenge,
                        schnitt,
                        verschlussArtComboBox.getValue(),
                        wasserdichtCheckBox.isSelected(),
                        futterMaterialComboBox.getValue()
                );
                neuerMantel.setAnmerkung(basisVorauswahl.getAnmerkung());
                neuerMantel.setMaterial(basisVorauswahl.getMaterial());
                neuerMantel.setStyle(basisVorauswahl.getStyle());

                AddKleidungsstueckToSchrank(neuerMantel);
                break;
            case "WinterJacke":
                WinterJacke neueWinterJacke = new WinterJacke(
                        basisVorauswahl.getBezeichnung(),
                        basisVorauswahl.getFarben(),
                        basisVorauswahl.getBedecktesKoerperteil(),
                        basisVorauswahl.getWetterLage(),
                        basisVorauswahl.getBildPfad(),
                        basisVorauswahl.getMarke(),
                        aermelLaenge,
                        schnitt,
                        verschlussArtComboBox.getValue(),
                        wasserdichtCheckBox.isSelected(),
                        futterMaterialComboBox.getValue()
                );
                neueWinterJacke.setAnmerkung(basisVorauswahl.getAnmerkung());
                neueWinterJacke.setMaterial(basisVorauswahl.getMaterial());
                neueWinterJacke.setStyle(basisVorauswahl.getStyle());

                AddKleidungsstueckToSchrank(neueWinterJacke);
                break;
            case "RegenJacke":
                RegenJacke neueRegenJacke = new RegenJacke(
                        basisVorauswahl.getBezeichnung(),
                        basisVorauswahl.getFarben(),
                        basisVorauswahl.getBedecktesKoerperteil(),
                        basisVorauswahl.getWetterLage(),
                        basisVorauswahl.getBildPfad(),
                        basisVorauswahl.getMarke(),
                        aermelLaenge,
                        schnitt,
                        verschlussArtComboBox.getValue(),
                        futterMaterialComboBox.getValue()
                );
                neueRegenJacke.setAnmerkung(basisVorauswahl.getAnmerkung());
                neueRegenJacke.setMaterial(basisVorauswahl.getMaterial());
                neueRegenJacke.setStyle(basisVorauswahl.getStyle());

                AddKleidungsstueckToSchrank(neueRegenJacke);
                break;
            case "SweatshirtJacke":
                SweatshirtJacke neueSweatshirtJacke = new SweatshirtJacke(
                        basisVorauswahl.getBezeichnung(),
                        basisVorauswahl.getFarben(),
                        basisVorauswahl.getBedecktesKoerperteil(),
                        basisVorauswahl.getWetterLage(),
                        basisVorauswahl.getBildPfad(),
                        basisVorauswahl.getMarke(),
                        aermelLaenge,
                        schnitt,
                        verschlussArtComboBox.getValue(),
                        wasserdichtCheckBox.isSelected(),
                        futterMaterialComboBox.getValue()
                );
                neueSweatshirtJacke.setAnmerkung(basisVorauswahl.getAnmerkung());
                neueSweatshirtJacke.setMaterial(basisVorauswahl.getMaterial());
                neueSweatshirtJacke.setStyle(basisVorauswahl.getStyle());
                AddKleidungsstueckToSchrank(neueSweatshirtJacke);
                break;
            case "UebergangsJacke":
                UebergangsJacke neueUebergangsJacke = new UebergangsJacke(
                        basisVorauswahl.getBezeichnung(),
                        basisVorauswahl.getFarben(),
                        basisVorauswahl.getBedecktesKoerperteil(),
                        basisVorauswahl.getWetterLage(),
                        basisVorauswahl.getBildPfad(),
                        basisVorauswahl.getMarke(),
                        aermelLaenge,
                        schnitt,
                        verschlussArtComboBox.getValue(),
                        wasserdichtCheckBox.isSelected(),
                        futterMaterialComboBox.getValue()
                );
                neueUebergangsJacke.setAnmerkung(basisVorauswahl.getAnmerkung());
                neueUebergangsJacke.setMaterial(basisVorauswahl.getMaterial());
                neueUebergangsJacke.setStyle(basisVorauswahl.getStyle());
                AddKleidungsstueckToSchrank(neueUebergangsJacke);
                break;
        }
        MainController main = ladeFxmlMitController("/GUI/FXML/Main.fxml", speichernButton);

    }
}
