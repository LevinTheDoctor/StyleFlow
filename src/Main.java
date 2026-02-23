import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/FXML/Main.fxml"));
            Scene scene = new Scene(root);

            stage.setTitle("StyleFlow");
            Image icon = new Image("icon.png");
            stage.getIcons().add(icon);
            stage.setHeight(500);
            stage.setWidth(800);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}