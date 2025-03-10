import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DatePickerController {
    @FXML
    private DatePicker myDatePicker;
    @FXML
    private Label myLabel;

    public void getDate(ActionEvent event) {
        LocalDate myDate = myDatePicker.getValue();
        String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
        myLabel.setText(myFormattedDate);
    }
}
