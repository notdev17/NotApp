package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class FrontPageController {

    @FXML
    public void getStartedButtonClicked(ActionEvent event) throws IOException{
        Parent getStartedParent = FXMLLoader.load(getClass().getResource("CompareAppliance.fxml"));
        Scene getStartedScene = new Scene(getStartedParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(getStartedScene);
        window.show();

    }
}
