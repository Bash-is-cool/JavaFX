import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.Axis;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AnimationsController implements Initializable {
    @FXML
    private ImageView myImage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //translate
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(myImage);
        translate.setDuration(Duration.millis(1000));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setByX(250);
        translate.setByY(-250);
        translate.setAutoReverse(true);
        translate.play();

        //rotate
        RotateTransition rotate = new RotateTransition();
        rotate.setNode(myImage);
        rotate.setDuration(Duration.millis(500));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setAxis(Rotate.X_AXIS);
        rotate.setByAngle(360);
        rotate.setAutoReverse(true);
        rotate.play();

        //fade
        FadeTransition fade = new FadeTransition();
        fade.setNode(myImage);
        fade.setDuration(Duration.millis(500));
        fade.setCycleCount(FadeTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();

        //scale
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(myImage);
        scale.setDuration(Duration.millis(500));
        scale.setCycleCount(ScaleTransition.INDEFINITE);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setByX(2.0);
        scale.setByY(2.0);
        scale.setAutoReverse(true);
        scale.play();
    }
}
