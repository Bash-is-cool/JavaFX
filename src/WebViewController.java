import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class WebViewController implements Initializable {
    @FXML
    private WebView webView;
    @FXML
    private TextField textField;

    private WebEngine engine;
    private String homePage;
    private double webZoom;
    private WebHistory history;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine = webView.getEngine();
        homePage = "www.google.com";
        textField.setText(homePage);
        webZoom = 1;
        loadPage();
    }

    public void loadPage() {
        engine.load("http://" + textField.getText());
    }

    public void refreshPage() {
        engine.reload();
    }

    public void zoomIn() {
        webView.setZoom(webZoom += 0.25);
    }

    public void zoomOut() {
        webView.setZoom(webZoom -= 0.25);
    }

    public void showHistory() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        for(WebHistory.Entry entry : entries) {
            //System.out.println(entry);
            System.out.println(entry.getUrl() + " " + entry.getLastVisitedDate());
        }
    }

    public void back() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(-1);
        textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }

    public void forward() {
        history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();
        history.go(1);
        textField.setText(entries.get(history.getCurrentIndex()).getUrl());
    }

    public void executeJS() {
        engine.executeScript("window.location = \"https://www.youtube.com\"");
    }
}
