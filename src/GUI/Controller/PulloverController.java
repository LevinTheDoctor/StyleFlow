package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.KleidungsContainer;
import KleidungsKlassen.Pullover;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class PulloverController extends BasisController {

    @FXML private ComboBox<String> ausschnittArtComboBox;
    @FXML private ComboBox<String> strickArtComboBox;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;
    private int aermelLaenge;
    private String schnitt;

    @FXML
    public void initialize() {
        befuelleComboBox(ausschnittArtComboBox,
                "Rundhals", "V-Ausschnitt", "Boatneck", "Rollkragen"
        );
        befuelleComboBox(strickArtComboBox,
                "Glatt", "Rippen", "Zopf", "Noppen"
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
        if (!validiereComboBoxen(ausschnittArtComboBox, strickArtComboBox)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }

        Pullover neuerPullover = new Pullover(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                aermelLaenge,
                schnitt,
                ausschnittArtComboBox.getValue(),
                strickArtComboBox.getValue()
        );

        neuerPullover.setMarke(basisVorauswahl.getMarke());
        neuerPullover.setAnmerkung(basisVorauswahl.getAnmerkung());
        neuerPullover.setMaterial(basisVorauswahl.getMaterial());
        neuerPullover.setStyle(basisVorauswahl.getStyle());

        KleidungsContainer container = new KleidungsContainer();
        ArrayList<Pullover> pulloverListe = new ArrayList<>();
        pulloverListe.add(neuerPullover);
        container.setPullover(pulloverListe);

        new JSONWriterKleidungstuecke().JSONWrite(container);
        zeigeDialog("Pullover wurde erfolgreich gespeichert!");
    }
}
