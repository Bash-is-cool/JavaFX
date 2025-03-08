import com.sun.nio.sctp.SendFailedNotification;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.*;

public class Stages extends Application {

    //Needs this method
    @Override
    public void start(Stage stage) throws Exception {
        //Stage stage = new Stage();
        Group root = new Group();
        Scene scene = new Scene(root, Color.BLACK);
        Image icon = new Image("BASH.png");
        stage.getIcons().add(icon);
        stage.setWidth(420);
        stage.setHeight(420);
        stage.setResizable(false);
        //stage.setX(50);
        //stage.setY(50);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("You can't escape unless you click q");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));

        stage.setTitle("Stage Demo Program w00t w00t");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}