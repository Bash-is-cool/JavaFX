import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class KeyEvents extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/KeyEvents.fxml"));
        Parent root = loader.load();
        KeyEventsController controller = loader.getController();
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {
            switch(event.getCode()) {
                case UP:
                    controller.moveUp();
                    break;
                case DOWN:
                    controller.moveDown();
                    break;
                case LEFT:
                    controller.moveLeft();
                    break;
                case RIGHT:
                    controller.moveRight();
                    break;
                default:
                    break;
            }
        });

        /*scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()) {
                    case W:
                        controller.moveUp();
                        break;
                    case S:
                        controller.moveDown();
                        break;
                    case A:
                        controller.moveLeft();
                        break;
                    case D:
                        controller.moveRight();
                        break;
                    default:
                        break;
                }
            }
        });*/

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
