package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculateSavingsController {

    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        Parent compareAppParent = FXMLLoader.load(getClass().getResource("../fxml/CompareAppliances.fxml"));
        Scene compareAppScene = new Scene(compareAppParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(compareAppScene);

        window.show();

    }

    @FXML
    public void doneButtonClicked(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.close();
    }
}
