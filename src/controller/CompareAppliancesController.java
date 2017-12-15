package controller;

import appliance.Appliance;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CompareAppliancesController {

    private MasterController masterController;

    @FXML
    private TableView<Appliance> selectedTableView;

    ObservableList<Appliance> applianceList;

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
        //set up the columns in the table
        //priceColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("price"));
        brandColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("brand"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("model"));
        energyColumn.setCellValueFactory(new PropertyValueFactory<Appliance, String>("energy"));


        if (masterController == null)
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
        masterController.getFirstPage();
    }

    @FXML
    public void createApplianceButtonClicked(ActionEvent event) throws IOException {
        masterController.getSearchPage();
    }

    void setMasterController(MasterController mc)
    {
        masterController = mc;
    }

    void addAppliance(Appliance theAppliance)
    {
        selectedTableView.getItems().add(theAppliance);
    }
}
