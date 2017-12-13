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

    /**
     * returns back to the compare appliances screen when the back button is pressed
     * By: Daylen
     * @param event
     * @throws IOException
     */
    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        //load the fxml file
        Parent compareAppParent = FXMLLoader.load(getClass().getResource("../fxml/CompareAppliances.fxml"));
        Scene compareAppScene = new Scene(compareAppParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //set the scene as the fxml
        window.setScene(compareAppScene);
        window.show();

    }

    /**
     * closes the window when the done button that is clicked
     * By: Daylen
     * @param event
     * @throws IOException
     */
    @FXML
    public void doneButtonClicked(ActionEvent event) throws IOException {
        //get the window from the action event
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //close the window
        window.close();
    }
}
