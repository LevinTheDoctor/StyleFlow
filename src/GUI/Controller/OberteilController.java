package GUI.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class OberteilController extends BasisController {

    @FXML private TextField aermelLaengeTextField;
    @FXML private ComboBox<String> schnittComboBox;
    @FXML private ComboBox<String> artOberteilComboBox;
    @FXML private Button weiterButton;

    private BasisVorauswahl basisVorauswahl;

    @FXML
    public void initialize() {
        befuelleComboBox(schnittComboBox,
                "Eng", "Normalfit", "Locker", "Oversized"
        );
        befuelleComboBox(artOberteilComboBox,
                "T-Shirt", "Polo", "Hemd", "Top", "Pullover", "Hoodie", "Jacke"
        );
    }

    public void setBasisVorauswahl(BasisVorauswahl vorauswahl) {
        this.basisVorauswahl = vorauswahl;
    }

    @FXML
    private void handleWeiter() {
        if (!validiereComboBoxen(schnittComboBox, artOberteilComboBox)) {
            zeigeDialog("Bitte alle Felder ausfüllen.");
            return;
        }
        if (!validiereTextFelder(aermelLaengeTextField)) {
            zeigeDialog("Bitte Ärmellänge eingeben.");
            return;
        }

        int aermelLaenge;
        try {
            aermelLaenge = Integer.parseInt(aermelLaengeTextField.getText().trim());
        } catch (NumberFormatException e) {
            zeigeDialog("Bitte eine gültige Zahl für die Ärmellänge eingeben.");
            return;
        }

        String fxmlPfad = switch (artOberteilComboBox.getValue()) {
            case "T-Shirt"  -> "/GUI/FXML/TShirt.fxml";
            case "Polo"     -> "/GUI/FXML/Polo.fxml";
            case "Hemd"     -> "/GUI/FXML/Hemd.fxml";
            case "Top"      -> "/GUI/FXML/Top.fxml";
            case "Pullover" -> "/GUI/FXML/Pullover.fxml";
            case "Hoodie"   -> "/GUI/FXML/Hoodie.fxml";
            case "Jacke"    -> "/GUI/FXML/Jacke.fxml";
            default -> null;
        };

        if (fxmlPfad == null) return;

        String schnitt = schnittComboBox.getValue();
        switch (artOberteilComboBox.getValue()) {
            case "T-Shirt" -> {
                TShirtController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setVorauswahl(basisVorauswahl, aermelLaenge, schnitt);
            }
            case "Polo" -> {
                PoloController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setVorauswahl(basisVorauswahl, aermelLaenge, schnitt);
            }
            case "Hemd" -> {
                HemdController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setVorauswahl(basisVorauswahl, aermelLaenge, schnitt);
            }
            case "Top" -> {
                TopController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setVorauswahl(basisVorauswahl, aermelLaenge, schnitt);
            }
            case "Pullover" -> {
                PulloverController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setVorauswahl(basisVorauswahl, aermelLaenge, schnitt);
            }
            case "Hoodie" -> {
                HoodieController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setVorauswahl(basisVorauswahl, aermelLaenge, schnitt);
            }
            case "Jacke" -> {
                JackeController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setVorauswahl(basisVorauswahl, aermelLaenge, schnitt);
            }
        }
    }
}
