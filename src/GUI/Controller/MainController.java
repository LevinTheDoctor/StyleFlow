package GUI.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class MainController extends BasisController {

    @FXML private ComboBox<String> kleidungsArtComboBox;
    @FXML private ComboBox<String> bedecktesKoerperteilComboBox;
    @FXML private ComboBox<String> temperaturComboBox;
    @FXML private ComboBox<String> wetterLageComboBox;
    @FXML private TextField bezeichnungTextField;
    @FXML private TextField anmerkungTextField;
    @FXML private TextField markeTextField;
    @FXML private TextField bildPfadTextField;
    @FXML private TextField MatriealTF;
    @FXML private TextField StyleTF;
    @FXML private ColorPicker farbeColorPicker;
    @FXML private Button weiterButton;
    @FXML private Button StyleButton;
    @FXML private Button MaterialButton;
    @FXML private Button FarbenButton;
    @FXML private Label FarbenArray;
    @FXML private Label MaterialArray;
    @FXML private Label StyleArray;

    // Die Listen zum Speichern
    private ArrayList<String> gewaehlteFarben = new ArrayList<>();
    private ArrayList<String> gewaehlteMaterialien = new ArrayList<>();
    private ArrayList<String> gewaehlteStyles = new ArrayList<>();

    // Farben, Material und Style können mehrfach hinzugefügt werden
    private final ArrayList<String> farbenListe   = new ArrayList<>();
    private final ArrayList<String> materialListe = new ArrayList<>();
    private final ArrayList<String> styleListe    = new ArrayList<>();

    @FXML
    public void initialize() {
        befuelleComboBox(kleidungsArtComboBox,
                "Schuhe", "Oberteil", "Unterteil", "Kopfbedeckung", "Einteiler"
        );
        befuelleComboBox(bedecktesKoerperteilComboBox,
                "Kopf", "Oberkörper", "Unterkörper", "Füße", "Ganzkörper"
        );
        befuelleComboBox(temperaturComboBox,
                "Kalt (<5°C)", "Kühl (5-15°C)", "Mild (15-20°C)", "Warm (>20°C)"
        );
        befuelleComboBox(wetterLageComboBox,
                "Sonnig", "Bewölkt", "Regnerisch", "Schnee", "Windig"
        );
    }

    // + Button für Farben
    @FXML
    private void handleFarbeHinzufuegen() {
        // Wir holen den Wert vom ColorPicker
        String farbe = farbeColorPicker.getValue().toString();
        if (!farbenListe.contains(farbe)) {
            farbenListe.add(farbe);
            // Wir setzen den Text in das Label "FarbenArray"
            FarbenArray.setText(String.join(", ", farbenListe));
        }
    }

    @FXML
    private void handleMaterialHinzufuegen() {
        String material = MatriealTF.getText();
        if (material != null && !material.isBlank()) {
            materialListe.add(material);
            MaterialArray.setText(String.join(", ", materialListe));
            MatriealTF.clear(); // Feld danach leeren ist benutzerfreundlicher
        }
    }

    @FXML
    private void handleStyleHinzufuegen() {
        String style = StyleTF.getText();
        if (style != null && !style.isBlank()) {
            styleListe.add(style);
            StyleArray.setText(String.join(", ", styleListe));
            StyleTF.clear();
        }
    }

    @FXML
    private void handleWeiter() {
        if (!validiereComboBoxen(kleidungsArtComboBox, bedecktesKoerperteilComboBox)) {
            zeigeDialog("Bitte Kleidungsart und bedecktes Körperteil auswählen.");
            return;
        }
        if (!validiereTextFelder(bezeichnungTextField)) {
            zeigeDialog("Bitte eine Bezeichnung eingeben.");
            return;
        }

        // Farbe aus ColorPicker falls Liste leer
        if (farbenListe.isEmpty()) {
            farbenListe.add(farbeColorPicker.getValue().toString());
        }

        String fxmlPfad = switch (kleidungsArtComboBox.getValue()) {
            case "Schuhe"        -> "/GUI/FXML/Schuhe.fxml";
            case "Oberteil"      -> "/GUI/FXML/Oberteil.fxml";
            case "Unterteil"     -> "/GUI/FXML/Unterteil.fxml";
            case "Kopfbedeckung" -> "/GUI/FXML/Kopfbedeckung.fxml";
            case "Einteiler"     -> "/GUI/FXML/Einteiler.fxml";
            default -> null;
        };

        if (fxmlPfad == null) return;

        BasisVorauswahl vorauswahl = new BasisVorauswahl(
                bezeichnungTextField.getText(),
                bedecktesKoerperteilComboBox.getValue(),
                wetterLageComboBox.getValue(),
                bildPfadTextField.getText(),
                markeTextField.getText(),
                anmerkungTextField.getText(),
                farbenListe.toArray(new String[0]),
                materialListe.toArray(new String[0]),
                styleListe.toArray(new String[0])
        );

        switch (kleidungsArtComboBox.getValue()) {
            case "Schuhe" -> {
                SchuheController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setBasisVorauswahl(vorauswahl);
            }
            case "Oberteil" -> {
                OberteilController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setBasisVorauswahl(vorauswahl);
            }
            case "Unterteil" -> {
                UnterteilController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setBasisVorauswahl(vorauswahl);
            }
            case "Kopfbedeckung" -> {
                KopfbedeckungController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setBasisVorauswahl(vorauswahl);
            }
            case "Einteiler" -> {
                EinteilerController next = ladeFxmlMitController(fxmlPfad, weiterButton);
                if (next != null) next.setBasisVorauswahl(vorauswahl);
            }
        }
    }
}
