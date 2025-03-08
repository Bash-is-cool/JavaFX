import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerScene1 {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField nameTextField;

    public void login(ActionEvent event) throws IOException {
        String username = nameTextField.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/ControllerScene2.fxml"));
        root = loader.load();

        ControllerScene2 controllerScene2 = loader.getController();
        controllerScene2.displayName(username);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
