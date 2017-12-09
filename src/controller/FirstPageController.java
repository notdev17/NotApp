package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstPageController {

    @FXML
    public void getStartedButtonClicked(ActionEvent event) throws IOException {
        Parent compareAppParent = FXMLLoader.load(getClass().getResource("../fxml/CompareAppliances.fxml"));
        Scene compareAppScene = new Scene(compareAppParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(compareAppScene);

        window.show();

    }

    /**
     * @author Michelle
     * For getting back to tutorial page..
     */
    @FXML
    public void tutorialButtonClicked(ActionEvent event) throws IOException{
        Parent tutorialParent = FXMLLoader.load(getClass().getResource("../fxml/Tutorial.fxml"));
        Scene tutorialScene = new Scene(tutorialParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tutorialScene);

        window.show();
    }
}
