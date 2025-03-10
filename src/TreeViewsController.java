import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class TreeViewsController implements Initializable {
    @FXML
    private TreeView<String> treeView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TreeItem<String> rootItem = new TreeItem<>("Files", new ImageView(new Image("Images/Fuecoco.png")));
        TreeItem<String> branchItem1 = new TreeItem<>("Pictures");
        TreeItem<String> branchItem2 = new TreeItem<>("Videos");
        TreeItem<String> branchItem3 = new TreeItem<>("Music");
        TreeItem<String> leafItem1 = new TreeItem<>("Picture 1");
        TreeItem<String> leafItem2 = new TreeItem<>("Picture 2");
        TreeItem<String> leafItem3 = new TreeItem<>("Video 1");
        TreeItem<String> leafItem4 = new TreeItem<>("Video 2");
        TreeItem<String> leafItem5 = new TreeItem<>("Music 1");
        TreeItem<String> leafItem6 = new TreeItem<>("Music 2");

        treeView.setShowRoot(false);
        treeView.setRoot(rootItem);
        rootItem.getChildren().addAll(branchItem1, branchItem2, branchItem3);
        branchItem1.getChildren().addAll(leafItem1, leafItem2);
        branchItem2.getChildren().addAll(leafItem3, leafItem4);
        branchItem3.getChildren().addAll(leafItem5, leafItem6);
    }

    public void selectItem() {
        TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
        if(item != null) {
            System.out.println(item.getValue());
        }
    }
}
