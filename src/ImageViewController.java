import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ImageViewController {

    @FXML
    private ImageView myImageView;
    @FXML
    private Button myButton;

    Image myImage = new Image(getClass().getResourceAsStream("Images/java.jpg"));

    public void displayImage() {
        myImageView.setImage(myImage);
    }
}
