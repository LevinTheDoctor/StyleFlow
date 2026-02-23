package GUI.Controller;

import JSONHandling.JSONWriterKleidungstuecke;
import KleidungsKlassen.KleidungsContainer;
import KleidungsKlassen.Sneaker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class SneakerController extends BasisController {

    @FXML private ComboBox<String> technologieComboBox;
    @FXML private Button speichernButton;

    private BasisVorauswahl basisVorauswahl;
    private String absatzHoehe;
    private String verschlussArt;

    @FXML
    public void initialize() {
        befuelleComboBox(technologieComboBox,
                "Air", "Boost", "React", "Gel", "EVA", "Standard"
        );
    }

    public void setVorauswahl(BasisVorauswahl basisVorauswahl, String absatzHoehe, String verschlussArt) {
        this.basisVorauswahl = basisVorauswahl;
        this.absatzHoehe = absatzHoehe;
        this.verschlussArt = verschlussArt;
    }

    @FXML
    private void handleSpeichern() {
        if (!validiereBildPfad(basisVorauswahl.getBildPfad())) return;
        if (!validiereComboBoxen(technologieComboBox)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }

        Sneaker neueSneaker = new Sneaker(
                basisVorauswahl.getBezeichnung(),
                basisVorauswahl.getFarben(),
                basisVorauswahl.getBedecktesKoerperteil(),
                basisVorauswahl.getWetterLage(),
                basisVorauswahl.getBildPfad(),
                absatzHoehe,
                verschlussArt,
                technologieComboBox.getValue()
        );

        neueSneaker.setMarke(basisVorauswahl.getMarke());
        neueSneaker.setAnmerkung(basisVorauswahl.getAnmerkung());
        neueSneaker.setMaterial(basisVorauswahl.getMaterial());
        neueSneaker.setStyle(basisVorauswahl.getStyle());

        KleidungsContainer container = new KleidungsContainer();
        ArrayList<Sneaker> sneakerListe = new ArrayList<>();
        sneakerListe.add(neueSneaker);
        container.setSneakers(sneakerListe);

        new JSONWriterKleidungstuecke().JSONWrite(container);
        zeigeDialog("Sneaker wurden erfolgreich gespeichert!");
    }
}
