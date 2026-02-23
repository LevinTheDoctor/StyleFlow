package GUI;

import JSONHandling.JSONWriterKleidungstuecke;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import JSONHandling.JSONWriterKleidungstuecke.*;
import Logik.ProgramSpeicher;

public class JavaFXanwendung extends Application {

    public static void main(String[] args) {
        //Hier wird das programm gestartet unten wird die Start methode von launch überladen
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("FXML/Main.fxml"));
            Scene scene = new Scene(root);

            // Ab hier ist jedes Window gleich um gleiche größe titel und icon zu haben
            stage.setTitle("StyleFlow");
            Image icon = new Image("icon.png");
            stage.getIcons().add(icon);
            stage.setHeight(500);
            stage.setWidth(800);
            stage.setOnCloseRequest(e -> {
                JSONWriterKleidungstuecke.JSONWrite(ProgramSpeicher.getSchrank());
            });
            //Scene wird zu stage hinzu gefuegt
            stage.setScene(scene);
            //Stage wird sichtbar immer am Ende!
            stage.show();
        } catch(Exception e){
            e.printStackTrace();
        }

    }


}
