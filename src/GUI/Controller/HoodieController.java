package GUI.Controller;

import KleidungsKlassen.Hoodie;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import java.util.ArrayList;

import static Logik.ProgramSpeicher.AddKleidungsstueckToSchrank;

public class HoodieController extends BasisController {

    @FXML private CheckBox hatTascheCheckBox;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;
    private int aermelLaenge;
    private String schnitt;

    @FXML
    public void initialize() {
        // Hoodie hat nur die Kangaroo-Tasche Checkbox
    }

    public void setVorauswahl(BasisVorauswahl basisVorauswahl, int aermelLaenge, String schnitt) {
        this.basisVorauswahl = basisVorauswahl;
        this.aermelLaenge = aermelLaenge;
        this.schnitt = schnitt;
    }

    @FXML
    private void handleSpeichern() {
        if (!validiereBildPfad(basisVorauswahl.getBildPfad())) return;
        Hoodie neuerHoodie = new Hoodie(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                basisVorauswahl.getMarke(),
                aermelLaenge,
                schnitt,
                hatTascheCheckBox.isSelected()
        );

        neuerHoodie.setMarke(basisVorauswahl.getMarke());
        neuerHoodie.setAnmerkung(basisVorauswahl.getAnmerkung());
        neuerHoodie.setMaterial(basisVorauswahl.getMaterial());
        neuerHoodie.setStyle(basisVorauswahl.getStyle());

        AddKleidungsstueckToSchrank(neuerHoodie);
        MainController main = ladeFxmlMitController("/GUI/FXML/Main.fxml", speichernButton);
    }
}
