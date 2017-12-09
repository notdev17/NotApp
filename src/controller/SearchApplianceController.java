package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchApplianceController {

    /**
     * @author Michelle
     * For getting back to comp appliance page.. NEEDS TO PLACE NEW APPLIANCE IN THERE
     */
    @FXML
    public void selectButtonClicked(ActionEvent event) throws IOException {
        Parent compareAppParent = FXMLLoader.load(getClass().getResource("../fxml/CompareAppliances.fxml"));
        Scene compareAppScene = new Scene(compareAppParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(compareAppScene);

        window.show();
    }
}
