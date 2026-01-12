import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // Hier wird das layout bestimmt
    private Parent createContent() {
        return new StackPane(new Text("Hello World"));

    }

    @Override
    public void start(Stage stage) {
        // Durch creatContent kann man start methide stander maessig verwenden
        Scene scene = new Scene(createContent());
        // Ab hier wird größe titel und icon festgelegt
        stage.setTitle("StyleFlow");
        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        stage.setHeight(500);
        stage.setWidth(800);
        //Scene wird zu stage hinzu gefuegt
        stage.setScene(scene);
        //Stage wird sichtbar immer am Ende!
        stage.show();
    }
}
