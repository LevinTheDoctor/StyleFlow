package GUI.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class BasisController {

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

    protected void zeigeDialog(String nachricht) {
        System.out.println(nachricht);
    }
}
