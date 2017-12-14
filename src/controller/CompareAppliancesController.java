package controller;

import appliance.Appliance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class CompareAppliancesController {

    private MasterController masterController;

    @FXML
    private TableView<Appliance> myTableView;

    //columns in the table view
    @FXML
    private TableColumn<Appliance, String> brandColumn;
    @FXML
    private TableColumn<Appliance, String> modelColumn;
    @FXML
    private TableColumn<Appliance, String> energyColumn;

    @FXML
    Slider myUsageSlider;

    @FXML
    Button myCalculateButton;

    @FXML
    private void initialize()
    {
        if (myTableView.getSelectionModel().isEmpty())
        {
            myUsageSlider.setDisable(true);
            myCalculateButton.setDisable(true);
        }
        else
        {
            myUsageSlider.setDisable(false);
            myCalculateButton.setDisable(false);
        }
    }

    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        Parent compareAppParent = FXMLLoader.load(getClass().getResource("../fxml/FirstPage.fxml"));
        Scene compareAppScene = new Scene(compareAppParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(compareAppScene);

        window.show();
       }

    @FXML
    public void createApplianceButtonClicked(ActionEvent event) throws IOException {
        Parent compareAppParent = FXMLLoader.load(getClass().getResource("../fxml/SearchAppliance.fxml"));
        Scene compareAppScene = new Scene(compareAppParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(compareAppScene);

        window.show();
        System.out.println("This button works!");
    }

    public void setMasterController(MasterController mc) {
        masterController = mc;
    }
}
