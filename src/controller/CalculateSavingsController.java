package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculateSavingsController {



    @FXML
    private void initialize()
    {

    }

    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException
    {
        new FirstPageController().getCompareApplianceScreen(event);
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
