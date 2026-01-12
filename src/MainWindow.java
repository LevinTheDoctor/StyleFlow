import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("StyleFlow");
        Group root = new Group();
        Scene scene = new Scene(root);

        // Ab hier ist jedes Window gleich
        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        stage.setHeight(500);
        stage.setWidth(800);
        stage.setResizable(false);
        //Scene wird zu stage hinzu gefügt
        stage.setScene(scene);
        //Stage wird sichtbar immer am ende
        stage.show();
    }


}
