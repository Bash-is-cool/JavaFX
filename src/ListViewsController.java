import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListViewsController implements Initializable {
    @FXML
    private ListView<String> myListView;
    @FXML
    private Label myLabel;

    String[] food = {"Pizza", "Sushi", "Ramen"};
    String currentFood;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myListView.getItems().addAll(food);
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                currentFood = myListView.getSelectionModel().getSelectedItem();
                myLabel.setText(currentFood);
            }
        });
    }

}
