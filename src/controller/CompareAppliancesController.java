package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CompareAppliancesController {

    @FXML
    public void createApplianceButtonClicked(ActionEvent event) throws IOException {
        Parent compareAppParent = FXMLLoader.load(getClass().getResource("../fxml/SearchAppliance.fxml"));
        Scene compareAppScene = new Scene(compareAppParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(compareAppScene);

        window.show();
    }

    /**
     * @author Michelle
     * For getting back to calculations result page.. NEEDS TO LOAD SAVINGS PAGE ACCORDINGLY
     */
    @FXML
    public void calculateSavingsButtonClicked(ActionEvent event) throws IOException {
        Parent calcSumParent = FXMLLoader.load(getClass().getResource("../fxml/CalculationsSummary.fxml"));
        Scene calcSumScene = new Scene(calcSumParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(calcSumScene);

        window.show();
    }

}
