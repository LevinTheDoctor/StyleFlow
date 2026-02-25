package GUI.Controller;

import KleidungsKlassen.Kleidungsstueck;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static JSONHandling.JSONReaderKleidungstuecke.ReadKleidungsJSON;
import static Logik.ProgramSpeicher.getSchrank;
import static Logik.ProgramSpeicher.setSchrank;

public abstract class BasisController {

    @FXML
    public void initialize() {
        setSchrank(ReadKleidungsJSON());
    }
    protected void ladeFxml(String pfad, Node node) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(pfad));
            Parent root = loader.load();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            zeigeDialog("Fenster konnte nicht geladen werden: " + pfad);
        }
    }

    protected <T> T ladeFxmlMitController(String pfad, Node node) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(pfad));
            Parent root = loader.load();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
            return loader.getController();
        } catch (IOException e) {
            zeigeDialog("Fenster konnte nicht geladen werden: " + pfad);
            return null;
        }
    }

    protected boolean validiereComboBoxen(ComboBox<?>... comboBoxen) {
        for (ComboBox<?> box : comboBoxen) {
            if (box.getValue() == null) return false;
        }
        return true;
    }

    protected boolean validiereTextFelder(TextField... textFelder) {
        for (TextField feld : textFelder) {
            if (feld.getText() == null || feld.getText().isBlank()) return false;
        }
        return true;
    }

    protected boolean validiereBildPfad(String bildPfad) {
        if (bildPfad == null || bildPfad.isBlank()) {
            zeigeDialog("Bitte einen Bildpfad angeben.");
            return false;
        }
        return true;
    }

    protected void befuelleComboBox(ComboBox<String> comboBox, String... werte) {
        comboBox.getItems().addAll(werte);
    }
    protected void befuelleComboBox(ComboBox<String> comboBox, ArrayList<String> werte) {
        comboBox.getItems().addAll(werte);
    }
    protected void zeigeDialog(String nachricht) {
        System.out.println(nachricht);
    }

    protected void zeigeBild(ImageView imageView, Kleidungsstueck kleidungStuck) {
        if (kleidungStuck == null || kleidungStuck.getBildDateiPfad() == null) {
            imageView.setImage(null);
            return;
        }
        File BildDatei = new File(kleidungStuck.getBildDateiPfad());
        if (!BildDatei.exists()) {
            imageView.setImage(null);
            return;
        }
        imageView.setImage(new Image(BildDatei.toURI().toString()));
    }

    protected void zeigeBild(ImageView imageView, java.io.File datei) {
        if (datei != null && datei.exists()) {
            imageView.setImage(new Image(datei.toURI().toString()));
        } else {
            imageView.setImage(null);
        }
    }
}
