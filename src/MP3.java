import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MP3 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Image icon = new Image("Images/Headphones.png");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/MP3.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MP3 Player");
        primaryStage.getIcons().add(icon);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}
