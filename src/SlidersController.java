import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class SlidersController implements Initializable {
    @FXML
    private Label myLabel;
    @FXML
    private Slider mySlider;

    int myTemp;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myTemp = (int) mySlider.getValue();
        myLabel.setText(Integer.toString(myTemp) + "°C");
        mySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                myTemp = (int) mySlider.getValue();
                myLabel.setText(Integer.toString(myTemp) + "°C");
            }
        });
    }
}
