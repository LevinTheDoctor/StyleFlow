package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.KleidungsContainer;
import KleidungsKlassen.TShirt;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class TShirtController extends BasisController {

    @FXML private ComboBox<String> ausschnittArtComboBox;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;
    private int aermelLaenge;
    private String schnitt;

    @FXML
    public void initialize() {
        befuelleComboBox(ausschnittArtComboBox,
                "Rundhals", "V-Ausschnitt", "Boatneck", "Halter", "Träger"
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
        if (!validiereComboBoxen(ausschnittArtComboBox)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }

        TShirt neuesTShirt = new TShirt(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                aermelLaenge,
                schnitt,
                ausschnittArtComboBox.getValue()
        );

        neuesTShirt.setMarke(basisVorauswahl.getMarke());
        neuesTShirt.setAnmerkung(basisVorauswahl.getAnmerkung());
        neuesTShirt.setMaterial(basisVorauswahl.getMaterial());
        neuesTShirt.setStyle(basisVorauswahl.getStyle());

        KleidungsContainer container = new KleidungsContainer();
        ArrayList<TShirt> tshirtsListe = new ArrayList<>();
        tshirtsListe.add(neuesTShirt);
        container.setTshirts(tshirtsListe);

        new JSONWriterKleidungstuecke().JSONWrite(container);
        zeigeDialog("T-Shirt wurde erfolgreich gespeichert!");
    }
}
