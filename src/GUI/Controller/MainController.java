package GUI.Controller;
import JSONHandling.JSONReaderKleidungstuecke;
import KleidungsKlassen.KleidungsContainer;
import KleidungsKlassen.Kleidungsstueck;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Logik.FilterLogik;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.util.ArrayList;

import static JSONHandling.JSONReaderKleidungstuecke.ReadKleidungsJSON;
import static Logik.ProgramSpeicher.getSchrank;
import static Logik.ProgramSpeicher.setSchrank;

public class MainController extends BasisController {
    // Fuer Das Anlagen der Kleidungstuecke
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
    @FXML private ImageView kleidungsImage;

    // Kleidungstücke Suchen
    @FXML private ComboBox<String> sucheKleidungsArtComboBox;
    @FXML private ColorPicker      sucheFarbeColorPicker;
    @FXML private ComboBox<String> sucheMarkeComboBox;
    @FXML private Button           sucheButton;
    @FXML private TableView<Kleidungsstueck> sucheTableView;
    @FXML private TableColumn<Kleidungsstueck, String> sucheSpalteBezeichnung;
    @FXML private TableColumn<Kleidungsstueck, String> sucheSpalteArt;
    @FXML private TableColumn<Kleidungsstueck, String> sucheSpalteMarke;
    @FXML private TableColumn<Kleidungsstueck, String> sucheSpalteFarbe;
    @FXML private Button           zuOutfitButton;

    private final ObservableList<Kleidungsstueck> sucheErgebnisListe = FXCollections.observableArrayList();

    // Farben, Material und Style können mehrfach hinzugefügt werden
    private ArrayList<String> gewaehlteFarben = new ArrayList<>();
    private ArrayList<String> gewaehlteMaterialien = new ArrayList<>();
    private ArrayList<String> gewaehlteStyles = new ArrayList<>();

    // Farben, Material und Style können mehrfach hinzugefügt werden
    private final ArrayList<String> farbenListe   = new ArrayList<>();
    private final ArrayList<String> materialListe = new ArrayList<>();
    private final ArrayList<String> styleListe    = new ArrayList<>();

    FileChooser fileChooser = new FileChooser();

    @FXML
    public void initialize() {
        if (getSchrank() == null) {
            try {
                KleidungsContainer geladen = getSchrank();
                setSchrank(geladen);
            } catch (Exception e) {
                // Logging von Feheler
                System.err.println("Fehler beim Lesen der JSON im MainController: " + e.getMessage());
                e.printStackTrace();
            }
        }
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
    private void konfiguriereSucheTableView() {
        if (sucheSpalteBezeichnung == null) return;
        sucheSpalteBezeichnung.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getBezeichnung()));
        sucheSpalteArt.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getClass().getSimpleName()));
        sucheSpalteMarke.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getMarke() != null ? cell.getValue().getMarke() : ""));
        sucheSpalteFarbe.setCellValueFactory(cell -> {
            String[] f = cell.getValue().getFarben();
            if (f != null && f.length > 0) {
                return new SimpleStringProperty(String.join(", ", f));
            }
            return new SimpleStringProperty("");
        });
        sucheTableView.setItems(sucheErgebnisListe);
    }

    @FXML
    private void handleSuche() {
        KleidungsContainer container = getSchrank();
        if (container == null) {
            zeigeDialog("Keine Kleidungsdaten gefunden.");
            sucheErgebnisListe.clear();
            return;
        }
        ArrayList<Kleidungsstueck> alle = sammleAlleKleidungsstuecke(container);
        FilterLogik filterLogik = new FilterLogik();

        String art = sucheKleidungsArtComboBox.getValue();
        if (art != null && !art.isBlank()) {
            String bedecktesKoerperteil = mapArtZuBedecktesKoerperteil(art);
            if (bedecktesKoerperteil != null) {
                filterLogik.addFilter("bedeckteskoerperteil", bedecktesKoerperteil);
            }
        }
        Color farbe = sucheFarbeColorPicker.getValue();
        if (farbe != null && !farbe.equals(Color.WHITE)) {
            filterLogik.addFilter("farben", farbe.toString());
        }
        String marke = sucheMarkeComboBox.getValue();
        if (marke != null && !marke.isBlank()) {
            filterLogik.addFilter("marke", marke.trim());
        }

        ArrayList<Kleidungsstueck> ergebnis = filterLogik.anwenden(alle);
        sucheErgebnisListe.clear();
        sucheErgebnisListe.addAll(ergebnis);
        zeigeDialog("Gefunden: " + ergebnis.size() + " Kleidungsstück(e).");
    }

    private String mapArtZuBedecktesKoerperteil(String art) {
        return switch (art) {
            case "Schuhe" -> "Füße";
            case "Oberteil" -> "Oberkörper";
            case "Unterteil" -> "Unterkörper";
            case "Kopfbedeckung" -> "Kopf";
            case "Einteiler" -> "Ganzkörper";
            default -> null;
        };
    }

    private ArrayList<Kleidungsstueck> sammleAlleKleidungsstuecke(KleidungsContainer c) {
        ArrayList<Kleidungsstueck> alle = new ArrayList<>();
        if (c.getKopfbedeckungen() != null) alle.addAll(c.getKopfbedeckungen());
        if (c.getUnterteile() != null) alle.addAll(c.getUnterteile());
        if (c.getEinteiler() != null) alle.addAll(c.getEinteiler());
        if (c.getSchuhe() != null) alle.addAll(c.getSchuhe());
        if (c.getOberteile() != null) alle.addAll(c.getOberteile());
        return alle;
    }

    @FXML
    private void handleZuOutfitHinzufuegen() {
        Kleidungsstueck ausgewaehlt = sucheTableView.getSelectionModel().getSelectedItem();
        if (ausgewaehlt == null) {
            zeigeDialog("Bitte zuerst ein Kleidungsstück aus der Liste auswählen.");
            return;
        }
        zeigeDialog("Zu Outfit hinzufügen: " + ausgewaehlt.getBezeichnung() + " – (Outfit-Logik noch nicht implementiert)");
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
    @FXML
    private void handleFileChooser() {
        fileChooser.setTitle("Bild auswählen");
        fileChooser.getExtensionFilters().setAll(
                new FileChooser.ExtensionFilter("Bilder", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        Stage stage = (Stage) bildPfadTextField.getScene().getWindow();
        java.io.File datei = fileChooser.showOpenDialog(stage);

        if (datei != null) {
            bildPfadTextField.setText(datei.getAbsolutePath());
            Image bild = new Image(datei.toURI().toString());
            kleidungsImage.setImage(bild);
        }
    }
}
