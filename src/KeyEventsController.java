import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class KeyEventsController {
    public void moveUp() {
        System.out.println("MOVIN' UP!");
    }

    public void moveDown() {
        System.out.println("MOVIN' DOWN!");
    }

    public void moveLeft() {
        System.out.println("MOVIN' LEFT!");
    }

    public void moveRight() {
        System.out.println("MOVIN' RIGHT!");
    }
}
